package org.whitfie.command;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class SaveDictionaryFile implements Command {

    private HashMap<String, String> stringHashMap = null;
    private Set<String> stringSet = null;

    public SaveDictionaryFile(HashMap<String, String> stringHashMap, Set<String> stringSet) {
        this.stringSet = stringSet;
        this.stringHashMap = stringHashMap;
    }

    @Override
    public boolean execute()  {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Веди патч файла для сахаранения");

        File file = new File(scanner.nextLine());


        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter finalFileWriter = fileWriter;
        stringSet.forEach(word -> {
            try {
                String wordRus = stringHashMap.get(word);
                if (wordRus != null) {
                    finalFileWriter.append(wordRus.concat(" - ").concat(word).concat("\n"));
                } else {
                    finalFileWriter.append(word.concat(" - unknow \n"));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        try {
            finalFileWriter.flush();
            finalFileWriter.close();
        } catch (IOException e) {
            System.out.println("не удалось записать в файл");
            return false;
        }

        return true;
    }
}
