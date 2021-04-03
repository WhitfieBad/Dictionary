package org.whitfie.readfile;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.whitfie.exeptions.NotFoundType;
import org.whitfie.exeptions.NullParametersExeption;
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

    public static Set<String> getWordsFromFile(File file) throws NotFoundType, IOException, InvalidFormatException, NullParametersExeption {
        if (file == null) {
            throw new NullParametersExeption();
        }

        ReadFileStream readFileStream = strategyHashMap.get(FileType.valueOfFromExtension(file));

        if (readFileStream == null) {
            throw new NotFoundType();
        }

        return new ReadFile(readFileStream).parseFile(file);
    }

}
