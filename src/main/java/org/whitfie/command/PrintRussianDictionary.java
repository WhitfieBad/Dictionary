package org.whitfie.command;

import org.jsoup.Jsoup;
import org.whitfie.strategy.Parser;
import org.whitfie.strategy.RussianParse;

import java.io.IOException;

public class PrintRussianDictionary implements Command {

    @Override
    public void execute() {
        try {
            new Parser(new RussianParse()).parseAndPrint(Jsoup.connect("https://klavogonki.ru/vocs/203/").get());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
