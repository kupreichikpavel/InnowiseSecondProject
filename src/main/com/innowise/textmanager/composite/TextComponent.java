package com.innowise.textmanager.composite;

import java.util.List;

public abstract class TextComponent {
    public void add(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    public String getText() {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }

    public List<TextComponent> getComponents() {
        throw new UnsupportedOperationException();
    }


}
