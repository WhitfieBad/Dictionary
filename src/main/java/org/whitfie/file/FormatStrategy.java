package org.whitfie.file;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.xmlbeans.XmlException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public interface FormatStrategy {
    String read(InputStream inputStream) throws IOException, InvalidFormatException, XmlException;
}
