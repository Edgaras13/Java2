package project.repositories;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import project.Entry;

public class EntryRepository {

    private static ObservableList<Entry> incomeList = FXCollections.observableArrayList();
    private static ObservableList<Entry> expenseList = FXCollections.observableArrayList();

    public static ObservableList<Entry> getIncomeList() {
        return incomeList;
    }

    public static void addIncome(Entry e){
        incomeList.add(e);
    }

    public static ObservableList<Entry> getExpenseList() {
        return expenseList;
    }

    public static void addExpense(Entry e){
        expenseList.add(e);
    }

    public static void removeIncome(Entry e){
        incomeList.remove(e);
    }

    public static void removeExpense(Entry e){
        expenseList.remove(e);
    }

    public static void setIncomeList(ObservableList<Entry> incomeList) {
        EntryRepository.incomeList = incomeList;
    }

    public static void setExpenseList(ObservableList<Entry> expenseList) {
        EntryRepository.expenseList = expenseList;
    }
}
