package org.whitfie.savefile;

import org.whitfie.model.TranslatedWord;

import java.util.Set;

public interface FormatFromWords {
    String getStringFromWords(Set<TranslatedWord> translatedWordSet);
}
