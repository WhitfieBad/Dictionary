package org.whitfie.executer;

import org.whitfie.command.Command;
import org.whitfie.command.PrintEnglishDictionary;
import org.whitfie.command.PrintRussianDictionary;
import org.whitfie.exeption.NotFoundOperation;
import org.whitfie.model.LangType;

import java.util.HashMap;

public class Executer {

    private static HashMap<LangType, Command> langTypeCommandHashMap = new HashMap<>();

    static {
        langTypeCommandHashMap.put(LangType.ENG, new PrintEnglishDictionary());
        langTypeCommandHashMap.put(LangType.RU, new PrintRussianDictionary());
    }

    public static void execute(int i) throws NotFoundOperation {
        langTypeCommandHashMap.get(LangType.getType(i)).execute();
    }


}
