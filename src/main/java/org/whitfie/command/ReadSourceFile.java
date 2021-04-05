package org.whitfie.command;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.whitfie.exeptions.NotFoundType;
import org.whitfie.model.Parameter;
import org.whitfie.model.WordsParameter;
import org.whitfie.readfile.StrategyReadFile;
import org.whitfie.resultfacory.FactoryNullParameter;
import org.whitfie.resultfacory.FactoryWordsResult;
import org.whitfie.resultfacory.ParametertFactory;
import org.whitfie.utils.ConsoleHelper;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ReadSourceFile implements Command {

    @Override
    public Parameter execute(Parameter result) {
        File file = null;
        Set<String> words = null;
        Scanner scanner = new Scanner(System.in);
        ParametertFactory factoryWordsResult = new FactoryWordsResult();
        WordsParameter wordsResult = (WordsParameter) factoryWordsResult.create();

        ConsoleHelper.printTypeForRead();
        System.out.println("input path");

        file = new File(scanner.nextLine());

        if (file.canRead() && file.isFile()) {
            try {
                words = StrategyReadFile.getWordsFromFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            } catch (NotFoundType notFoundType) {
                System.out.println("not found file exetension");
            }
        } else {
            System.out.println("File canot read or this file dont exist");
        }

        if (words != null) {
            wordsResult.setWordsSet(words);
        }

        return wordsResult;
    }
}
