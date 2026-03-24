package com.innowise.textmanager.composite;

import java.util.ArrayList;
import java.util.List;

import static com.innowise.textmanager.entity.TextType.SPACE_SYMBOL;
import static com.innowise.textmanager.parser.TextParser.WORD_PATTERN;


public class Sentence extends TextComponent {
    private List<TextComponent> lexemes = new ArrayList<>();

    @Override
    public void add(TextComponent component) {
        lexemes.add(component);
    }

    @Override
    public String getText() {
        StringBuilder builder = new StringBuilder();

        for (TextComponent component : lexemes) {
            String part = component.getText();

            if (!builder.isEmpty() && WORD_PATTERN.matcher(part).matches()) {
                builder.append(SPACE_SYMBOL);
            }
            builder.append(part);
        }
        return builder.toString();
    }

    @Override
    public void print() {
        System.out.print(getText());
    }

    @Override
    public List<TextComponent> getComponents() {
        return lexemes;
    }
}
