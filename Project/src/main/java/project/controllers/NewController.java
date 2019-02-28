package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import project.CategoryRepository;
import project.Entry;
import project.EntryRepository;

import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class NewController implements Initializable {
    public Button addButton;
    public TextArea descriptionArea;
    public DatePicker datePicker;
    public TextField amountField;
    public ComboBox<String> categoryCombo;
    public RadioButton incomeRadio;
    private boolean isIncome = true;

    public void onAdd(ActionEvent actionEvent) {
        String category = categoryCombo.getValue();
        BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(amountField.getText()));
        LocalDate date = datePicker.getValue();
        String description = descriptionArea.getText();
        Entry entry = new Entry(category, amount, date, description);

        if (isIncome){
            EntryRepository.addIncome(entry);
        }
        else{
            EntryRepository.addExpense(entry);
        }

        addButton.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        categoryCombo.setItems(CategoryRepository.getIncomeList());
    }

    public void onIncomeRadio(ActionEvent actionEvent) {
        isIncome = true;
        categoryCombo.setItems(CategoryRepository.getIncomeList());
    }

    public void onExpenseRadio(ActionEvent actionEvent) {
        isIncome = false;
        categoryCombo.setItems(CategoryRepository.getExpenseList());
    }
}
