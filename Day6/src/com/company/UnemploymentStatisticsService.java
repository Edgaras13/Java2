package com.company;

public class UnemploymentStatisticsService {

    private PersonEmploymentService personEmploymentService;

    public UnemploymentStatisticsService(PersonEmploymentService personEmploymentService) {
        this.personEmploymentService = personEmploymentService;
    }

    public int employedPersons(){
        return personEmploymentService.employedPersons().size();
    }

    public int unemployedPersons(){
        return personEmploymentService.unemployedPersons().size();
    }
}
