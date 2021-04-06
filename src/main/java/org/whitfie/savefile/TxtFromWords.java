package org.whitfie.savefile;

import org.whitfie.model.TranslatedWord;

import java.util.Set;

public class TxtFromWords implements FormatFromWords {

    @Override
    public String getStringFromWords(Set<TranslatedWord> translatedWordSet) {
        StringBuilder stringBuilder = new StringBuilder();
        translatedWordSet.forEach(word -> stringBuilder.append(word).append("\n"));
        return stringBuilder.toString();
    }
}
