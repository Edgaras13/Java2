package com.company.Excercise2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Y> list = new ArrayList<>();
        X x1 = new X();
        X x2 = new X();
        X x3 = new X();
        X x4 = new X();
        X x5 = new X();

        Random random = new Random();

        x1.addNumber(random.nextInt(101), random.nextInt(101), random.nextInt(101));
        x2.addNumber(random.nextInt(101), random.nextInt(101), random.nextInt(101));
        x3.addNumber(random.nextInt(101), random.nextInt(101), random.nextInt(101));
        x4.addNumber(random.nextInt(101), random.nextInt(101), random.nextInt(101));
        x5.addNumber(random.nextInt(101), random.nextInt(101), random.nextInt(101));

        x1.order(true);
        x2.order(true);
        x3.order(true);
        x4.order(true);
        x5.order(true);

        Y y1 = new Y();
        y1.addX(x1,x2,x3);
        y1.order(true);
        Y y2 = new Y();
        y2.addX(x1,x2, x4);
        y2.order(true);
        Y y3 = new Y();
        y3.addX(x3,x4,x5);
        y3.order(true);
        Y y4 = new Y();
        y4.addX(x2,x3,x4);
        y4.order(true);
        Y y5 = new Y();
        y5.addX(x3,x2,x5);
        y5.order(true);

        list.add(y1);
        list.add(y2);
        list.add(y3);
        list.add(y4);
        list.add(y5);

        Collections.sort(list, Comparator.comparing(Y::fullSum));

        for (Y y: list){
            System.out.println(y + " " + y.fullSum());
        }

    }
}
