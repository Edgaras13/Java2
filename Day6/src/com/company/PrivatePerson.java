package com.company;

public abstract class PrivatePerson extends Person{

    public PrivatePerson(int personalID, String name, Gender gender) {
        super(personalID, name, gender);
    }

    public abstract EmploymentStatus getEmploymentStatus();

    public static PrivatePerson createNewPerson(EmploymentStatus employmentStatus, int personalID, String name, Gender gender){

        if(employmentStatus.equals(EmploymentStatus.EMPLOYED)){
            return new EmployedPerson(personalID,name,gender);
        }
        else{
            return new UnemployedPerson(personalID,name,gender);
        }
    }
}
