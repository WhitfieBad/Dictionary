package org.whitfie.file;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.xmlbeans.XmlException;

import java.io.*;
import java.util.*;

public class Parser {

    private FormatStrategy formatStrategy;

    public Parser(FormatStrategy formatStrategy) {
        this.formatStrategy = formatStrategy;
    }

    public Set<String> parse(File file) throws IOException, InvalidFormatException, XmlException {
        Set<String> words = new TreeSet<>();
        InputStream inputStream = new FileInputStream(file);
        String text = formatStrategy.read(inputStream);
        text = text.replaceAll("[^a-z A-Z а-я А-Я]", " ");
        String[] wordsArray = text.split(" ");
        Arrays.stream(wordsArray).forEach(x -> words.add(x));
        return words;
    }

}
