package org.whitfie.translates;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.whitfie.model.TranslatedWord;

import java.io.IOException;

public class ParseBabla extends ParseTranslateStrategy {

    public ParseBabla() {
        super("https://en.bab.la/dictionary/english-russian/");
    }
    @Override
    public TranslatedWord getWordTranslate(String word) throws IOException {
        Document page = getPageWord(word);
        Elements transaltes = page.getElementsByClass("sense-group-results");
        return new TranslatedWord(word, transaltes.isEmpty() ? "" : transaltes.get(0).text());
    }
}
