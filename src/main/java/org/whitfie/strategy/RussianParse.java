package org.whitfie.strategy;

import org.jsoup.nodes.Document;
import org.whitfie.model.Word;

import java.util.ArrayList;
import java.util.List;

public class RussianParse implements ParseStrategy {


    @Override
    public List<Word> parse(Document document) {
        List<Word> wordList = new ArrayList<>();
        String text = document.getElementsByClass("words").first().getElementsByClass("text").text();
        text.replaceAll("td", "");
        String[] arrayWords = text.split(" ");
        for (String word : arrayWords) {
            wordList.add(new Word(word));
        }

        return wordList;
    }
}
