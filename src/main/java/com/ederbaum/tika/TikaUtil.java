/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ederbaum.tika;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class TikaUtil {

    private TikaUtil() {
    }


    public static String extractPlainText(final File file)
            throws IOException, SAXException, TikaException {
        try (InputStream is = Files.newInputStream(file.toPath())) {
            return extractPlainText(is);
        }
    }

    public static String extractPlainText(final InputStream is)
            throws IOException, SAXException, TikaException {
        final Metadata metadata = new Metadata();
        //metadata.add(RESOURCE_NAME_KEY, fileName);

        final ParseContext context = new ParseContext();
        final AutoDetectParser parser = new AutoDetectParser();
        final ContentHandler h = new BodyContentHandler(999999999);
        parser.parse(is, h, metadata, context);
        return h.toString();
    }


    public static void main(String[] args) throws IOException, SAXException, TikaException {
        File file = new File("/Users/ederbaum/Downloads/Proposta.pdf");
        System.out.println(extractPlainText(file));
    }

}
