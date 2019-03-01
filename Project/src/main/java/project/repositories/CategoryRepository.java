package project.repositories;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import project.Entry;

import java.util.List;
import java.util.stream.Collectors;

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

    public static void deleteIncomeCat(String category){
        List<Entry> list =  EntryRepository.getIncomeList().stream()
                                .map(e -> (e.getCategory().equals(category))? e.setCategoryAndReturn("Other") : e)
                                .collect(Collectors.toList());
        ObservableList<Entry> oList = FXCollections.observableArrayList();
        oList.addAll(list);
        EntryRepository.setIncomeList(oList);
        incomeList.remove(category);
    }

    public static void deleteExpenseCat(String category){
        List<Entry> list = EntryRepository.getExpenseList().stream()
                                .map(e -> (e.getCategory().equals(category))? e.setCategoryAndReturn("Other") : e)
                                .collect(Collectors.toList());
        ObservableList<Entry> oList = FXCollections.observableArrayList();
        oList.addAll(list);
        EntryRepository.setExpenseList(oList);
        expenseList.remove(category);
    }

    public static void setIncomeList(ObservableList<String> incomeList) {
        CategoryRepository.incomeList = incomeList;
    }

    public static void setExpenseList(ObservableList<String> expenseList) {
        CategoryRepository.expenseList = expenseList;
    }
}
