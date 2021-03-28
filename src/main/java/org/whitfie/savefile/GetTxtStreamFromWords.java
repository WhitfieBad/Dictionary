package org.whitfie.savefile;

import org.whitfie.model.TranslatedWord;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Set;

public class GetTxtStreamFromWords implements GetFileStreamFromWords {

    @Override
    public InputStream getStreamFromWords(Set<TranslatedWord> translatedWordSet) {
        StringBuilder stringBuilder = new StringBuilder();
        translatedWordSet.forEach(word -> stringBuilder.append(word).append("\n"));
        return new ByteArrayInputStream(stringBuilder.toString().getBytes(StandardCharsets.UTF_8));
    }
}
