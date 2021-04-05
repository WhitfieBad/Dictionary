package org.whitfie.model;

public enum TranslateSourceType {
    WOOORDHUNT,
    BABLA,
    NULL;

    public static TranslateSourceType getValueOf(int i) {
        switch (i) {
            case 1: return WOOORDHUNT;
            case 2: return BABLA;
        }
        return NULL;
    }


}
