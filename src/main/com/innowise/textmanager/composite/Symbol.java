package com.innowise.textmanager.composite;


import java.util.List;

public class Symbol extends TextComponent {

    private char value;

    public Symbol(char value) {
        this.value = value;
    }

    @Override
    public String getText() {
        return String.valueOf(value);
    }

    @Override
    public void print() {
        System.out.print(value);
    }

}
