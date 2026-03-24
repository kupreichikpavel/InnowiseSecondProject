package com.innowise.textmanager.parser.impl;

import com.innowise.textmanager.composite.Lexem;
import com.innowise.textmanager.composite.Sentence;
import com.innowise.textmanager.composite.TextComponent;
import com.innowise.textmanager.parser.TextParser;

public class LexemeParserImpl extends AbstractTextParserImpl {

    public LexemeParserImpl(TextParser nextParser) {
        super(nextParser);
    }

    @Override
    public TextComponent parse(String text) {
        Lexem words = new Lexem();
        String[] lexems = text.split(WORD_DELIMITER);
        for (String lexem : lexems) {
            if (!lexem.isBlank()) {
                words.add(nextParser.parse(lexem));
            }
        }
        return words;
    }
}
