package com.innowise.textmanager.service.impl;

import com.innowise.textmanager.composite.AbstractTextComponent;
import com.innowise.textmanager.composite.TextRoot;
import com.innowise.textmanager.composite.TextType;
import com.innowise.textmanager.parser.impl.ParagraphParser;
import com.innowise.textmanager.service.TextService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceImplTest {
    private static TextRoot textRoot;
    private static ParagraphParser parser;
    private static TextService service;

    private static final String TEXT = "This is my text. And it is the first paragraph.\n\tThis is the second paragraph. I am proud of this text.";
    private static final String REPLACE_LEXEMES_TEXT = "\ttext. is my This paragraph. it is the first And \n\tparagraph. is the second This text. am proud of this I ";
    private static final String SORTED_BY_SENTENCES_TEXT = "This is my text. This is the second paragraph. And it is the first paragraph. I am proud of this text. ";

    @BeforeAll
    static void setUp(){
        parser = new ParagraphParser();
        service = new TextServiceImpl();
    }

    @BeforeEach
    void setUpText(){
        textRoot = new TextRoot(TextType.TEXT);
        parser.parse(TEXT, textRoot);
    }

    @Test
    void shouldShouldReplaceLexemesInSentences(){
        String excepted = REPLACE_LEXEMES_TEXT;
        service.replaceLexemesInSentences(textRoot);
        String actual = textRoot.toString();
        assertEquals(excepted, actual);
    }

    @Test
    void shouldSortTextByLexemesLength(){
        String excepted = SORTED_BY_SENTENCES_TEXT;
        AbstractTextComponent sortedRoot = service.sortByLexemesLength(textRoot);
        String actual = sortedRoot.toString();
        assertEquals(excepted, actual);
    }
}