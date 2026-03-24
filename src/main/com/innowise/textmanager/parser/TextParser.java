package com.innowise.textmanager.parser;

import com.innowise.textmanager.composite.TextComponent;

import java.util.regex.Pattern;

public interface TextParser {
    String PARAGRAPH_DELIMITER = "\n\\s*\n+";
    String SENTENCE_DELIMITER = "(?<=[.!?])\\s+";
    String LEXEMES_DELIMITER = "\\s";
    String WORD_DELIMITER = "(?=[\\p{Punct}])|(?<=[\\p{Punct}])";
    Pattern WORD_PATTERN = Pattern.compile("\\p{L}+");

    TextComponent parse(String text);

}
