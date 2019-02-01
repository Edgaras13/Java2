package com.company.Excercise2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class X {
    private List<Integer> list = new ArrayList<>();

    public void order(boolean up){
        Collections.sort(list);
        if (!up){
            Collections.reverse(list);
        }
    }

    public void addNumber(Integer... arr){
        for (Integer i: arr){
            list.add(i);
        }
    }

    public Integer sum(){
        int sum = 0;
        for (Integer i: list){
            sum += i;
        }
        return sum;
    }

    @Override
    public String toString() {
        return "X{" +
                "list=" + list +
                '}';
    }
}
