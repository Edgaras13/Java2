package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import project.repositories.CategoryRepository;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteCategoryController implements Initializable {
    public ComboBox categoryCombo;

    private boolean isIncome = true;

    public void onConfirm(ActionEvent actionEvent) {
        if (isIncome){
            CategoryRepository.deleteIncomeCat(categoryCombo.getSelectionModel().getSelectedItem().toString());
        }
        else{
            CategoryRepository.deleteExpenseCat(categoryCombo.getSelectionModel().getSelectedItem().toString());
        }
        categoryCombo.getScene().getWindow().hide();
    }

    public void onIncome(ActionEvent actionEvent) {
        isIncome = true;
        categoryCombo.setItems(CategoryRepository.getIncomeList());
    }

    public void onExpenses(ActionEvent actionEvent) {
        isIncome = false;
        categoryCombo.setItems(CategoryRepository.getExpenseList());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        categoryCombo.setItems(CategoryRepository.getIncomeList());
    }
}
