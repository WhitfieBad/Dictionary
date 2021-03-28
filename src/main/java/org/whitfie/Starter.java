package org.whitfie;

import org.whitfie.command.Executer;
import org.whitfie.model.CommandType;
import org.whitfie.model.Result;
import org.whitfie.model.ResultNull;
import org.whitfie.utils.ConsoleHelper;

import java.io.IOException;
import java.util.Scanner;

public class Starter {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        CommandType commandType = CommandType.NOTSELECTED;
        Result result = new ResultNull();

        do {
            ConsoleHelper.printCommands();
            try {
                commandType = CommandType.getCommandType(Integer.parseInt(scanner.nextLine()));
            } catch (NumberFormatException numberFormatException) { }
            result = Executer.execute(commandType, result);

        } while (true);
    }

}
