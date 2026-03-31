package com.innowise.textmanager.service.impl;

import com.innowise.textmanager.composite.AbstractTextComponent;
import com.innowise.textmanager.composite.TextRoot;
import com.innowise.textmanager.composite.TextType;
import com.innowise.textmanager.service.TextService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TextServiceImpl implements TextService {
    @Override
    public void replaceLexemesInSentences(TextRoot root) {
        List<AbstractTextComponent> sentences = getSentences(root);
        for (AbstractTextComponent sentence : sentences) {
            int size = sentence.getSize();
            if (size > 1) {
                AbstractTextComponent firstLexeme = getLexeme(sentence, 0);
                AbstractTextComponent lastLexeme = getLexeme(sentence, size - 1);
                ((TextRoot) sentence).setComponent(firstLexeme, size - 1);
                ((TextRoot) sentence).setComponent(lastLexeme, 0);
            }
        }
    }

    @Override
    public AbstractTextComponent sortByLexemesLength(TextRoot root) {
        List<AbstractTextComponent> sentences = getSentences(root);
        Comparator<AbstractTextComponent> comparator = (sentence1, sentence2) -> {
            int size1 = sentence1.getSize();
            int size2 = sentence2.getSize();
            return size1 - size2;
        };
        sentences.sort(comparator);
        TextRoot sortedRoot = new TextRoot(TextType.TEXT);
        for (AbstractTextComponent sentence : sentences) {
            sortedRoot.addComponent(sentence);
        }
        return sortedRoot;
    }

    private AbstractTextComponent getLexeme(AbstractTextComponent sentence, int index) {
        List<AbstractTextComponent> lexemes = ((TextRoot) sentence).getComponents();
        return lexemes.get(index);
    }

    private List<AbstractTextComponent> getSentences(TextRoot root) {
        List<AbstractTextComponent> sentences = new ArrayList<>();
        List<AbstractTextComponent> components = root.getComponents();
        for (AbstractTextComponent component : components) {
            TextType type = component.getType();
            if (type.equals(TextType.SENTENCE)) {
                sentences.add(component);
            } else if (type.equals(TextType.TEXT) || type.equals(TextType.PARAGRAPH)) {
                sentences.addAll(getSentences((TextRoot) component));
            }
        }
        return sentences;
    }
}