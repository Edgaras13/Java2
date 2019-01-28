package com.company;

public class UnemployedPerson extends PrivatePerson {

    @Override
    boolean getEmploymentStatus() {
        return false;
    }
}
