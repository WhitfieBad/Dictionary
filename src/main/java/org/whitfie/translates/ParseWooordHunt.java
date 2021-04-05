package org.whitfie.translates;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class ParseWooordHunt extends ParseTranslateStrategy {

    @Override
   public Map<String, String> getTranslates() throws IOException {
        parse(new URL("https://wooordhunt.ru/dic/content/en_ru"));
        HashMap<String, String> translates = new HashMap<>();
        Elements links = getDocument().getElementById("content").getElementsByTag("a");

        links.remove(0);
        for (Element element : links) {
            translates.putAll(parsePage(element.attr("href")));
        }

        return translates;
    }

    private Map<String, String> parsePage(String url) throws IOException {
        parse(new URL("https://wooordhunt.ru" + url));

        HashMap<String, String> translates = new HashMap<>();
        Elements traslatesPage = getDocument().getElementById("content").getElementsByTag("div");

        for (Element element : traslatesPage.get(3).getElementsByTag("p")) {
            String[] translatesData = element.text().split(" ", 2);
            translates.put(translatesData[0].toLowerCase(), translatesData[1]);
        }

        return translates;
    }

}
