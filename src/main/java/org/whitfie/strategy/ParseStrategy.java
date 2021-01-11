package org.whitfie.strategy;

import org.jsoup.nodes.Document;
import org.whitfie.model.Word;

import java.util.List;

public interface ParseStrategy {

    List<Word> parse(Document document);

}
