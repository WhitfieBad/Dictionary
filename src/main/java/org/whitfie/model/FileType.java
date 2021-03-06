package org.whitfie.model;

import org.whitfie.exeptions.NotFoundType;
import org.whitfie.utils.FileUtils;

import java.io.File;

public enum FileType {
    NULL,
    TXT,
    DOCS,
    JSON;

    public static FileType valueOfFromExtension(File file) {
        String extension = FileUtils.getExtensionByStringHandling(file.getName()).get();
        switch (extension.toLowerCase()) {
            case "txt" : return TXT;
            case "docs" : return DOCS;
            case "json" : return JSON;
        }
        return NULL;
    }

}
