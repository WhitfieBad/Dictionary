package org.whitfie.readfile;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.io.InputStream;

public interface ReadFileStream {
    String readStream(InputStream inputStream) throws IOException, InvalidFormatException;
}
