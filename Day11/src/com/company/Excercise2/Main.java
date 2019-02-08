package com.company.Excercise2;

public class Main {

    public static void main(String[] args) {
        for (Payment p: Payment.generatePaymentList(100)){
            System.out.println(p);
        }
    }
}
