package org.whitfie;





import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.xmlbeans.XmlException;
import org.whitfie.command.Command;
import org.whitfie.command.SaveDictionary;
import org.whitfie.executer.ExecuterRead;
import org.whitfie.exeption.NotSuportedFile;
import org.whitfie.file.DocData;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;


public class Dictionary {

    public static void main(String[] args) throws IOException, InvalidFormatException, XmlException, NotSuportedFile {

        System.out.println("path to parse file");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> words = ExecuterRead.read(new File(bufferedReader.readLine()));
        words.forEach(System.out::println);

        System.out.println("save file? y/n");
        if (bufferedReader.readLine().equalsIgnoreCase("y")) {
            Command command = new SaveDictionary(words);
            command.execute();
        }

    }
}
