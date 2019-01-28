package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        first();
//        second();
//        third();
//        fourth();
//        fifth();
//        sixth();
//        seventh();
//        eighth();
//        ninth();
//        tenth();
        fibonacci();
    }

    private static void first(){
        Scanner scn = new Scanner(System.in);
        int a;
        while (true) {
            System.out.println("Enter an integer between 1 and 12:");
            try {
                a = scn.nextInt();
                if (a > 0 && a < 13)
                    break;
                else
                    System.out.println("Incorrect number");
            }
            catch (Exception e){
                System.out.println("Incorrect input");
                scn.next();
            }
        }

        if (a % 2 == 0)
            even(a);
        else
            odd(a);
    }

    private static void even(int a){
        switch (a){
            case 2: System.out.println("February"); break;
            case 4: System.out.println("April"); break;
            case 6: System.out.println("June"); break;
            case 8: System.out.println("August"); break;
            case 10: System.out.println("October"); break;
            case 12: System.out.println("December"); break;
        }
    }

    private static void odd(int a){
        switch (a){
            case 1: System.out.println("January"); break;
            case 3: System.out.println("March"); break;
            case 5: System.out.println("May"); break;
            case 7: System.out.println("July"); break;
            case 9: System.out.println("September"); break;
            case 11: System.out.println("November"); break;
        }
    }

    private static void second(){
        Scanner scn = new Scanner(System.in);
        String[] names = new String[10];

        System.out.println("Enter ten names:");

        for (int i = 0; i < names.length; i++){
            names[i] = scn.next();
        }

        for(String s: names){
            System.out.println(s.toUpperCase() + "-" + s.length() + "-" + Arrays.asList(names).indexOf(s));
        }
    }

    private static void third(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter an integer:");
        int a = scn.nextInt();
        for (int i = 1; i <= a; i++){
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void fourth(){
        Scanner scn = new Scanner(System.in);
        int max = 0;
        int min = Integer.MAX_VALUE;
        int temp;
        System.out.println("Enter 10 integers:");
        for (int i = 0; i < 10; i++)
        {
            temp = scn.nextInt();
            if (temp > max)
                max = temp;
            else if(temp < min)
                min = temp;
        }
        System.out.println("Max: " + max + "\nMin: " + min);
    }

    private static void fifth(){
        Scanner scn = new Scanner(System.in);
        final double PIE = 3.14;
        double r;
        System.out.println("Enter radius:");
        r = scn.nextDouble();
        System.out.println("Perimeter: " + (2 * PIE * r));

    }

    private static void sixth(){
        Worker worker = new Worker(495, 50);
        worker.getInfo();
        worker.addSalary();
        worker.getInfo();
        worker.addWork(20);
        worker.getInfo();
    }

    private static void seventh(){
        Static s1 = new Static();
        Static s2 = new Static();
        Static s3 = new Static();
        Static s4 = new Static();
        Static s5 = new Static();
        Static.clear();
        Static s6 = new Static();
    }

    private static void eighth(){
        HashMap<Integer,String> map = new HashMap<>();
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter 5 key-value pairs:");
        for (int i = 0; i < 5; i++){
            map.put(scn.nextInt(),scn.next());
        }
        System.out.println("Do you want to check if map contains a specific key-value pair? y/n");
        if (scn.next().equals("y")) {
            System.out.println("k - look for key\nv - look for value");
            if (scn.next().equals("k")) {
                if (map.containsKey(scn.nextInt()))
                    System.out.println("Yes");
                else
                    System.out.println("no");
            } else if (scn.next().equals("v")) {
                if (map.containsValue(scn.next()))
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }
        }
        System.out.println("Enter a key:");
        System.out.println(map.get(scn.nextInt()));

        for (Integer key: map.keySet() ){
            System.out.println("Key: " + key + "\nValue: " + map.get(key));
        }
    }

    private static void ninth(){
        Person person = new Person("Edgaras", "Bytautas");
        System.out.println(person.toString());
    }

    private static void tenth(){
        A a = new A();
        B b = new B();
        a.getX().methodX();
        b.methodX();
    }

    private static void fibonacci(){
        Scanner scn = new Scanner(System.in);
        List<Integer> fib = new ArrayList<>();
        System.out.println("Enter fibonacci limit:");
        int lim = scn.nextInt();
        fib.add(0);
        fib.add(1);
        fib.add(1);
        while(fib.get(fib.size() - 1) < lim){
            fib.add((fib.get(fib.size() - 1)) + (fib.get(fib.size() - 2)));
        }
        fib.remove(fib.size() - 1);
        for (Integer i: fib){
            System.out.print(i + " ");
        }

    }
}