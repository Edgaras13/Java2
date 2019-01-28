package com.company;

import java.util.ArrayList;
import java.util.List;

public class LegalPerson extends Person implements Employer{

    private List<Employee> employees = new ArrayList<>();
    private int revenue = 0;

    public LegalPerson(int personalID, String name, Gender gender) {
        super(personalID, name, gender);
    }

    public LegalPerson(int personalID, String name, int revenue) {
        super(personalID, name, revenue);
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    @Override
    public Gender getGender(){
        throw new UnsupportedOperationException("Legal person has no gender");
    }

    @Override
    public int getRevenue() {
        return revenue;
    }

    @Override
    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
