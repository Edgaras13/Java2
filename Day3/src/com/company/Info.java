package com.company;

public class Info {
    private Integer id;
    private String text;

    public Info(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    public boolean doesTextContain(String word){
        return text.contains(word);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
