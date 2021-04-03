package org.whitfie.model;

import java.util.HashSet;
import java.util.Set;

public class WordsParameter implements Parameter {
    private Set<String> wordsSet;

    public WordsParameter() {
        this.wordsSet = new HashSet<>();
    }

    public WordsParameter(Set<String> wordsSet) {
        this.wordsSet = wordsSet;
    }

    public Set<String> getWordsSet() {
        return wordsSet;
    }

    public void setWordsSet(Set<String> wordsSet) {
        this.wordsSet = wordsSet;
    }
}
