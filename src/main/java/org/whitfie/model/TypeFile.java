package org.whitfie.model;

import org.whitfie.exeption.NotSuportedFile;

public enum TypeFile {
    TXT,
    DOC,
    HTML;

    public static TypeFile getType(String format) throws NotSuportedFile {
        switch (format) {
            case "txt" :
                return TXT;
            case "doc" :
                return DOC;
            case "docx" :
                return DOC;
            case "html" :
                return HTML;
            default:
                throw new NotSuportedFile();

        }
    }


}
