package com.innowise.textmanager.parser.impl;

import com.innowise.textmanager.composite.TextRoot;
import com.innowise.textmanager.composite.TextType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LexemeParser extends AbstractTextParser{
    private static final Logger logger = LogManager.getLogger(LexemeParser.class);

    public LexemeParser() {
        super.setNextSuccessor(new WordParser());
    }

    @Override
    public void parse(String content, TextRoot parent) {
        String[] sentenceComponents = content.split(LEXEMES_DELIMITER);

        AbstractTextParser nextSuccessor = getNextSuccessor();
        for (String component : sentenceComponents) {
            TextRoot lexemeRoot = new TextRoot(TextType.LEXEME);
            parent.addComponent(lexemeRoot);
            nextSuccessor.parse(component, lexemeRoot);
        }
    }
}
