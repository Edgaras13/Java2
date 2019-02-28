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

public class EditController implements Initializable {

    public TextField amountField;
    public RadioButton incomeRadio;
    public ComboBox categoryCombo;
    public DatePicker datePicker;
    public TextArea descriptionArea;
    public Button cancelButton;
    public Button saveButton;
    public RadioButton expenseRadio;

    private boolean isIncome;
    private boolean initialIsIncome;

    public void onIncomeRadio(ActionEvent actionEvent) {
        isIncome = true;
        categoryCombo.setItems(CategoryRepository.getIncomeList());
    }

    public void onExpenseRadio(ActionEvent actionEvent) {
        isIncome = false;
        categoryCombo.setItems(CategoryRepository.getExpenseList());
    }

    public void onSave(ActionEvent actionEvent) {
        String category = categoryCombo.getValue().toString();
        BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(amountField.getText()));
        LocalDate date = datePicker.getValue();
        String description = descriptionArea.getText();
        Entry entry = new Entry(category, amount, date, description);
        if (isIncome == initialIsIncome) {
            if (isIncome) {
                EntryRepository.getIncomeList().set(BudgetController.selectedEntryIndex, entry);
            } else {
                EntryRepository.getExpenseList().set(BudgetController.selectedEntryIndex, entry);
            }
        }
        else{
            if (isIncome) {
                EntryRepository.removeExpense(BudgetController.selectedEntry);
                EntryRepository.addIncome(entry);
            } else {
                EntryRepository.removeIncome(BudgetController.selectedEntry);
                EntryRepository.addExpense(entry);
            }
        }
        amountField.getScene().getWindow().hide();
    }

    public void onCancel(ActionEvent actionEvent) {
        amountField.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (CategoryRepository.getIncomeList().contains(BudgetController.selectedEntry.getCategory())){
            incomeRadio.setSelected(true);
            initialIsIncome = true;
            isIncome = true;
            categoryCombo.setItems(CategoryRepository.getIncomeList());
        }
        else{
            expenseRadio.setSelected(true);
            initialIsIncome = false;
            isIncome = false;
            categoryCombo.setItems(CategoryRepository.getExpenseList());
        }

        amountField.setText(BudgetController.selectedEntry.getAmount().toString());
        datePicker.setValue(BudgetController.selectedEntry.getDate());
        descriptionArea.setText(BudgetController.selectedEntry.getDescription());
        categoryCombo.setValue(BudgetController.selectedEntry.getCategory());
    }
}
