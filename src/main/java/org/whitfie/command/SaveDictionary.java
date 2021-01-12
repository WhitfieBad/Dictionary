package org.whitfie.command;

import java.io.*;
import java.util.Set;

public class SaveDictionary implements Command{

    private Set<String> wordSet;

    public SaveDictionary(Set<String> wordSet) {
        this.wordSet = wordSet;
    }

    @Override
    public void execute() throws IOException {
        System.out.println("Path File Save ->");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(bufferedReader.readLine());
        FileWriter fileWriter = new FileWriter(file);
        for (String word : wordSet) {
            fileWriter.append(word).append("\n");
        }
        fileWriter.flush();
        fileWriter.close();
    }
}
