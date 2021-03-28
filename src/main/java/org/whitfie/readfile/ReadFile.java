package org.whitfie.readfile;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class ReadFile {

    private ReadFileStream readFileStreamStrategy;

    public ReadFile(ReadFileStream readFileStreamStrategy) {
        this.readFileStreamStrategy = readFileStreamStrategy;
    }

    public Set<String> parseFile(File file) throws IOException, InvalidFormatException {
        Set<String> stringSet = new HashSet<>();
        FileInputStream fileInputStream = new FileInputStream(file);
        StringTokenizer stringTokenizer = new StringTokenizer(readFileStreamStrategy.readStream(fileInputStream));
        stringTokenizer.asIterator().forEachRemaining(word -> stringSet.add(word.toString()));
        stringSet.removeIf(Pattern.compile("[^a-zA-Z]").asPredicate());
        return stringSet;
    }

}
