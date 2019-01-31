package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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
}
