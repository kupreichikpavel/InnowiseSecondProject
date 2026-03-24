package com.innowise.textmanager.parser.impl;

import com.innowise.textmanager.composite.Paragraph;
import com.innowise.textmanager.composite.TextComponent;
import com.innowise.textmanager.parser.TextParser;

public class ParagraphParserImpl extends AbstractTextParserImpl {

    public ParagraphParserImpl(TextParser nextParser) {
        super(nextParser);
    }

    @Override
    public TextComponent parse(String text) {
        Paragraph paragraph = new Paragraph();
        String[] sentence = text.split(SENTENCE_DELIMITER);
        for (String sentences : sentence) {
            if (!sentences.isBlank()) {
                paragraph.add(nextParser.parse(sentences));
            }
        }
        return paragraph;
    }
}
