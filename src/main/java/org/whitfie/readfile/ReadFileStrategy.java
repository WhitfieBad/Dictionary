package org.whitfie.readfile;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.whitfie.model.FileType;
import org.whitfie.util.FileUtil;

import java.io.*;
import java.util.HashMap;
import java.util.Set;

public class ReadFileStrategy {

    private ReadFileStrategy() {
    }

    private static HashMap<FileType, TextFromStreamFileType> typeReadFileHashMap = new HashMap<>();

    static {
        typeReadFileHashMap.put(FileType.TXT, new GetTextFromTxt());
        typeReadFileHashMap.put(FileType.HTML, new GetWordsFromHtml());
        typeReadFileHashMap.put(FileType.DOCS, new GetWordsFromDocs());
    }

    public static Set<String> getWordsFromFile(File file) throws IOException, InvalidFormatException {
        InputStream inputStream = new FileInputStream(file);
        TextFromStreamFileType wordsFromFileType = typeReadFileHashMap.get(FileType.valueOf(FileUtil.getFileExtension(file).toUpperCase()));
        Parser parser = new Parser(wordsFromFileType);

        return parser.parse(file);
    }


}
