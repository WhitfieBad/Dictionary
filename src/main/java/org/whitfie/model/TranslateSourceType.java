package org.whitfie.model;

public enum TranslateSourceType {
    WOOORDHUNT,
    NULL;

    public static TranslateSourceType getValueOf(int i) {
        switch (i) {
            case 1: return WOOORDHUNT;
        }
        return NULL;
    }


}
