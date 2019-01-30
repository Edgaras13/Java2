package com.company;

public class Person {
    private int id;
    private String name;
    private String surname;
    private int receivedMoney = 0;
    private int sentMoney = 0;

    public Person(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public void addReceivedMoney(int amount){
        receivedMoney += amount;
    }

    public void addSentMoney(int amount){
        sentMoney += amount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getReceivedMoney() {
        return receivedMoney;
    }

    public int getSentMoney() {
        return sentMoney;
    }
}
