package com.company;

public class Static {

    private static int count = 0;

    public Static() {
        System.out.println(count++);
    }

    public static void clear(){
        System.out.println(count);
        count = 0;
    }
}
