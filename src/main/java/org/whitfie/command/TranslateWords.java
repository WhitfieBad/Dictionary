package org.whitfie.command;

import org.whitfie.exeptions.NotFoundType;
import org.whitfie.model.*;
import org.whitfie.resultfacory.FactoryNullParameter;
import org.whitfie.resultfacory.FactoryTranslatedWordsResult;
import org.whitfie.resultfacory.ParametertFactory;
import org.whitfie.translates.StrategyTranslates;
import org.whitfie.utils.ConsoleHelper;

import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class TranslateWords implements Command {

    @Override
    public Parameter execute(Parameter result) {
        Scanner scanner = new Scanner(System.in);
        TranslateSourceType type = TranslateSourceType.NULL;
        WordsParameter wordsResult = (WordsParameter) result;
        TreeSet<TranslatedWord> translatedWords = new TreeSet<>();
        ParametertFactory factoryTranslatedWordsResult = new FactoryTranslatedWordsResult();
        TranslatedWordsParameter translatedWordsResult = (TranslatedWordsParameter) factoryTranslatedWordsResult.create();

        ConsoleHelper.printTranslateSource();
        type = TranslateSourceType.getValueOf(scanner.nextInt());

        if (wordsResult.getWordsSet().isEmpty()) {
            System.out.println("read not emty text file for translate");
        } else {
            System.out.println("try translating");
            try {
                translatedWords.addAll(StrategyTranslates.translateWords(wordsResult.getWordsSet(), type));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NotFoundType notFoundType) {
                System.out.println("Not Found Source Translate");
            }
        }

        translatedWordsResult.setTranslateWords(translatedWords);
        return translatedWordsResult;
    }
}
