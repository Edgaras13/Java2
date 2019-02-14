package Edgaras;

import org.apache.commons.lang3.RandomStringUtils;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private Currency currency;
    private Person user;

    public BankAccount(double balance, Currency currency, Person user) {
        this.balance = balance;
        this.currency = currency;
        this.user = user;
        generateAccountNubmer();
    }

    public BankAccount(Currency currency, Person user) {
        this.currency = currency;
        this.user = user;
        this.balance = 0;
        generateAccountNubmer();
    }

    public double getBalance() {
        return balance;
    }

    public void add(Double amount){
        balance += amount;
    }

    public boolean charge(Double amount){
        if (balance >= amount){
            balance -= amount;
            return true;
        }
        else{
            return false;
        }
    }

    private void generateAccountNubmer(){
        accountNumber = "LT" + RandomStringUtils.randomNumeric(18);
    }

    public Person getUser() {
        return user;
    }

    public Currency getCurrency() {
        return currency;
    }
}
