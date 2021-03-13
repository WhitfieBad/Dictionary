package org.whitfie;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.whitfie.command.Command;
import org.whitfie.command.GetTranslateWords;
import org.whitfie.command.SaveDictionaryFile;
import org.whitfie.readfile.ReadFileStrategy;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class Dictionary {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        HashMap<String, String> sd = new HashMap<>();
        Set<String> d = ReadFileStrategy.getWordsFromFile(new File("/home/whitfie/Downloads/lo.txt"));
        System.out.println(d.size());
        Command command = new GetTranslateWords(sd);
        command.execute();
        command = new SaveDictionaryFile(sd, d);
        command.execute();
    }
}
