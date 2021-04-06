package org.whitfie;

import org.whitfie.command.*;
import org.whitfie.model.CommandType;
import org.whitfie.model.NullParameter;
import org.whitfie.model.TranslatedWordsParameter;
import org.whitfie.model.WordsParameter;
import org.whitfie.translates.ParseBabla;
import org.whitfie.translates.ParseTranslateStrategy;
import org.whitfie.translates.ParseWooordHunt;
import org.whitfie.utils.ConsoleHelper;

import java.io.File;
import java.io.IOException;

public class Starter {

    private static WordsParameter words = null;
    private static TranslatedWordsParameter translatedWords = null;

    public static void main(String[] args) throws IOException {
        do {
            ConsoleHelper.printCommands();
            CommandType commandType = CommandType.getCommandType(ConsoleHelper.getInt());

            if (commandType == CommandType.EXIT) {
                break;
            } else {
                execute(Commands.getCommand(commandType));
            }
        } while (true);
    }

    private static void execute(Command command) {
        if (command instanceof NotSelected) {
            command.execute(new NullParameter());
        } else if (command instanceof PrintDictionary && translatedWords != null) {
            command.execute(translatedWords);
        } else if (command instanceof SaveDictionary && translatedWords != null) {
            command.execute(translatedWords);
        } else if (command instanceof ReadSourceFile) {
            words = (WordsParameter) command.execute(new NullParameter());
        } else if (command instanceof TranslateWords && words != null) {
            translatedWords = (TranslatedWordsParameter) command.execute(words);
        } else {
            System.out.println("incorrect command execution queue");
        }
    }
}
