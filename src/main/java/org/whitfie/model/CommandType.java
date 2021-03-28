package org.whitfie.model;

import org.whitfie.exeptions.NotFoundType;

public enum CommandType {
    EXIT,
    NOTSELECTED,
    READSOURCEFILE,
    SAVEDICTIONARY,
    PRINTDICTIONARY,
    TRANSLATEWORDS;

    public static CommandType getCommandType(int i) {
        switch (i) {
            case 1: return EXIT;
            case 2: return READSOURCEFILE;
            case 3: return SAVEDICTIONARY;
            case 4: return PRINTDICTIONARY;
            case 5: return TRANSLATEWORDS;
        }
        return NOTSELECTED;
    }

}
