package org.whitfie.executer;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.xmlbeans.XmlException;
import org.whitfie.exeption.NotSuportedFile;
import org.whitfie.file.DocData;
import org.whitfie.file.HtmlData;
import org.whitfie.file.Parser;
import org.whitfie.file.TextData;
import org.whitfie.model.TypeFile;
import org.whitfie.utils.UtilsFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class ExecuterRead {

    private final static HashMap<TypeFile, Parser> strategyMap = new HashMap<>();

    static {
        strategyMap.put(TypeFile.TXT, new Parser(new TextData()));
        strategyMap.put(TypeFile.DOC, new Parser(new DocData()));
        strategyMap.put(TypeFile.HTML, new Parser(new HtmlData()));
    }

    public static Set<String> read(File file) throws NotSuportedFile, InvalidFormatException, XmlException, IOException {
       return strategyMap.get(TypeFile.getType(UtilsFile.getExtensionByStringHandling(file.getName()).get())).parse(file);
    }



}
