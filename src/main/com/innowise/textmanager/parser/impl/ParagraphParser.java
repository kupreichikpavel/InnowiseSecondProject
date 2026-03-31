package com.innowise.textmanager.parser.impl;

import com.innowise.textmanager.composite.TextRoot;
import com.innowise.textmanager.composite.TextType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphParser extends AbstractTextParser{
    private static final Logger logger = LogManager.getLogger(ParagraphParser.class);

    public ParagraphParser() {
        super.setNextSuccessor(new SentenceParser());
    }

    @Override
    public void parse(String content, TextRoot parent) {
        String[] paragraphs = content.split(PARAGRAPH_DELIMITER);
        logger.debug("Text has {} paragraphs.", paragraphs.length);

        for (String paragraph : paragraphs) {
            TextRoot paragraphRoot = new TextRoot(TextType.PARAGRAPH);
            parent.addComponent(paragraphRoot);
            AbstractTextParser nextSuccessor = getNextSuccessor();
            nextSuccessor.parse(paragraph, paragraphRoot);
        }
    }
}
