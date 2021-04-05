package org.whitfie.translates;

import org.whitfie.exeptions.NotFoundType;
import org.whitfie.model.TranslateSourceType;
import org.whitfie.model.TranslatedWord;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class StrategyTranslates {

    private static HashMap<TranslateSourceType, ParseTranslateStrategy> strategyHashMap = new HashMap<>();

    static {
        strategyHashMap.put(TranslateSourceType.WOOORDHUNT, new ParseWooordHunt());
        strategyHashMap.put(TranslateSourceType.BABLA, new ParseBabla());
    }

    public static Set<TranslatedWord> translateWords(Set<String> wordsSet, TranslateSourceType translateSource) throws IOException, NotFoundType {
        ParseTranslateStrategy parseTranslateStrategy = strategyHashMap.get(translateSource);

        if (parseTranslateStrategy == null) {
            throw new NotFoundType();
        }
        return new ParseTranslate(parseTranslateStrategy).translate(wordsSet);
    }

}
