package com.company;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        numberFive();
//        numberFourteen();

        int i = 0;
        boolean b = i > 1;
        System.out.println(b);
    }

    private static void numberFive(){
        Scanner scn = new Scanner(System.in);
        int a = 1;
        while(a >= 0){
            System.out.println("Enter a number:");
            a = scn.nextInt();
        }
    }

    private static void numberFourteen(){
        Scanner scn = new Scanner(System.in);
        LocalTime time = LocalTime.parse(scn.nextLine());
        time = time.plusHours(2).plusMinutes(15);
        System.out.println(time);
        if (time.isBefore(LocalTime.now())){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
