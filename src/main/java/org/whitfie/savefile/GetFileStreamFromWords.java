package org.whitfie.savefile;

import org.whitfie.model.TranslatedWord;

import java.io.InputStream;
import java.util.Set;

public interface GetFileStreamFromWords {
    InputStream getStreamFromWords(Set<TranslatedWord> translatedWordSet);
}
