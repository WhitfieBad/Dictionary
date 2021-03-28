package org.whitfie.translates;

import org.whitfie.model.TranslatedWord;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ParseTranslate {

    private ParseTranslateStrategy parseTranslateStrategy;

    public ParseTranslate(ParseTranslateStrategy parseTranslateStrategy) {
        this.parseTranslateStrategy = parseTranslateStrategy;
    }

    public Set<TranslatedWord> translate(Set<String> words) throws IOException {
        Set<TranslatedWord> translateWords = new HashSet<>();
        Map<String, String> translates = parseTranslateStrategy.getTranslates();

        for (String word : words) {
            translateWords.add(new TranslatedWord(word, translates.get(word.toLowerCase())));
        }

        return translateWords;
    }

}
