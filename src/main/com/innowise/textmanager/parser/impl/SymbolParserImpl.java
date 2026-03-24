package com.innowise.textmanager.parser.impl;


import com.innowise.textmanager.composite.Symbol;
import com.innowise.textmanager.composite.TextComponent;
import com.innowise.textmanager.parser.TextParser;

public class SymbolParserImpl extends AbstractTextParserImpl {


    public SymbolParserImpl(TextParser nextParser) {
        super(nextParser);
    }

    @Override
    public TextComponent parse(String text) {
        return new Symbol(text.charAt(0));
    }
}