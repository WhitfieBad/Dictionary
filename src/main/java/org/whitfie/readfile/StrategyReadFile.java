package org.whitfie.readfile;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.whitfie.exeptions.NotFoundType;
import org.whitfie.model.FileType;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class StrategyReadFile {
    private static HashMap<FileType, ReadFileStream> strategyHashMap = new HashMap<>();

    static {
        strategyHashMap.put(FileType.TXT, new ReadTxtStream());
        strategyHashMap.put(FileType.DOCS, new ReadDocxStream());
    }

    public static Set<String> getWordsFromFile(File file) throws NotFoundType, IOException, InvalidFormatException {
        return new ReadFile(strategyHashMap.get(FileType.valueOfFromExtension(file))).parseFile(file);
    }

}
