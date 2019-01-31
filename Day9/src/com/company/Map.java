package com.company;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private List<Pair> pairList = new ArrayList<>();

    public void add(Object key, Object value){
        pairList.add(new Pair(key, value));
    }

    public Object get(Object key){
        for(Pair p: pairList){
            if (p.getKey().equals(key)){
                return p.getValue();
            }
        }
        return -1;
    }
}
