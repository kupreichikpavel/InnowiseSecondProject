package com.innowise.textmanager.parser.impl;

import com.innowise.textmanager.composite.Text;
import com.innowise.textmanager.composite.TextComponent;
import com.innowise.textmanager.parser.TextParser;

public class TextParserImpl extends AbstractTextParserImpl {

    public TextParserImpl(TextParser nextParser) {
        super(nextParser);
    }

    @Override
    public TextComponent parse(String text) {
        Text result = new Text();
        String[] paragraphs = text.split(PARAGRAPH_DELIMITER);
        for (String paragraph : paragraphs) {
            if (!paragraph.isBlank()) {
                result.add(nextParser.parse(paragraph));
            }
        }
        return result;
    }
}
