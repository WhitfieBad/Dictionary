package org.whitfie.translates;

import org.whitfie.model.TranslatedWord;

import java.io.IOException;
import java.util.*;

public class ParseTranslate {

    private ParseTranslateStrategy parseTranslateStrategy;

    public ParseTranslate(ParseTranslateStrategy parseTranslateStrategy) {
        this.parseTranslateStrategy = parseTranslateStrategy;
    }

    public Set<TranslatedWord> translate(Set<String> words) throws IOException {
        Set<TranslatedWord> translatedWords = new TreeSet<>();
        for (String word : words) {
            translatedWords.add(parseTranslateStrategy.getWordTranslate(word));
        }
        return translatedWords;
    }

}
