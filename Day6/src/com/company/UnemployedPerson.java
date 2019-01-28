package com.company;

public class UnemployedPerson extends PrivatePerson{

    private EmploymentStatus employmentStatus = EmploymentStatus.UNEMPLOYED;

    public UnemployedPerson(int personalID, String name, Gender gender) {
        super(personalID, name, gender);
    }

    @Override
    public EmploymentStatus getEmploymentStatus() {
        return employmentStatus;
    }
}
