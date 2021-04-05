package org.whitfie.translates;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.whitfie.model.TranslatedWord;

import java.io.IOException;

public abstract class ParseTranslateStrategy {

    String url = null;

    public ParseTranslateStrategy(String url) {
        this.url = url;
    }

    public Document getPageWord(String word) throws IOException {
        return Jsoup.connect(url + word).get();
    }

    public abstract TranslatedWord getWordTranslate(String word) throws IOException;

}
