package project.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import project.repositories.CategoryRepository;
import project.Entry;
import project.repositories.EntryRepository;
import project.FileHandler;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;
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
    public TabPane catTabPane;
    public Tab incomeTab;
    public Tab expensesTab;

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
        CategoryRepository.addExpenseCat("Other");
        CategoryRepository.addExpenseCat("All");
        CategoryRepository.addIncomeCat("Salary");
        CategoryRepository.addIncomeCat("Family");
        CategoryRepository.addIncomeCat("Donations");
        CategoryRepository.addIncomeCat("Loan");
        CategoryRepository.addIncomeCat("Found");
        CategoryRepository.addIncomeCat("Other");
        CategoryRepository.addIncomeCat("All");

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
                    if (incomeListView.getSelectionModel().getSelectedItem().equals("All")){
                        tableView.setItems(EntryRepository.getIncomeList());
                    }
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
                    if (expenseListView.getSelectionModel().getSelectedItem().equals("All")){
                        tableView.setItems(EntryRepository.getExpenseList());
                    }
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
        if(balance.compareTo(BigDecimal.ZERO) >= 0){
            balanceLabel.setStyle("-fx-text-fill: black;");
        }
        else{
            balanceLabel.setStyle("-fx-text-fill: red");
        }

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
            System.out.println(e);
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

            for (Entry e: tempIncome){
                if (!CategoryRepository.getIncomeList().contains(e.getCategory())){
                    CategoryRepository.addIncomeCat(e.getCategory());
                }
            }
            for (Entry e: tempExpenses){
                if (!CategoryRepository.getExpenseList().contains(e.getCategory())){
                    CategoryRepository.addExpenseCat(e.getCategory());
                }
            }
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

    public void onAddCategory(ActionEvent actionEvent) throws IOException{
        parent = FXMLLoader.load(getClass().getResource("/fxml/addCategory.fxml"));
        stage = new Stage();
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Add a new category...");
        stage.showAndWait();
    }

    public void onDeleteCategory(ActionEvent actionEvent) throws IOException{
        parent = FXMLLoader.load(getClass().getResource("/fxml/deleteCategory.fxml"));
        stage = new Stage();
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Delete a category...");
        stage.showAndWait();
    }

    public void onForecast(ActionEvent actionEvent) throws IOException{
        parent = FXMLLoader.load(getClass().getResource("/fxml/forecast.fxml"));
        stage = new Stage();
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Forecast");
        stage.showAndWait();
    }
}
