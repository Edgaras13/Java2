package com.company;

import java.util.List;

public class Monitoring {
    public static void pingAllDevices(List<Device> list){
        System.out.println("-----Pinging started-----");
        for (Device d: list){
            try{
                d.ping();
                System.out.println("Device " + d.getClass().getName() + " with id " + d.getId() + " is ON");
            }
            catch(DeviceIsOffException e){
                System.out.println("Device " + d.getClass().getName() + " with id " + d.getId() + " is OFF");
            }
        }
        System.out.println("-----Pinging finished-----");
    }
}
