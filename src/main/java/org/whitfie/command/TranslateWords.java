package org.whitfie.command;

import org.whitfie.exeptions.NotFoundType;
import org.whitfie.exeptions.NullParametersExeption;
import org.whitfie.model.*;
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
        TranslateSourceType type = TranslateSourceType.NULL;
        Scanner scanner = new Scanner(System.in);
        WordsParameter wordsResult = (WordsParameter) result;
        TreeSet<TranslatedWord> translatedWords = new TreeSet<>();
        ParametertFactory resultFactory = new FactoryTranslatedWordsResult();
        TranslatedWordsParameter translatedWordsResult = (TranslatedWordsParameter) resultFactory.create();

        ConsoleHelper.printTranslateSource();

        type = TranslateSourceType.getValueOf(scanner.nextInt());

        if (type == TranslateSourceType.NULL) {
            System.out.println("Not found translate source");
        }

        System.out.println("translating");
        try {
            translatedWords.addAll(StrategyTranslates.translateWords(wordsResult.getWordsSet(), type));
        } catch (IOException e) {
            System.out.println("Error translate -> " + e.getMessage());
            return result;
        } catch (NullParametersExeption nullParametersExeption) {
            nullParametersExeption.printStackTrace();
        } catch (NotFoundType notFoundType) {
            notFoundType.printStackTrace();
        }

        translatedWordsResult.setTranslateWords(translatedWords);
        return translatedWordsResult;
    }
}
