package org.whitfie.command;

import org.jsoup.Jsoup;
import org.whitfie.strategy.EnglishParse;
import org.whitfie.strategy.Parser;

import java.io.IOException;

public class PrintEnglishDictionary implements Command {

    @Override
    public void execute() {
        try {
            new Parser(new EnglishParse()).parseAndPrint(Jsoup.connect("https://www.ef.com/wwen/english-resources/english-vocabulary/top-3000-words/").get());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
