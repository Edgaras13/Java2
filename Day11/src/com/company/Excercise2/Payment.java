package com.company.Excercise2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Payment {
    private int id;
    private String name = "";
    private LocalDate paymentDate;
    private int recipientId;
    private int senderId;


    public Payment(int id, String name, LocalDate paymentDate, int recipientId, int senderId) {
        this.id = id;
        this.name = name;
        this.paymentDate = paymentDate;
        this.recipientId = recipientId;
        this.senderId = senderId;
    }

    public static List<Payment> generatePaymentList(int amount){
        List<Payment> res = new ArrayList<>();
        int id;
        String name = "";
        LocalDate paymentDate;
        int recipientId;
        int senderId;
        final String alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
        Random random = new Random();
        String idS = "", recipientIdS = "", senderIdS = "";
        for (int j = 0; j < amount; j++) {
            for (int i = 0; i < 8; i++) {
                idS += random.nextInt(10);
                recipientIdS += random.nextInt(10);
                senderIdS += random.nextInt(10);
                name += alphabet.charAt(random.nextInt(alphabet.length()));
            }
            id = Integer.parseInt(idS);
            recipientId = Integer.parseInt(recipientIdS);
            senderId = Integer.parseInt(senderIdS);
            paymentDate = LocalDate.now().minusDays(random.nextInt(32)).minusMonths(random.nextInt(13)).minusYears(random.nextInt(21));
            res.add(new Payment(id,name,paymentDate,recipientId,senderId));
            idS = "";
            recipientIdS = "";
            senderIdS = "";
            name = "";
        }
        return res;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", paymentDate=" + paymentDate +
                ", recipientId=" + recipientId +
                ", senderId=" + senderId +
                '}';
    }
}
