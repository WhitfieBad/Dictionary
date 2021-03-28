package org.whitfie.model;

import java.util.Set;

public class TranslatedWordsResult implements Result {

    private Set<TranslatedWord> translateWords;

    public TranslatedWordsResult() {
    }

    public TranslatedWordsResult(Set<TranslatedWord> translateWords) {
        this.translateWords = translateWords;
    }

    public Set<TranslatedWord> getTranslateWords() {
        return translateWords;
    }

    public void setTranslateWords(Set<TranslatedWord> translateWords) {
        this.translateWords = translateWords;
    }
}
