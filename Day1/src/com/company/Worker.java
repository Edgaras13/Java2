package com.company;

public class Worker {

    private int salary;
    private int work;

    public Worker() {
    }

    public Worker(int salary, int work) {
        this.salary = salary;
        this.work = work;
    }

    public void getInfo() {
        System.out.println("Salary: " + salary + "\nWork: " + work + " hrs");
    }

    public void addSalary(){
        if (this.salary <= 500)
            this.salary += 10;
    }

    public void addWork(int work) {
        this.work += work;
        this.salary += work * 5;
    }
}
