package com.company;

import java.util.ArrayList;
import java.util.List;

public class Map <K, V> {
    private List<Pair<K, V>> pairList = new ArrayList<>();

    public void add(K key, V value){
        pairList.add(new Pair(key, value));
    }

    public V get(K key){
        for(Pair p: pairList){
            if (p.getKey().equals(key)){
                return (V) p.getValue();
            }
        }
        return null;
    }
}
