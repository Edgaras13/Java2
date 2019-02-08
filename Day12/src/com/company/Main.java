package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Transaction> transactions = Transaction.transactions(10);
//        print(transactions);
        print(transactions.stream()
                .filter(t -> t.getId() % 2 == 0 && t.getAmount() > 1008)
                .collect(Collectors.toList()));

        print(transactions.stream()
                .collect(Collectors.toMap(Transaction::getId, Transaction::getAmount))
                .entrySet());
    }

    private static void print(Collection values){
        for (Object o: values){
            System.out.println(o);
        }
        System.out.println("--------------------------------------------------------------------");
    }
}
