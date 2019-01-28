package com.company;

public abstract class PrivatePerson {
    abstract boolean getEmploymentStatus();

    static PrivatePerson getPrivatePerson(long personalID, String name, Gender gender, String type){
        if (type.equals("employed")){
            return new EmployedPerson();
        }
    }
}
