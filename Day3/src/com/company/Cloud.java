package com.company;

import java.util.ArrayList;
import java.util.List;

public class Cloud implements Storage {
    List<Info> infoList = new ArrayList<>();

    public void saveInfo(Info info){
        infoList.add(info);
    }

    public Info findInfo(Integer id){
        for (Info i: infoList){
            if (i.getId() == id){
                System.out.println("Found info by id " + id + " in cloud");
                return i;
            }
        }
        return null;
    }

    public Info findInfo(String word){
        for(Info i: infoList){
            if (i.doesTextContain(word)){
                System.out.println("Found info by word " + word + " in cloud");
                return i;
            }
        }
        return null;
    }
}
