package com.company;

import java.util.ArrayList;
import java.util.List;

public class ListOfNumbers {
    private List<Double> list= new ArrayList<>();

    public void addNumber(Double number){
        list.add(number);
    }

    public Double getAverage(){
        Double sum = 0.0;
        for (Double number: list){
            sum += number;
        }
        return sum / list.size();
    }

    @Override
    public String toString() {
        return "ListOfNumbers{" +
                "list=" + list +
                '}';
    }
}
