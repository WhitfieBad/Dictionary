package org.whitfie.savefile;

import org.whitfie.exeptions.NotFoundType;
import org.whitfie.model.FileType;
import org.whitfie.model.TranslatedWord;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class StrategySaveFile {
    private static HashMap<FileType, FormatFromWords> strategyHashMap = new HashMap<>();

    static {
        strategyHashMap.put(FileType.TXT, new TxtFromWords());
        strategyHashMap.put(FileType.DOCS, new DocsFromWords());
        strategyHashMap.put(FileType.JSON, new JsonFromWords());
    }

    public static void saveWordsInFile(Set<TranslatedWord> translatedWords, File file) throws NotFoundType, IOException {
        FormatFromWords formatFromWords = strategyHashMap.get(FileType.valueOfFromExtension(file));

        if (formatFromWords == null) {
            throw new NotFoundType();
        }

        SaveFile saveFile = new SaveFile(formatFromWords);
        saveFile.saveWordsInFile(translatedWords, file);
    }
}
