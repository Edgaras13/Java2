package com.company.GenericsExcercise5;

public class Main {

    public static void main(String[] args) {
        SuperPair<Integer, String, Integer> superPair1 = new SuperPair<>(15,"Hello", 20);
        SuperPair<Integer, Boolean, Double> superPair2 = new SuperPair<>(72,false, 4.2);

        try{
            SuperPair<String, Byte, String> superPair3 = new SuperPair<String, Byte, String>("Hey", 1, " ya");
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}