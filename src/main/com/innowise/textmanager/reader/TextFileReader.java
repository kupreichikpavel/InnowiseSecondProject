package com.innowise.textmanager.reader;

import com.innowise.textmanager.exception.TextException;

import java.nio.file.Path;

public interface TextFileReader {
    String read(Path path) throws TextException;

}
