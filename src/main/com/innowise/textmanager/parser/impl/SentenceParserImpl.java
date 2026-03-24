package com.innowise.textmanager.parser.impl;

import com.innowise.textmanager.composite.Sentence;
import com.innowise.textmanager.composite.TextComponent;
import com.innowise.textmanager.parser.TextParser;

public class SentenceParserImpl extends AbstractTextParserImpl {


    public SentenceParserImpl(TextParser nextParser) {
        super(nextParser);
    }

    @Override
    public TextComponent parse(String text) {
        Sentence sentence = new Sentence();
        String[] lexems = text.split(LEXEMES_DELIMITER);
        for (String lexem : lexems) {
            if (!lexem.isBlank()) {
                sentence.add(nextParser.parse(lexem));
            }
        }
        return sentence;
    }
}
