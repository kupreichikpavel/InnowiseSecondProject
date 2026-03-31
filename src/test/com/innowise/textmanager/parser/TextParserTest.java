package com.innowise.textmanager.parser;

import com.innowise.textmanager.composite.TextRoot;
import com.innowise.textmanager.composite.TextType;
import com.innowise.textmanager.parser.impl.LexemeParser;
import com.innowise.textmanager.parser.impl.ParagraphParser;
import com.innowise.textmanager.parser.impl.SentenceParser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextParserTest {
    private static ParagraphParser paragraphParser;
    private static SentenceParser sentenceParser;
    private static LexemeParser lexemeParser;
    private static TextRoot textRoot;

    private final String text = "First paragraph.\n\tSecond paragraph. Second sentence.\n\tThird paragraph.";
    private final String paragraph = "First sentence. Second sentence. Third sentence.";
    private final String sentence = "This is my sentence.";

    @BeforeAll
    static void setUpParser() {
        paragraphParser = new ParagraphParser();
        sentenceParser = new SentenceParser();
        lexemeParser = new LexemeParser();
    }

    @BeforeEach
    void setUpRoot() {
        textRoot = new TextRoot(TextType.TEXT);
    }

    @Test
    void shouldParseTextToParagraphs() {
        paragraphParser.parse(text, textRoot);
        int excepted = 3;
        int actual = textRoot.getSize();
        assertEquals(excepted, actual);
    }

    @Test
    void shouldParseParagraphToSentences() {
        sentenceParser.parse(paragraph, textRoot);
        int excepted = 3;
        int actual = textRoot.getSize();
        assertEquals(excepted, actual);
    }

    @Test
    void shouldParseSentenceToLexemes() {
        lexemeParser.parse(sentence, textRoot);
        int excepted = 4;
        int actual = textRoot.getSize();
        assertEquals(excepted, actual);
    }
}