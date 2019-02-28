package project.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import project.CategoryRepository;
import project.Entry;
import project.EntryRepository;
import project.FileHandler;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class BudgetController implements Initializable {

    public ListView<String> incomeListView;
    public ListView<String> expenseListView;
    public TableView<Entry> tableView;
    public TableColumn amountColumn;
    public TableColumn dateColumn;
    public TableColumn descriptionColumn;
    public Label balanceLabel;
    public TableColumn categoryColumn;

    private Scene scene;
    private Parent parent;
    private Stage stage;

    static Entry selectedEntry;
    static int selectedEntryIndex;

    public void onNew(ActionEvent actionEvent) throws IOException {
        stage = new Stage();
        parent = FXMLLoader.load(getClass().getResource("/fxml/new.fxml"));
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Create a new entry...");
        stage.showAndWait();
        updateBalance();
    }

    public void onEdit(ActionEvent actionEvent)throws IOException{
        stage = new Stage();
        parent = FXMLLoader.load(getClass().getResource("/fxml/edit.fxml"));
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Edit an entry...");
        stage.showAndWait();
        updateBalance();
    }

    public void onDelete(ActionEvent actionEvent) throws IOException{
        stage = new Stage();
        parent = FXMLLoader.load(getClass().getResource("/fxml/delete.fxml"));
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Delete an entry");
        stage.showAndWait();
        updateBalance();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CategoryRepository.addExpenseCat("Bills");
        CategoryRepository.addExpenseCat("Medical");
        CategoryRepository.addExpenseCat("Groceries");
        CategoryRepository.addExpenseCat("Hobbies");
        CategoryRepository.addExpenseCat("Procreational");
        CategoryRepository.addIncomeCat("Salary");
        CategoryRepository.addIncomeCat("Donations");
        CategoryRepository.addIncomeCat("Loan");
        CategoryRepository.addIncomeCat("Side");
        CategoryRepository.addIncomeCat("Other");
        incomeListView.setItems(CategoryRepository.getIncomeList());
        expenseListView.setItems(CategoryRepository.getExpenseList());

        updateBalance();

        amountColumn.setCellValueFactory(new PropertyValueFactory<Entry, BigDecimal>("amount"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Entry, LocalDate>("date"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("description"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("category"));

        incomeListView.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> {
                    List<Entry> categoryList = EntryRepository.getIncomeList().stream()
                            .filter(e -> e.getCategory().equals(incomeListView.getSelectionModel().getSelectedItem()))
                            .collect(Collectors.toList());
                    ObservableList<Entry> observableList = FXCollections.observableArrayList();
                    observableList.addAll(categoryList);
                    tableView.setItems(observableList);
                })
        );

        expenseListView.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> {
                    List<Entry> categoryList = EntryRepository.getExpenseList().stream()
                            .filter(e -> e.getCategory().equals(expenseListView.getSelectionModel().getSelectedItem()))
                            .collect(Collectors.toList());
                    ObservableList<Entry> observableList = FXCollections.observableArrayList();
                    observableList.addAll(categoryList);
                    tableView.setItems(observableList);
                })
        );

        tableView.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> {
                    selectedEntry = tableView.getSelectionModel().getSelectedItem();
                    if (EntryRepository.getIncomeList().contains(selectedEntry)){
                        selectedEntryIndex = EntryRepository.getIncomeList().indexOf(selectedEntry);
                    }
                    else{
                        selectedEntryIndex = EntryRepository.getExpenseList().indexOf(selectedEntry);
                    }
                })
        );

        updateBalance();
    }

    private void updateBalance(){
        BigDecimal balance = BigDecimal.valueOf(0.00);
        for (Entry e: EntryRepository.getIncomeList()){
            balance = balance.add(e.getAmount());
        }
        for (Entry e: EntryRepository.getExpenseList()){
            balance = balance.subtract(e.getAmount());
        }

        balanceLabel.setText(balance.toString());
    }

    public void onIncomeTab(Event event) {
        incomeListView.getSelectionModel().select(0);
    }

    public void onExpensesTab(Event event) {
        expenseListView.getSelectionModel().select(0);
    }

    public void onClose(ActionEvent actionEvent) {
        balanceLabel.getScene().getWindow().hide();
    }

    public void onAbout(ActionEvent actionEvent) throws IOException{
        parent = FXMLLoader.load(getClass().getResource("/fxml/help.fxml"));
        stage = new Stage();
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("About");
        stage.show();
    }

    public void onSave(ActionEvent actionEvent) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        stage = new Stage();
        File selectedDirectory = directoryChooser.showDialog(stage);

        FileHandler fileHandler = new FileHandler();
        try {
            fileHandler.saveToDirectory(selectedDirectory);
        }
        catch (IOException e){
            System.out.println("File not found");
        }
    }

    public void onOpen(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        stage = new Stage();
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("JSON files","*.json"));
        File selectedFile = fileChooser.showOpenDialog(stage);


        FileHandler fileHandler = new FileHandler();
        try{
            Map<String, List<Entry>> map = fileHandler.readFile(selectedFile);
            ObservableList<Entry> tempIncome = FXCollections.observableArrayList();
            ObservableList<Entry> tempExpenses = FXCollections.observableArrayList();
            tempIncome.addAll(map.get("IncomeList"));
            tempExpenses.addAll(map.get("ExpensesList"));
            EntryRepository.setIncomeList(tempIncome);
            EntryRepository.setExpenseList(tempExpenses);
            updateBalance();
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
