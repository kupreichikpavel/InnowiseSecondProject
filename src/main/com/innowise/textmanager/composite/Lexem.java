package com.innowise.textmanager.composite;

import java.util.ArrayList;
import java.util.List;


public class Lexem extends TextComponent {
    private List<TextComponent> words = new ArrayList<>();

    @Override
    public void add(TextComponent component) {
        words.add(component);
    }

    @Override
    public String getText() {
        StringBuilder builder = new StringBuilder();

        for (TextComponent word : words) {
            builder.append(word.getText());
        }

        return builder.toString();
    }

    @Override
    public void print() {
        System.out.print(getText());
    }

    @Override
    public List<TextComponent> getComponents() {
        return words;
    }
}