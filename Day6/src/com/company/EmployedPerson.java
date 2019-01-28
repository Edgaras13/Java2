package com.company;

public class EmployedPerson extends PrivatePerson implements Employee{

    private EmploymentStatus employmentStatus= EmploymentStatus.EMPLOYED;
    private int salary = 0;
    public EmployedPerson(int personalID, String name, Gender gender) {
        super(personalID, name, gender);
    }

    @Override
    public EmploymentStatus getEmploymentStatus() {
        return employmentStatus;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public String getEmployerName() {
        for (Person p: PersonRepository.getPersons()){
            if (p instanceof Employer && ((Employer) p).getEmployees().contains(this)){
                return ((Employer) p).g
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Employed person:\n" + getName() + "\n" + get;
    }
}
