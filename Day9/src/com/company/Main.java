package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.company.DnsProvider.CLOUDFLARE;
import static com.company.DnsProvider.GOOGLE;

public class Main {

    public static void main(String[] args) {

//        Integer[] intArr = {1, 2, 3};
//        String[] stringArr = {"Hello", "World"};
//        Boolean[] boolArr = {true, true, false};
//        Byte[] byteArr = {0,0,1,0,1};
//        printArrays(intArr, stringArr, boolArr, byteArr);
//        printArray(stringArr);
        /////////////////////////////////////
//        Pine pine = new Pine();
//        Juniper juniper = new Juniper();
//        Spruce spruce = new Spruce();
//        Oak oak = new Oak();
//        Birch birch = new Birch();
//
//        List<Tree> variedList = Arrays.asList(pine, juniper, spruce, oak, birch);
//        variedForest(variedList);
//        List<Coniferous> coniferousList = Arrays.asList(pine, juniper, spruce);
//        coniferousForest(coniferousList);
//        List<Birch> birchList = Arrays.asList(birch, new Birch(), new Birch());
//        birchForest(birchList);
        /////////////////////////////////////
//        Map<DnsProvider,DnsServer> dnsMap = new Map<>();
//        dnsMap.add(GOOGLE, new DnsServer("8.8.8.8", "8.8.4.4"));
//        dnsMap.add(CLOUDFLARE, new DnsServer("1.1.1.1", "1.0.0.1"));
//        System.out.println(dnsMap.get(GOOGLE));
//        System.out.println(dnsMap.get(CLOUDFLARE));
//        Map<String, String> stringMap = new Map<>();
//        stringMap.add("Hello", "World");
//        stringMap.add("Sveikas", "Pasauli");
//        System.out.println(stringMap.get("Hello"));
//        System.out.println(stringMap.get("Sveikas"));
        /////////////////////////////////////
        ListOfNumbers list1 = new ListOfNumbers();
        ListOfNumbers list2 = new ListOfNumbers();
        ListOfNumbers list3 = new ListOfNumbers();
        ListOfNumbers list4 = new ListOfNumbers();

        list1.addNumber(1.0);
        list1.addNumber(2.0);
        list1.addNumber(3.0);

        list1.addNumber(2.7);
        list1.addNumber(12.3);
        list1.addNumber(3.1);

        list1.addNumber(7.0);
        list1.addNumber(1.2);
        list1.addNumber(14.9);

        list1.addNumber(6.3);
        list1.addNumber(4.2);
        list1.addNumber(9.1);

        findWithMaxAverage(list1, list2, list3, list4);
    }

    private static void printArrays(Object[]... arr){
        for (Object[] a: arr){
            for (Object b: a){
                System.out.println(b);
            }
        }
    }

    private static <T> void printArray(T[] arr){
        for (T t: arr){
            System.out.println(t);
        }
    }

    private static void variedForest(List<?> list){
        System.out.println("Varied forest:");
        for (Object t: list){
            ((Tree) t).has();
        }
        System.out.println();
    }

    private static void coniferousForest(List<? extends Coniferous> list){
        System.out.println("Coniferous forest:");
        for (Object c: list){
            ((Tree) c).has();
        }
        System.out.println();
    }

    private static void birchForest(List<? extends Birch> list){
        System.out.println("Birch forest:");
        for (Object b: list){
            ((Tree) b).has();
        }
        System.out.println();
    }

    private static void findWithMaxAverage(ListOfNumbers... arr){
        for (ListOfNumbers l: arr){
            System.out.println(l);
        }
    }
}
