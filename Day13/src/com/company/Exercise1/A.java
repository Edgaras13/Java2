package com.company.Exercise1;

import com.company.Exercise1.Package1.B;
import com.company.Exercise1.Package1.C;
import com.company.Exercise1.Package1.D;

public class A {
    public static void main(String[] args) {
        System.out.println("From class A:");
        B.methodZ();
        System.out.println("From class B:");
        B.test();
        System.out.println("From class C:");
        C.test();
        System.out.println("From class D:");
        D.test();
    }
}
