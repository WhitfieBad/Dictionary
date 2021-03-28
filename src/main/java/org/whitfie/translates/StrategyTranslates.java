package org.whitfie.translates;

import org.whitfie.model.TranslateSourceType;
import org.whitfie.model.TranslatedWord;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class StrategyTranslates {

    private static HashMap<TranslateSourceType, ParseTranslateStrategy> strategyHashMap = new HashMap<>();

    static {
        strategyHashMap.put(TranslateSourceType.WOOORDHUNT, new ParseWooordHunt());
    }

    public static Set<TranslatedWord> translateWords(Set<String> wordsSet, TranslateSourceType translateSource) throws IOException {
        return new ParseTranslate(strategyHashMap.get(translateSource)).translate(wordsSet);
    }

}
