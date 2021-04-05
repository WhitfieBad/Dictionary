package org.whitfie.command;

import org.whitfie.exeptions.NotFoundType;
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

        ConsoleHelper.printTypeForSave();
        System.out.println("Input file path for save file");
        File file = new File(scanner.nextLine());

        if (translateWords.getTranslatedWords().isEmpty()) {
            System.out.println("Dictionary emty");
            return null;
        }

        if (file.canWrite() && file.isFile()) {
            try {
                StrategySaveFile.saveWordsInFile(translateWords.getTranslatedWords(), file);
            } catch (NotFoundType notFoundType) {
                System.out.println("this type format not exist");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("not cant write file or this not file");
        }
        return null;
    }
}
