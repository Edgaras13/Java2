package com.company.GenericsExcercise5;

public class SuperPair<K, V, E extends Number> {
    private K key;
    private V value;
    private E number;

    public SuperPair(K key, V value, E number) {
        this.key = key;
        this.value = value;
        this.number = number;
    }
}
