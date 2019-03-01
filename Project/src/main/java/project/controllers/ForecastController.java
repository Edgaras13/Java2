package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import project.Entry;
import project.repositories.EntryRepository;

import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ForecastController implements Initializable {
    public Label forecastBalanceLabel;

    public void onOk(ActionEvent actionEvent) {
        forecastBalanceLabel.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Entry> lastMonthIncome = EntryRepository.getIncomeList().stream()
                .filter(e -> e.getDate().atStartOfDay().isBefore(LocalDateTime.now().withDayOfMonth(1)) && e.getDate().atStartOfDay().isAfter(LocalDateTime.now().minusMonths(1).withDayOfMonth(1)))
                .collect(Collectors.toList());

        List<Entry> lastMonthExpenses = EntryRepository.getExpenseList().stream()
                .filter(e -> e.getDate().atStartOfDay().isBefore(LocalDateTime.now().withDayOfMonth(1)) && e.getDate().atStartOfDay().isAfter(LocalDateTime.now().minusMonths(1).withDayOfMonth(1)))
                .collect(Collectors.toList());

        List<Entry> lastLastMonthIncome = EntryRepository.getIncomeList().stream()
                .filter(e -> e.getDate().atStartOfDay().isBefore(LocalDateTime.now().minusMonths(1).withDayOfMonth(1)) && e.getDate().atStartOfDay().isAfter(LocalDateTime.now().minusMonths(2).withDayOfMonth(1)))
                .collect(Collectors.toList());

        List<Entry> lastLastMonthExpenses = EntryRepository.getExpenseList().stream()
                .filter(e -> e.getDate().atStartOfDay().isBefore(LocalDateTime.now().minusMonths(1).withDayOfMonth(1)) && e.getDate().atStartOfDay().isAfter(LocalDateTime.now().minusMonths(2).withDayOfMonth(1)))
                .collect(Collectors.toList());

        BigDecimal tempBalance = BigDecimal.ZERO;

        for (Entry e: lastMonthIncome){
            tempBalance = tempBalance.add(e.getAmount());
        }

        for (Entry e: lastMonthExpenses){
            tempBalance = tempBalance.subtract(e.getAmount());
        }

        for (Entry e: lastLastMonthIncome){
            tempBalance = tempBalance.add(e.getAmount());
        }

        for (Entry e: lastLastMonthExpenses){
            tempBalance = tempBalance.subtract(e.getAmount());
        }

        tempBalance = tempBalance.divide(BigDecimal.valueOf(2));

        BigDecimal minForecastBalance = tempBalance.multiply(BigDecimal.valueOf(0.9));
        BigDecimal maxForecastBalance = tempBalance.multiply(BigDecimal.valueOf(1.1));

        forecastBalanceLabel.setText(minForecastBalance + " - " + maxForecastBalance);
        forecastBalanceLabel.setLayoutX(100);
        forecastBalanceLabel.setLayoutY(30);
    }
}
