package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        System.out.println(Input.input());
//        List<Device> list = new ArrayList<>();
//        Device phone = new Phone();
//        Device pc = new PC();
//        Device speaker = new Speaker();
//
//        Random random = new Random();
//        int a = random.nextInt(2), b = random.nextInt(2), c = random.nextInt(2);
//
//        for(int i = 0; i < a; i++){
//            phone.turnOnOff();
//        }
//
//        for (int i = 0; i < b; i++){
//            pc.turnOnOff();
//        }
//
//        for (int i = 0; i < c; i++){
//            speaker.turnOnOff();
//        }
//
//        list.add(phone);
//        list.add(pc);
//        list.add(speaker);
//
//
//        Monitoring.pingAllDevices(list);
        Email email1 = new Email("111", "aaa@gmail.com");
        Email email2 = new Email("222", "bbb@gmail.com");
        Email email3 = new Email("333", "ccc@gmail.com");
        Email email4 = new Email("444", "ddd@gmail.com");
        Email email5 = new Email("555", "eee@gmail.com");

        List<Email> list = new ArrayList<>();
        list.add(email1);
        list.add(email2);
        list.add(email3);
        list.add(email4);
        list.add(email5);

        EmailSender.sendEmail(list);
    }
}