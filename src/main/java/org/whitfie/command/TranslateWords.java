package org.whitfie.command;

import org.whitfie.exeptions.NotFoundType;
import org.whitfie.model.*;
import org.whitfie.resultfacory.FactoryTranslatedWordsResult;
import org.whitfie.resultfacory.ResultFactory;
import org.whitfie.translates.StrategyTranslates;
import org.whitfie.utils.ConsoleHelper;

import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class TranslateWords implements Command {

    @Override
    public Result execute(Result result) {
        if (!(result instanceof WordsResult)) {
            System.out.println("First you need to read file for translate");
            return result;
        }

        TranslateSourceType type = TranslateSourceType.NULL;
        Scanner scanner = new Scanner(System.in);
        WordsResult wordsResult = (WordsResult) result;
        TreeSet<TranslatedWord> translatedWords = new TreeSet<>();
        ResultFactory resultFactory = new FactoryTranslatedWordsResult();
        TranslatedWordsResult translatedWordsResult = (TranslatedWordsResult) resultFactory.create();

        ConsoleHelper.printTranslateSource();

        try {
             type = TranslateSourceType.getValueOf(scanner.nextInt());
        } catch (NotFoundType notFoundType) {
            System.out.println("source type dont exist");
            return result;
        }

        try {
            System.out.println("translating");
            translatedWords.addAll(StrategyTranslates.translateWords(wordsResult.getWordsSet(), type));
        } catch (IOException e) {
            System.out.println("Error translate -> " + e.getMessage());
            return result;
        }

        translatedWordsResult.setTranslateWords(translatedWords);
        return translatedWordsResult;
    }
}
