package com.company;

public class Coniferous implements Tree{
    @Override
    public void has() {
        System.out.println("The " + getClass().getName().replace("com.company.","").toLowerCase() + " has spikes");
    }
}
