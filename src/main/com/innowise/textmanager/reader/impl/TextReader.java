package com.innowise.textmanager.reader.impl;

import com.innowise.textmanager.exception.TextException;
import com.innowise.textmanager.reader.TextFileReader;

import java.util.List;

public class TextReader implements TextFileReader {

    @Override
    public List<String> read(String path) throws TextException {
        return List.of();
    }
}
