package com.innowise.textmanager.reader;

import com.innowise.textmanager.exception.TextException;

import java.util.List;

public interface TextFileReader {
    List<String> read(String path) throws TextException;

}
