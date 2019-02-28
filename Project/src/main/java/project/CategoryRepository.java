package project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CategoryRepository {

    private static ObservableList<String> incomeList = FXCollections.observableArrayList();
    private static ObservableList<String> expenseList = FXCollections.observableArrayList();

    public static ObservableList<String> getIncomeList() {
        return incomeList;
    }

    public static ObservableList<String> getExpenseList() {
        return expenseList;
    }

    public static void addIncomeCat(String category){
        incomeList.add(category);
    }

    public static void addExpenseCat(String category) {
        expenseList.add(category);
    }


}
