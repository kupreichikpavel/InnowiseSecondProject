package com.innowise.textmanager.parser.impl;

import com.innowise.textmanager.composite.TextRoot;
import com.innowise.textmanager.composite.TextType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceParser extends AbstractTextParser{

    private static final Logger logger = LogManager.getLogger(SentenceParser.class);

    public SentenceParser() {
        super.setNextSuccessor(new LexemeParser());
    }

    @Override
    public void parse(String content, TextRoot parent) {
        String[] sentences = content.split(SENTENCE_DELIMITER);
        logger.info("Paragraph has {} sentences.", sentences.length);

        for (String sentence : sentences) {
            TextRoot sentenceRoot = new TextRoot(TextType.SENTENCE);
            parent.addComponent(sentenceRoot);
            AbstractTextParser nextSuccessor = getNextSuccessor();
            nextSuccessor.parse(sentence, sentenceRoot);
        }
    }
}

