package com.company;

import java.util.Random;

public class NetworkConnecter{
    private Random random = new Random();
    private int count = 1;

    public void send(Email email)throws NoNetworkException{
        if (email.getState() == State.NEW) {
            System.out.println("Sending email to " + email.getRecipient());
        }
        else{
            System.out.println("Sending email to " + email.getRecipient() + " (Try number " + ++count + ")");
        }

        if (random.nextInt(2) == 0){
            System.out.println("Email to " + email.getRecipient() + " delivered\n");
            count = 1;
        }
        else{
            System.out.println("Failed to send an email to " + email.getRecipient() + "\n");
            throw new NoNetworkException();
        }
    }
}
