package com.company;

import java.util.ArrayList;
import java.util.List;

public class EmployersStatisticsService {

    private WorkplaceService workplaceService;

    public EmployersStatisticsService(WorkplaceService workplaceService) {
        this.workplaceService = workplaceService;
    }

    public List<Employer> getProfitableOrganizations(){
        List<Employer> res = new ArrayList<>();

        for (Employer p: workplaceService.getEmployers()){
            if (p.getRevenue() > 0){
                res.add(p);
            }
        }
        return res;
    }

    public List<Employer> getUnprofitableOrganizations(){
        List<Employer> res = new ArrayList<>();

        for (Employer p: workplaceService.getEmployers()){
            if (p.getRevenue() <= 0){
                res.add(p);
            }
        }
        return res;
    }
}
