package org.whitfie.readfile;


import java.io.IOException;
import java.io.InputStream;


public class GetTextFromTxt implements TextFromStreamFileType {
    
    @Override
    public String getText(InputStream inputStream) throws IOException {
        StringBuilder text = new StringBuilder();
        int i = -1;
        while ((i = inputStream.read()) != -1) {
            text.append((char)i);
        }
        return text.toString();
    }
}
