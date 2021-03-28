package org.whitfie.savefile;

import org.whitfie.model.TranslatedWord;

import java.io.*;
import java.util.Set;

public class SaveFile {

    private GetFileStreamFromWords getFileStreamFromWords;

    public SaveFile(GetFileStreamFromWords getFileStreamFromWords) {
        this.getFileStreamFromWords = getFileStreamFromWords;
    }

    public void saveWordsInFile(Set<TranslatedWord> translatedWords, File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(new String(getFileStreamFromWords.getStreamFromWords(translatedWords).readAllBytes()));
        fileWriter.flush();
        fileWriter.close();
    }

}
