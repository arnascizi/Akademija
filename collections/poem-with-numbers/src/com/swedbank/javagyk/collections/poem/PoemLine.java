package com.swedbank.javagyk.collections.poem;

public class PoemLine {

    private int number;
    private String text;

    public PoemLine(int number, String text) {
        this.number = number;
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }
}
