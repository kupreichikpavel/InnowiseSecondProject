package com.innowise.textmanager.composite;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Text extends TextComponent {

    private List<TextComponent> paragraphs = new ArrayList<>();

    @Override
    public void add(TextComponent component) {
        paragraphs.add(component);
    }

    @Override
    public String getText() {
        StringBuilder builder = new StringBuilder();
        for (TextComponent paragraph : paragraphs) {
            builder.append(paragraph.getText()).append("\n");
        }
        return builder.toString().trim();
    }

    @Override
    public void print() {
        for (TextComponent paragraph : paragraphs) {
            paragraph.print();
        }
    }

    @Override
    public List<TextComponent> getComponents() {
        return paragraphs;
    }
}