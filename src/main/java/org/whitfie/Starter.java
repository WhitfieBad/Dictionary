package org.whitfie;

import org.whitfie.command.Executer;
import org.whitfie.exeptions.NotFoundType;
import org.whitfie.exeptions.NullParametersExeption;
import org.whitfie.model.CommandType;
import org.whitfie.model.Parameter;
import org.whitfie.resultfacory.FactoryNullParameter;
import org.whitfie.resultfacory.ParametertFactory;
import org.whitfie.utils.ConsoleHelper;

import java.util.Scanner;

public class Starter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandType commandType = null;
        ParametertFactory factory = new FactoryNullParameter();
        Parameter parameter = factory.create();

        do {
            ConsoleHelper.printCommands();

            try {
                commandType = CommandType.getCommandType(Integer.parseInt(scanner.nextLine()));
            } catch (NumberFormatException exception) {
                commandType = CommandType.NOTSELECTED;
            }

            if (commandType == CommandType.EXIT) {
                System.exit(0);
            }

            try {
                Executer.execute(commandType, parameter);
            } catch (NotFoundType notFoundType) {
                notFoundType.printStackTrace();
            } catch (NullParametersExeption nullParametersExeption) {
                nullParametersExeption.printStackTrace();
            } catch (ClassCastException classCastException) {
                System.out.println("not the correct order of the command");
            }
        } while (true);
    }

}
