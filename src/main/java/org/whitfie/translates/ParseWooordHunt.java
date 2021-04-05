package org.whitfie.translates;

import org.jsoup.nodes.Document;
import org.whitfie.model.TranslatedWord;

import java.io.IOException;

public class ParseWooordHunt extends ParseTranslateStrategy {

    public ParseWooordHunt() {
        super("https://wooordhunt.ru/word/");
    }

    @Override
    public TranslatedWord getWordTranslate(String word) throws IOException {
        Document page = getPageWord(word);
        return new TranslatedWord(word, page.getElementsByClass("t_inline_en").text());
    }
}
