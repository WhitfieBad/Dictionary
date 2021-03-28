package org.whitfie.command;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.whitfie.exeptions.NotFoundType;
import org.whitfie.model.Result;
import org.whitfie.model.WordsResult;
import org.whitfie.readfile.StrategyReadFile;
import org.whitfie.resultfacory.FactoryWordsResult;
import org.whitfie.resultfacory.ResultFactory;
import org.whitfie.utils.ConsoleHelper;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadSourceFile implements Command {

    @Override
    public Result execute(Result result) {
        ResultFactory resultFactory = new FactoryWordsResult();
        WordsResult wordsResult = (WordsResult) resultFactory.create();

        Scanner scanner = new Scanner(System.in);
        File file = null;

        System.out.println("input path");
        ConsoleHelper.printTypeForRead();

        file = new File(scanner.nextLine());

        if (!(file.exists() && file.isFile())) {
            System.out.println("Error not exist file");
            return result;
        }


        try {
            wordsResult.setWordsSet(StrategyReadFile.getWordsFromFile(file));
        } catch (NotFoundType notFoundType) {
            System.out.println("not exist type file");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        return wordsResult;
    }
}
