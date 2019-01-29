package com.company;

import java.util.List;

public class EmailSender {

    public static void sendEmail(List<Email> list){
        NetworkConnecter networkConnecter = new NetworkConnecter();
        for (Email e: list){
            while(e.getState() != State.SENT) {
                try {
                    networkConnecter.send(e);
                    e.setState(State.SENT);
                } catch (NoNetworkException n) {
                    e.setState(State.SEND_AGAIN);
                    try {
                        Thread.sleep(3000);
                    }
                    catch (Exception ex){
                        System.out.println("Sleep interrupted");
                    }
                }
            }
        }
    }
}
