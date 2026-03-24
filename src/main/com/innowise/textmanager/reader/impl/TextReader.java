package com.innowise.textmanager.reader.impl;

import com.innowise.textmanager.exception.TextException;
import com.innowise.textmanager.reader.TextFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.nio.file.Files.lines;
import static java.nio.file.Path.of;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextReader implements TextFileReader {
    private static final Logger logger = LogManager.getLogger(TextReader.class);

    @Override
    public List<String> read(String path) throws TextException {
        if (path == null || path.isEmpty()) {
            logger.error("Path is null or empty");
            throw new TextException("Path is null or empty");
        }
        try (Stream<String> lines = lines(of(path))) {
            List<String> result = lines
                    .collect(Collectors.toList());
            if (result.isEmpty()) {
                logger.error("File exist but empty");
                throw new TextException("File is empty: " + path);
            }
            return result;
        } catch (Exception e) {
            throw new TextException("Error reading file: " + path);
        }
    }
}