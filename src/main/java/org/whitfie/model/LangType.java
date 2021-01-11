package org.whitfie.model;

import org.whitfie.exeption.NotFoundOperation;

public enum LangType {
    ENG,
    RU;

    public static LangType getType(int i) throws NotFoundOperation {
        switch (i) {
            case 0 :
                return LangType.ENG;
            case 1 :
                return LangType.RU;
            default:
                throw new NotFoundOperation();
        }
    }

}
