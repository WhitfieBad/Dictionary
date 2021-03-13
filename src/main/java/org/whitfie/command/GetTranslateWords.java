package org.whitfie.command;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class GetTranslateWords implements Command {

    private HashMap<String, String> translateMap = new HashMap<>();

    public GetTranslateWords(HashMap<String, String> translateMap) {
        this.translateMap = translateMap;
    }

    @Override
    public boolean execute() {
        translateMap.clear();

        URL url = null;
        try {
            url = new URL("https://studynow.ru/dicta/allwords");
        } catch (MalformedURLException e) {
            System.out.println("проблема с ссилкой");
            return false;
        }
        Document doc = null;
        try {
            doc = Jsoup.parse(url,3000);
        } catch (IOException e) {
            System.out.println("не удалось спарсить сайт");
            return false;
        }

        Element content = doc.getElementById("wordlist");
        for (Element element : content.select("tr")) {
            translateMap.put(element.select("td").get(1).text(), element.select("td").get(2).text());
        }

        return true;
    }
}
