package com.innowise.textmanager.reader.impl;

import com.innowise.textmanager.exception.TextException;
import com.innowise.textmanager.reader.TextFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextReader implements TextFileReader {
    private static final Logger logger = LogManager.getLogger(TextReader.class);

    @Override
    public String read(Path path) throws TextException {
        logger.info("Reading exercise text from file.");
        String content;
        try {
            content = Files.readString(path);
        } catch (IOException e) {
            logger.error("Failed to read file.");
            throw new TextException("Failed to read file.", e);
        }
        return content;
    }
}