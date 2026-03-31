package com.innowise.textmanager.parser.impl;

import com.innowise.textmanager.composite.TextRoot;

import java.util.regex.Pattern;

public abstract class AbstractTextParser {
    protected static final String PARAGRAPH_DELIMITER = "\\n\\s+";
    protected static final String SENTENCE_DELIMITER = "(?<=[.!?])\\s+";
    protected static final String LEXEMES_DELIMITER = "\\s";
    protected static final String WORD_DELIMITER = "(?=[\\p{Punct}])|(?<=[\\p{Punct}])";
    protected static final Pattern WORD_PATTERN = Pattern.compile("\\p{L}+");

    private AbstractTextParser nextSuccessor;

    public void setNextSuccessor(AbstractTextParser nextSuccessor) {
        this.nextSuccessor = nextSuccessor;
    }

    public AbstractTextParser getNextSuccessor() {
        return nextSuccessor;
    }

    public abstract void parse(String content, TextRoot parent);
}
