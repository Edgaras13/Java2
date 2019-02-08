package com.company;

import org.ajbrown.namemachine.Name;
import org.ajbrown.namemachine.NameGenerator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
//        new NameGenerator().generateNames(new Scanner(System.in).nextInt()).forEach(System.out::println);
        int count = 0;
        for (Name n: new NameGenerator().generateNames(new Scanner(System.in).nextInt())){
            System.out.println(count++ + ": " + n);
        }
    }
}
