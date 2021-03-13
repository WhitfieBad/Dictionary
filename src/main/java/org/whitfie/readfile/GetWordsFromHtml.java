package org.whitfie.readfile;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.io.InputStream;


public class GetWordsFromHtml implements TextFromStreamFileType {

    @Override
    public String getText(InputStream inputStream) throws IOException {
        return Jsoup.parse(inputStream ,"UTF-8", "").text();
    }
}
