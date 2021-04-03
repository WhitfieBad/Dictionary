package org.whitfie.command;

import org.whitfie.exeptions.NotFoundType;
import org.whitfie.exeptions.NullParametersExeption;
import org.whitfie.model.Parameter;
import org.whitfie.model.TranslatedWordsParameter;
import org.whitfie.savefile.StrategySaveFile;
import org.whitfie.utils.ConsoleHelper;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SaveDictionary implements Command {

    @Override
    public Parameter execute(Parameter result) {
        Scanner scanner = new Scanner(System.in);
        TranslatedWordsParameter translateWords = (TranslatedWordsParameter) result;

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
        } catch (NullParametersExeption nullParametersExeption) {
            nullParametersExeption.printStackTrace();
        }

        return result;
    }
}
