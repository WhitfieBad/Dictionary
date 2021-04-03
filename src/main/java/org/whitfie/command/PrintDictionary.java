package org.whitfie.command;

import org.whitfie.model.Parameter;
import org.whitfie.model.TranslatedWordsParameter;

public class PrintDictionary implements Command {

    @Override
    public Parameter execute(Parameter result) {
        TranslatedWordsParameter translateWords = (TranslatedWordsParameter) result;
        translateWords.getTranslateWords().forEach(System.out::println);

        return result;
    }
}
