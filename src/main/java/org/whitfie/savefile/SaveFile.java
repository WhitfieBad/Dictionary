package org.whitfie.savefile;

import org.whitfie.model.TranslatedWord;

import java.io.*;
import java.util.Set;

public class SaveFile {

    private FormatFromWords formatFromWords;

    public SaveFile(FormatFromWords formatFromWords) {
        this.formatFromWords = formatFromWords;
    }

    public void saveWordsInFile(Set<TranslatedWord> translatedWords, File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(formatFromWords.getStringFromWords(translatedWords));
        fileWriter.flush();
        fileWriter.close();
    }

}
