package com.company;

public class Stat {
    private int females;
    private String country;
    private int age;
    private int males;
    private int year;
    private int total;

    public Stat(int females, String country, int age, int males, int year, int total) {
        this.females = females;
        this.country = country;
        this.age = age;
        this.males = males;
        this.year = year;
        this.total = total;
    }

    public int getFemales() {
        return females;
    }

    public void setFemales(int females) {
        this.females = females;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMales() {
        return males;
    }

    public void setMales(int males) {
        this.males = males;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Stat{" +
                "females=" + females +
                ", country='" + country + '\'' +
                ", age=" + age +
                ", males=" + males +
                ", year=" + year +
                ", total=" + total +
                '}';
    }
}
