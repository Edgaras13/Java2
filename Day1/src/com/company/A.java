package com.company;

public class A {
    private X x;

    public X getX() {
        return x;
    }

    public void setX(X x) {
        this.x = x;
    }

    public A() {
        this.x = new X();
    }
}
