package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import project.repositories.CategoryRepository;
import project.repositories.EntryRepository;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteController implements Initializable {
    public Label entryLabel;

    public void onYes(ActionEvent actionEvent) {
        if (CategoryRepository.getIncomeList().contains(BudgetController.selectedEntry.getCategory())){
            EntryRepository.removeIncome(BudgetController.selectedEntry);
        }
        else{
            EntryRepository.removeExpense(BudgetController.selectedEntry);
        }
        entryLabel.getScene().getWindow().hide();
    }

    public void onNo(ActionEvent actionEvent) {
        entryLabel.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String text = BudgetController.selectedEntry.getAmount() + "€, " + BudgetController.selectedEntry.getDate().toString();
        entryLabel.setText(text);
    }
}
