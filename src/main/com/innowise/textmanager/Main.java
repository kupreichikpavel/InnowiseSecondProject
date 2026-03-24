package com.innowise.textmanager;


import com.innowise.textmanager.composite.Lexem;
import com.innowise.textmanager.composite.Paragraph;
import com.innowise.textmanager.composite.TextComponent;
import com.innowise.textmanager.exception.TextException;
import com.innowise.textmanager.parser.TextParser;
import com.innowise.textmanager.parser.impl.*;
import com.innowise.textmanager.reader.TextFileReader;
import com.innowise.textmanager.reader.impl.TextReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        TextFileReader reader = new TextReader();
        List<String> list = new ArrayList<>();
        try {
            list = reader.read("/Users/alexey/IdeaProjects/InnowiseSecondProject/src/main/resources/text.txt");
        } catch (TextException e) {
            System.out.println("empty");
        }
        String text = String.join("\n", list);

        TextParser parser = new TextParserImpl(
                new ParagraphParserImpl(
                        new SentenceParserImpl(
                                new LexemeParserImpl(
                                        new WordParserImpl(
                                                new SymbolParserImpl(null)
                                        )
                                )
                        )
                )
        );
        TextComponent result = parser.parse(text);


        for (TextComponent component : result.getComponents()) {
            for (TextComponent component2 : component.getComponents()) {
                for (TextComponent component3 : component2.getComponents()) {
                    for (TextComponent component4 : component3.getComponents()) {
                        for (TextComponent component5 : component4.getComponents()) {
                            component5.print();
                        }
                    }
                }
            }
        }

    }
}