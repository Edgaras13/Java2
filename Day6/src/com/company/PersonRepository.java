package com.company;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

    public static List<Person> getPersons(){
        List<Person> persons = new ArrayList<>();

        Person person1 = PrivatePerson.createNewPerson(EmploymentStatus.EMPLOYED,1,"Antanas",Gender.MALE);
        Person person2 = PrivatePerson.createNewPerson(EmploymentStatus.UNEMPLOYED, 2, "Stanislovas", Gender.MALE);
        Person person3 = PrivatePerson.createNewPerson(EmploymentStatus.EMPLOYED, 3, "Marija", Gender.FEMALE);
        Person person4 = PrivatePerson.createNewPerson(EmploymentStatus.UNEMPLOYED, 4, "Ruta", Gender.FEMALE);
        Person person5 = new LegalPerson(5,"UAB HEY", 100);
        Person person6 = new LegalPerson(6, "UAB Runkelis", -110);
        ((LegalPerson) person5).addEmployee((Employee) person1);
        ((LegalPerson) person6).addEmployee((Employee) person3);

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        persons.add(person6);

        return persons;
    }
}
