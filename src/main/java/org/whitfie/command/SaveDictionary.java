package org.whitfie.command;

import org.whitfie.exeptions.NotFoundType;
import org.whitfie.model.Result;
import org.whitfie.model.TranslatedWordsResult;
import org.whitfie.savefile.StrategySaveFile;
import org.whitfie.utils.ConsoleHelper;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SaveDictionary implements Command {

    @Override
    public Result execute(Result result) {
        if (!(result instanceof TranslatedWordsResult)) {
            System.out.println("First you need to translate for save words");
            return result;
        }

        Scanner scanner = new Scanner(System.in);
        TranslatedWordsResult translateWords = (TranslatedWordsResult) result;

        System.out.println("Input file path for save file");

        ConsoleHelper.printTypeForSave();
        File file = new File(scanner.nextLine());

        if (file.isDirectory()) {
            System.out.println("this not file");
            return result;
        }


        try {
            StrategySaveFile.saveWordsInFile(translateWords.getTranslateWords(), file);
        } catch (NotFoundType notFoundType) {
            System.out.println("this type format not exist");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
