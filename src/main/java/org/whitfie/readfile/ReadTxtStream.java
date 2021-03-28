package org.whitfie.readfile;

import java.io.IOException;
import java.io.InputStream;

public class ReadTxtStream implements ReadFileStream {

    @Override
    public String readStream(InputStream inputStream) throws IOException {
        StringBuilder text = new StringBuilder();
        int i = -1;
        while ((i = inputStream.read()) != -1) {
            text.append((char)i);
        }
        return text.toString();
    }
}
