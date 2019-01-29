package com.company;

public class Device {
    private boolean isOn = false;
    private int id;
    private static int idCount = 0;

    public Device() {
        this.id = idCount++;
    }

    public void turnOnOff(){
        if (isOn){
            isOn = false;
        }
        else{
            isOn = true;
        }
    }

    public void ping() throws  DeviceIsOffException{
        if (!isOn){
            throw new DeviceIsOffException();
        }
    }

    public int getId() {
        return id;
    }
}
