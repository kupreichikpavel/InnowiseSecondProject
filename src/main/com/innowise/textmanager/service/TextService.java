package com.innowise.textmanager.service;

import com.innowise.textmanager.composite.AbstractTextComponent;
import com.innowise.textmanager.composite.TextRoot;

public interface TextService {
    void replaceLexemesInSentences(TextRoot root);

    AbstractTextComponent sortByLexemesLength(TextRoot root);
}
