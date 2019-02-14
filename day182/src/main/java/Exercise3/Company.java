package Exercise3;

import java.io.Serializable;

public class Company {
    private String name;
    private int code;
    private int workerCount;
    private double avgSalary;

    public Company(String name, int code, int workerCount, double avgSalary)  {
        this.name = name;
        this.code = code;
        this.workerCount = workerCount;
        this.avgSalary = avgSalary;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public int getWorkerCount() {
        return workerCount;
    }

    public double getAvgSalary() {
        return avgSalary;
    }
}
