package com.company;

import java.util.HashMap;

public class DataBase implements Storage {
    private HashMap<Integer, Info> infoMap = new HashMap<>();

    public void saveInfo(Info info){
        System.out.println("Info saved to database");
        infoMap.put(info.getId(),info);
    }

    public Info findInfo(Integer id){
        System.out.println("Found info by id: " + id);
        return infoMap.get(id);
    }

    public Info findInfo(String word){
        for(Info i: infoMap.values()){
            if (i.doesTextContain(word)){
                System.out.println("Found info by word: " + word);
                return i;
            }
        }
        return null;
    }
}
