package org.whitfie.file;

import java.io.*;
import java.util.Scanner;

public class TextData implements FormatStrategy {

    @Override
    public String read(InputStream inputStream) throws IOException {
        StringBuilder text = new StringBuilder();
        int i = -1;
        while ((i = inputStream.read()) != -1) {
            text.append((char)i);
        }
        return text.toString();
    }
}
