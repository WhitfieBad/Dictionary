package org.whitfie.model;

import org.whitfie.exeptions.NotFoundType;

public enum TranslateSourceType {
    WOOORDHUNT;

    public static TranslateSourceType getValueOf(int i) throws NotFoundType {
        switch (i) {
            case 1: return WOOORDHUNT;
        }
        throw new NotFoundType();
    }


}
