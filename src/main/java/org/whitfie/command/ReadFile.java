package org.whitfie.command;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.whitfie.readfile.ReadFileStrategy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Set;

public class ReadFile implements Command {

    private Set<String> wordsSet;

    public ReadFile(Set<String> wordsSet) {
        this.wordsSet = wordsSet;
    }

    @Override
    public boolean execute() {
        Scanner scanner = new Scanner(System.in);
        Set<String> stringSet = null;
        System.out.println("Вести расположения файла для чтения");

        try {
            stringSet = ReadFileStrategy.getWordsFromFile(new File(scanner.nextLine()));
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println("Расширение не найдено");
            return false;
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Не возможно прочитать файл");
            return false;
        }

        if (stringSet == null) {
            System.out.println("не получилось прочитать слова");
            return false;
        }

        wordsSet.addAll(stringSet);
        return true;
    }
}
