package org.whitfie.strategy;

import org.jsoup.nodes.Document;

public class Parser {

    private ParseStrategy parseStrategy;

    public Parser(ParseStrategy parseStrategy) {
        this.parseStrategy = parseStrategy;
    }

    public void parseAndPrint(Document document) {
        parseStrategy.parse(document).forEach(System.out::println);
    }

}
