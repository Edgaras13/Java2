package com.company;

import java.util.Scanner;

public class Input {
    public static int input(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter an integer:");
        try {
            return scn.nextInt();
        }
        catch (Exception e){
            System.out.println("Invalid input\n");
            return input();
        }
    }
}
