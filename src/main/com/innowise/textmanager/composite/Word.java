package com.innowise.textmanager.composite;

import java.util.ArrayList;
import java.util.List;

public class Word extends TextComponent {
    private List<TextComponent> symbols = new ArrayList<>();

    @Override
    public void add(TextComponent component) {
        symbols.add(component);
    }
    @Override
    public String getText() {
        StringBuilder builder = new StringBuilder();

        for (TextComponent symbol : symbols) {
            builder.append(symbol.getText());
        }

        return builder.toString();
    }

    @Override
    public void print() {
        System.out.print(getText());
    }

    @Override
    public List<TextComponent> getComponents() {
        return symbols;
    }
}