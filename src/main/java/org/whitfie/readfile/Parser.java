package org.whitfie.readfile;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Parser {

    private TextFromStreamFileType formatStrategy;

    public Parser(TextFromStreamFileType formatStrategy) {
        this.formatStrategy = formatStrategy;
    }

    public Set<String> parse(File file) throws IOException, InvalidFormatException {
        Set<String> words = new TreeSet<>();
        InputStream inputStream = new FileInputStream(file);
        String  text = formatStrategy.getText(inputStream);
        text = text.replaceAll("[^a-z A-Z а-я А-Я]", " ");

        String[] wordsArray = text.split(" ");
        Arrays.stream(wordsArray).forEach(x -> words.add(x.toLowerCase()));
        return words;
    }
}
