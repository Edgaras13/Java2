package com.company;

public class Payment {
    private int id;
    private int amount;
    private int recipientID;
    private int senderID;

    public Payment(int id, int amount, int recipientID, int senderID) {
        this.id = id;
        this.amount = amount;
        this.recipientID = recipientID;
        this.senderID = senderID;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public int getRecipientID() {
        return recipientID;
    }

    public int getSenderID() {
        return senderID;
    }
}
