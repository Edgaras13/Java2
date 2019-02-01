package com.company.Excercise2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Y {
    private List<X> list = new ArrayList<>();

    public void addX(X... arr){
        for (X x: arr){
            list.add(x);
        }
    }

    public void order(boolean up){
        Collections.sort(list, Comparator.comparing(X::sum));
        if (!up){
            Collections.reverse(list);
        }
    }

    public Integer fullSum(){
        int sum = 0;
        for (X x: list){
            sum += x.sum();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Y{" +
                "list=" + list +
                '}';
    }
}
