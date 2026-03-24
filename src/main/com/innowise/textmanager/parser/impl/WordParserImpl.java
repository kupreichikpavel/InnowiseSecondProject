package com.innowise.textmanager.parser.impl;

import com.innowise.textmanager.composite.TextComponent;
import com.innowise.textmanager.composite.Word;
import com.innowise.textmanager.parser.TextParser;

public class WordParserImpl extends AbstractTextParserImpl {

    public WordParserImpl(TextParser nextParser) {
        super(nextParser);
    }

    @Override
    public TextComponent parse(String text) {
        Word word = new Word();
        char[] symbols = text.toCharArray();
        for (char symbol : symbols) {
            word.add(nextParser.parse(String.valueOf(symbol)));
        }
        return word;
    }
}

