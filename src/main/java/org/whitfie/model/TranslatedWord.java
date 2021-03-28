package org.whitfie.model;

import java.util.Objects;

public class TranslatedWord implements Comparable<TranslatedWord> {

    private String word;
    private String translatedWord;

    public TranslatedWord() {
    }

    public TranslatedWord(String word, String translatedWord) {
        this.word = word;
        this.translatedWord = translatedWord;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslatedWord() {
        return translatedWord;
    }

    public void setTranslatedWord(String translatedWord) {
        this.translatedWord = translatedWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TranslatedWord that = (TranslatedWord) o;
        return Objects.equals(word, that.word) && Objects.equals(translatedWord, that.translatedWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, translatedWord);
    }

    @Override
    public String toString() {
        String translate = translatedWord == null ? "not found translate" : translatedWord;
        return word + " " + translate;
    }

    @Override
    public int compareTo(TranslatedWord o) {
        return word.compareTo(o.getWord());
    }
}
