package com.ederbaum.tika;


import org.apache.tika.exception.TikaException;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TikaUtilTest {

    private static final String DEFAULT_TEXT = "Hello World!";

    @Test
    public void testDOC() throws IOException, TikaException, SAXException {
        testFile("01.doc");
    }

    @Test
    public void testDOCX() throws IOException, TikaException, SAXException {
        testFile("01.docx");
    }

    @Test
    public void testPDF() throws IOException, TikaException, SAXException {
        testFile("01.pdf");
    }

    @Test
    public void testODT() throws IOException, TikaException, SAXException {
        testFile("01.odt");
    }



    private void testFile(final String fileName) throws IOException, TikaException, SAXException {
        try (final InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName)){
            final String text = TikaUtil.extractPlainText(is);
            assertTrue(text.contains(DEFAULT_TEXT));
        }
    }

}