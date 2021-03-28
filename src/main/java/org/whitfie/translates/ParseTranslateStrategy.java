package org.whitfie.translates;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

public abstract class ParseTranslateStrategy {

    private Document document;

    public ParseTranslateStrategy() {
    }

    public ParseTranslateStrategy(URL url) throws IOException {
        this.document = Jsoup.parse(url, 3000);
    }

    public Document getDocument() {
        return document;
    }

    public void parse(URL url) throws IOException {
        this.document = Jsoup.parse(url, 3000);
    }

    public abstract Map<String, String> getTranslates() throws IOException;

}
