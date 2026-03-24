package com.innowise.textmanager.parser.impl;

import com.innowise.textmanager.parser.TextParser;

public abstract class AbstractTextParserImpl implements TextParser {

    protected TextParser nextParser;

    public AbstractTextParserImpl(TextParser nextParser) {
        this.nextParser = nextParser;
    }
}

