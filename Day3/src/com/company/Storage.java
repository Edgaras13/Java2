package com.company;

public interface Storage {
    public void saveInfo(Info info);

    public Info findInfo(Integer id);

    public Info findInfo(String word);
}
