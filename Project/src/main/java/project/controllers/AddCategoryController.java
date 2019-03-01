package project.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import project.repositories.CategoryRepository;

public class AddCategoryController {
    public TextField categoryField;

    private boolean isIncome = true;

    public void onConfirm(ActionEvent actionEvent) {
        if (isIncome){
            CategoryRepository.addIncomeCat(categoryField.getText());
        }
        else{
            CategoryRepository.addExpenseCat(categoryField.getText());
        }
        categoryField.getScene().getWindow().hide();
    }

    public void onIncome(ActionEvent actionEvent) {
        isIncome = true;
    }

    public void onExpenses(ActionEvent actionEvent) {
        isIncome = false;
    }
}
