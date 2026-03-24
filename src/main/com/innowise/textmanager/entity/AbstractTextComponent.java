package com.innowise.textmanager.entity;

public abstract class AbstractTextComponent {
    private TextType textType;

    public AbstractTextComponent(TextType textType) {
        this.textType = textType;
    }
}
