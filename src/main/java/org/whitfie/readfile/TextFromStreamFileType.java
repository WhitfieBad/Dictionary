package org.whitfie.readfile;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public interface TextFromStreamFileType {
    String getText(InputStream inputStream) throws IOException, InvalidFormatException;
}
