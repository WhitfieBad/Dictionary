package org.whitfie.readfile;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.IOException;
import java.io.InputStream;

public class ReadDocxStream implements ReadFileStream {

    @Override
    public String readStream(InputStream inputStream) throws IOException, InvalidFormatException {
        StringBuilder text = new StringBuilder();
        XWPFDocument docxFile = new XWPFDocument(OPCPackage.open(inputStream));
        docxFile.getParagraphs().forEach(paragraph -> text.append(paragraph.getText()));
        return text.toString();
    }
}
