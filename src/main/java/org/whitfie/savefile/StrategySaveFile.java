package org.whitfie.savefile;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.whitfie.exeptions.NotFoundType;
import org.whitfie.exeptions.NullParametersExeption;
import org.whitfie.model.FileType;
import org.whitfie.model.TranslatedWord;
import org.whitfie.readfile.ReadDocxStream;
import org.whitfie.readfile.ReadFile;
import org.whitfie.readfile.ReadFileStream;
import org.whitfie.readfile.ReadTxtStream;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class StrategySaveFile {
    private static HashMap<FileType, GetFileStreamFromWords> strategyHashMap = new HashMap<>();

    static {
        strategyHashMap.put(FileType.TXT, new GetTxtStreamFromWords());
        strategyHashMap.put(FileType.DOCS, new GetDocsStreamFromWords());
        strategyHashMap.put(FileType.JSON, new GetJsonStreamFromWords());
    }

    public static void saveWordsInFile(Set<TranslatedWord> translatedWords, File file) throws NotFoundType, IOException, NullParametersExeption {
        if (translatedWords == null || file == null) {
            throw new NullParametersExeption();
        }

        GetFileStreamFromWords getFileStreamFromWords = strategyHashMap.get(FileType.valueOfFromExtension(file));

        if (getFileStreamFromWords == null) {
            throw new NotFoundType();
        }

        SaveFile saveFile = new SaveFile(getFileStreamFromWords);
        saveFile.saveWordsInFile(translatedWords, file);
    }
}
