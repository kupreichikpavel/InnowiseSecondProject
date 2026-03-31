package com.innowise.textmanager.composite;


public abstract class AbstractTextComponent {
    private final TextType type;

    public AbstractTextComponent(TextType textType) {
        this.type = textType;
    }

    public TextType getType() {
        return type;
    }

    public abstract int getSize();

    public abstract int countSymbols();

    public abstract String toString();
}
