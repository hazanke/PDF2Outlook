package org.example;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            File file = new File("Geburtstagsliste.pdf");
            PDDocument document = Loader.loadPDF(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}