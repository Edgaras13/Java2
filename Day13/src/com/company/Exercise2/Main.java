package com.company.Exercise2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        PvmValidator pvmValidator = new PvmValidator();
        int[] code = new int[9];

        System.out.println("Enter a PVM code:");
        String tempCode = scn.next();
        if (tempCode.matches("\\D")){
            System.out.println("oh no");
        }
        scn.close();
        for (int i = 0; i < 9; i++){
            code[i] = Integer.parseInt(String.valueOf(tempCode.charAt(i)));
        }

        System.out.println(pvmValidator.checkPvmCode(code));
    }
}
