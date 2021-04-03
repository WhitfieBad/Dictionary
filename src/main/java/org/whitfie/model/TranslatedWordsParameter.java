package org.whitfie.model;

import java.util.Set;

public class TranslatedWordsParameter implements Parameter {

    private Set<TranslatedWord> translateWords;

    public TranslatedWordsParameter() {
    }

    public TranslatedWordsParameter(Set<TranslatedWord> translateWords) {
        this.translateWords = translateWords;
    }

    public Set<TranslatedWord> getTranslateWords() {
        return translateWords;
    }

    public void setTranslateWords(Set<TranslatedWord> translateWords) {
        this.translateWords = translateWords;
    }
}
