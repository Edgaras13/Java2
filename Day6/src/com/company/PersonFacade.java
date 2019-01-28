package com.company;

import java.util.ArrayList;
import java.util.List;

public class PersonFacade implements WorkplaceService, PersonEmploymentService{

    public List<PrivatePerson > getPrivatePersons(){
        List<PrivatePerson> res = new ArrayList<>();

        for (Person p: PersonRepository.getPersons()){
            if (p instanceof PrivatePerson){
                res.add((PrivatePerson) p);
            }
        }

        return res;
    }

    public List<LegalPerson> getLegalPersons(){
        List<LegalPerson> res = new ArrayList<>();

        for (Person p: PersonRepository.getPersons()){
            if (p instanceof LegalPerson){
                res.add((LegalPerson) p);
            }
        }

        return res;
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> res = new ArrayList<>();

        for (PrivatePerson p: getPrivatePersons()){
            if (p instanceof Employee){
                res.add((Employee) p);
            }
        }
        return res;
    }

    @Override
    public List<Employer> getEmployers() {
        List<Employer> res = new ArrayList<>();

        for (LegalPerson p: getLegalPersons()){
            res.add(p);
        }

        return res;
    }

    @Override
    public List<EmployedPerson> employedPersons() {
        List<EmployedPerson> res = new ArrayList<>();

        for (PrivatePerson p: getPrivatePersons()){
            if (p.getEmploymentStatus() == EmploymentStatus.EMPLOYED){
                res.add((EmployedPerson) p);
            }
        }
        return res;
    }

    @Override
    public List<UnemployedPerson> unemployedPersons() {
        List<UnemployedPerson> res = new ArrayList<>();

        for (PrivatePerson p: getPrivatePersons()){
            if (p.getEmploymentStatus() == EmploymentStatus.UNEMPLOYED){
                res.add((UnemployedPerson) p);
            }
        }
        return res;
    }

    public static void printPersons(){
        for(Person p: PersonRepository.getPersons()){
            if (p instanceof )
        }
    }
}
