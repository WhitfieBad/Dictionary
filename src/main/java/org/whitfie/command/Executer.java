package org.whitfie.command;

import org.whitfie.exeptions.NotFoundType;
import org.whitfie.exeptions.NullParametersExeption;
import org.whitfie.model.CommandType;
import org.whitfie.model.Parameter;

import java.util.HashMap;

public class Executer {
    private static HashMap<CommandType, Command> commandHashMap = new HashMap<>();

    static {
        commandHashMap.put(CommandType.NOTSELECTED, new NotSelectedCommand());
        commandHashMap.put(CommandType.PRINTDICTIONARY, new PrintDictionary());
        commandHashMap.put(CommandType.READSOURCEFILE, new ReadSourceFile());
        commandHashMap.put(CommandType.SAVEDICTIONARY, new SaveDictionary());
        commandHashMap.put(CommandType.TRANSLATEWORDS, new TranslateWords());
    }

    public static Parameter execute(CommandType commandType, Parameter parameter) throws NotFoundType, NullParametersExeption {
        if (commandType == null || parameter == null) {
            throw new NullParametersExeption();
        }

        Command command = commandHashMap.get(commandType);

        if (command == null) {
            throw new NotFoundType(commandType.name());
        }

        return command.execute(parameter);
    }

}
