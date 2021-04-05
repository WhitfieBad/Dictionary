package org.whitfie.model;

import java.util.Set;
import java.util.TreeSet;

public class TranslatedWordsParameter implements Parameter {

    private Set<TranslatedWord> translateWords;

    public TranslatedWordsParameter() {
        translateWords = new TreeSet<>();
    }

    public TranslatedWordsParameter(Set<TranslatedWord> translateWords) {
        this.translateWords = translateWords;
    }

    public Set<TranslatedWord> getTranslatedWords() {
        return translateWords;
    }

    public void setTranslateWords(Set<TranslatedWord> translateWords) {
        this.translateWords = translateWords;
    }
}
