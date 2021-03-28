package org.whitfie.command;



import org.whitfie.exeptions.NotFoundType;
import org.whitfie.model.CommandType;
import org.whitfie.model.Result;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class Executer {
    private static HashMap<CommandType, Command> commandHashMap = new HashMap<>();

    static {
        commandHashMap.put(CommandType.EXIT, new Exit());
        commandHashMap.put(CommandType.NOTSELECTED, new NotSelectedCommand());
        commandHashMap.put(CommandType.PRINTDICTIONARY, new PrintDictionary());
        commandHashMap.put(CommandType.READSOURCEFILE, new ReadSourceFile());
        commandHashMap.put(CommandType.SAVEDICTIONARY, new SaveDictionary());
        commandHashMap.put(CommandType.TRANSLATEWORDS, new TranslateWords());
    }

    public static Result execute(CommandType commandType, Result result) {
        Command command = commandHashMap.get(commandType);
        return command.execute(result);
    }

}
