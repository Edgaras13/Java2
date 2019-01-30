package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        File filePeople = new File("D:\\Projects\\Java2\\Day8\\src\\com\\company\\people.txt");
        File filePayments = new File("D:\\Projects\\Java2\\Day8\\src\\com\\company\\payments.txt");
        File fileResSent = new File("D:\\Projects\\Java2\\Day8\\src\\com\\company\\resultSent.txt");
        File fileResReceived = new File("D:\\Projects\\Java2\\Day8\\src\\com\\company\\resultReceived.txt");
        BufferedReader reader;
        BufferedWriter writer;
        Scanner scn = returnScanner(filePeople);
        Map<Integer, Person> personMap = new HashMap<>();
        Map<Integer, Payment> paymentMap = new HashMap<>();
        int id;

        scn.nextLine();


        while (scn.hasNextLine()){
            id = Integer.parseInt(scn.next());
            personMap.put(id,new Person(id, scn.next(), scn.next()));
        }
        scn.close();

        try{
            reader = new BufferedReader(new FileReader(filePayments));
            String line;
            reader.readLine();
            while((line = reader.readLine()) != null){
                Scanner scn2 = new Scanner(line).useDelimiter("\\s*, \\s*");
                id = Integer.parseInt(scn2.next());
                paymentMap.put(id, new Payment(id, Integer.parseInt(scn2.next()), Integer.parseInt(scn2.next()), Integer.parseInt(scn2.next())));
            }
            reader.close();
        }
        catch (Exception e){
            System.out.println("Error!");
        }

        for (Payment p: paymentMap.values()){
            for (Person pp: personMap.values()){
                if (pp.getId() == p.getRecipientID()){
                    pp.addReceivedMoney(p.getAmount());
                }
                if (pp.getId() == p.getSenderID()){
                    pp.addSentMoney(p.getAmount());
                }
            }
        }
        List<Person> res = new ArrayList<>(personMap.values());
        try{
            Collections.sort(res,Comparator.comparing(Person::getReceivedMoney));
            Collections.reverse(res);
            writer = new BufferedWriter(new FileWriter(fileResReceived));
            for (Person p: res){
                writer.write(p.getName() + " " + p.getSurname() + " id: " + p.getId() + " received " + p.getReceivedMoney() + "$ in total\r\n");
            }
            writer.close();

        }
        catch (Exception e){
            System.out.println("Error!");
        }

        try{
            Collections.sort(res, Comparator.comparing(Person::getSentMoney));
            Collections.reverse(res);
            writer = new BufferedWriter(new FileWriter(fileResSent));
            for (Person p: res){
                writer.write(p.getName() + " " + p.getSurname() + " id: " + p.getId() + " sent " + p.getSentMoney() + "$ in total\r\n");
            }
            writer.close();
        }
        catch (Exception e){
            System.out.println("Error!");
        }

    }

    private static Scanner returnScanner(File file){
        try {
            return new Scanner(file).useDelimiter("\\s*, \\s*|\\n");
        }
        catch (FileNotFoundException e){
            System.out.println("\"people.txt\" not found!");
            return null;
        }
    }
}
