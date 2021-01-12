package org.whitfie.file;

import org.jsoup.Jsoup;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class HtmlData implements FormatStrategy {

    @Override
    public String read(InputStream inputStream) throws IOException {
        String text = Jsoup.parse(inputStream ,"UTF-8", "").text();
        return text;
    }
}
