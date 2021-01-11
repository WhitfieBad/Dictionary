package org.whitfie.strategy;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.whitfie.model.Word;

import java.util.ArrayList;
import java.util.List;

public class EnglishParse implements ParseStrategy {


    @Override
    public List<Word> parse(Document document) {
        List<Word> wordList = new ArrayList<>();
        Element data = document.getElementsByClass("col-md-12")
                                .first().getElementsByTag("div")
                                .first().getElementsByTag("p").last();
        String words = data.text();
        words.replaceAll("<br>", " ");
        words.replaceAll("<p>", "");
        words.replaceAll("</p>", "");


        String[] wordsArray = words.split(" ");
        for (String word : wordsArray) {
            wordList.add(new Word(word));
        }
        return wordList;
    }
}
