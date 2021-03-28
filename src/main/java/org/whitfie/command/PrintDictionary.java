package org.whitfie.command;

import org.whitfie.model.Result;
import org.whitfie.model.TranslatedWordsResult;

public class PrintDictionary implements Command {

    @Override
    public Result execute(Result result) {
        if (!(result instanceof TranslatedWordsResult)) {
            System.out.println("First you need to translate the words that would bring the translation to the screen");
            return result;
        }

        TranslatedWordsResult translateWords = (TranslatedWordsResult) result;
        translateWords.getTranslateWords().forEach(System.out::println);

        return result;
    }
}
