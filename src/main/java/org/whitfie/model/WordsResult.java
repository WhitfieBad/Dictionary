package org.whitfie.model;

import java.util.HashSet;
import java.util.Set;

public class WordsResult implements Result {
    private Set<String> wordsSet;

    public WordsResult() {
        this.wordsSet = new HashSet<>();
    }

    public WordsResult(Set<String> wordsSet) {
        this.wordsSet = wordsSet;
    }

    public Set<String> getWordsSet() {
        return wordsSet;
    }

    public void setWordsSet(Set<String> wordsSet) {
        this.wordsSet = wordsSet;
    }
}
