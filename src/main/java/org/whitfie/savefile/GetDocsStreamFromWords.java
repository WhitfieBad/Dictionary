package org.whitfie.savefile;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.whitfie.model.TranslatedWord;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;

public class GetDocsStreamFromWords implements GetFileStreamFromWords {

    @Override
    public InputStream getStreamFromWords(Set<TranslatedWord> translatedWordSet) {
        StringBuilder textWords = new StringBuilder();

        translatedWordSet.forEach(word -> textWords.append(word).append("\n"));

        XWPFDocument document = new XWPFDocument();
        XWPFParagraph tmpParagraph = document.createParagraph();
        XWPFRun tmpRun = tmpParagraph.createRun();
        tmpRun.setText(textWords.toString());

        return document.getDocument().newInputStream();
    }
}
