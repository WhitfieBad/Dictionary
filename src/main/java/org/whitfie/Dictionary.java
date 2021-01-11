package org.whitfie;

import org.whitfie.command.Command;
import org.whitfie.command.PrintRussianDictionary;
import org.whitfie.executer.Executer;
import org.whitfie.exeption.NotFoundOperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dictionary {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            ConsoleHelper.printLangList();

            int operationNumber = Integer.parseInt(bufferedReader.readLine());

            if (operationNumber > 1) {
                break;
            } else {
                try {
                    Executer.execute(operationNumber);
                } catch (NotFoundOperation notFoundOperation) {
                    notFoundOperation.printStackTrace();
                }
            }

        }
    }
}
