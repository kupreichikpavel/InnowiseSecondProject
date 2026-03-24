package com.innowise.textmanager.composite;

import java.util.ArrayList;
import java.util.List;

import static com.innowise.textmanager.entity.TextType.SPACE_SYMBOL;

public class Paragraph extends TextComponent {

    private List<TextComponent> sentences = new ArrayList<>();

    @Override
    public void add(TextComponent component) {
        sentences.add(component);
    }

    @Override
    public String getText() {
        StringBuilder builder = new StringBuilder();
        for (TextComponent component : sentences) {
            builder.append(component.getText()).append(SPACE_SYMBOL);
        }
        return builder.toString().trim();
    }

    @Override
    public void print() {
        System.out.println(getText());
    }

    @Override
    public List<TextComponent> getComponents() {
        return sentences;
    }
}