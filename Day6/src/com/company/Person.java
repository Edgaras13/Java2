package com.company;

public abstract class Person {

    private int personalID;
    private String name;
    private Gender gender;
    private int revenue;

    public Person(int personalID, String name, Gender gender) {
        this.personalID = personalID;
        this.name = name;
        this.gender = gender;
    }

    public Person(int personalID, String name, int revenue) {
        this.personalID = personalID;
        this.name = name;
        this.revenue = revenue;
    }

    public int getPersonalID() {
        return personalID;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getRevenue() {
        return revenue;
    }
}
