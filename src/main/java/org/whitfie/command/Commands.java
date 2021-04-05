package org.whitfie.command;

import org.whitfie.model.CommandType;

import java.util.HashMap;

public class Commands {

    private static HashMap<CommandType, Command> commandHashMap = new HashMap<>();

    static {
        commandHashMap.put(CommandType.NOTSELECTED, new NotSelected());
        commandHashMap.put(CommandType.PRINTDICTIONARY, new PrintDictionary());
        commandHashMap.put(CommandType.READSOURCEFILE, new ReadSourceFile());
        commandHashMap.put(CommandType.SAVEDICTIONARY, new SaveDictionary());
        commandHashMap.put(CommandType.TRANSLATEWORDS, new TranslateWords());
    }

    public static Command getCommand(CommandType commandType) {
        return commandHashMap.get(commandType);
    }

}
