package org.example;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class PDFfile {

    public static List<String> readPDF(String filepath){
     try {
        File file = new File(filepath);

        //Dokument laden
        PDDocument document = Loader.loadPDF(file);
        System.out.println(STR."Pages: \{document.getNumberOfPages()}");

        //Dokument strippen
        PDFTextStripper stripper = new PDFTextStripper();
        stripper.setSortByPosition(true);
        String pdfContent = stripper.getText(document);

        System.out.println("Spacing Tolerance: "+ stripper.getSpacingTolerance());
        System.out.println(STR."Line Separator: \{stripper.getLineSeparator()}");

        //Text Splitten und Liste mit Zeilen erzeugen
        String[] lines = pdfContent.split("\r\n");
        List<String> pdfLines = new ArrayList<>();

         for (String line : lines) {
             if (!(line.contains("Vorname") || (line.contains("Geburtstag")))) {
                 pdfLines.add(line);
             }
         }

        System.out.println("readPDF: "+pdfLines.size()+" Zeilen erkannt.");
        return pdfLines;

    } catch (IOException e) {
        throw new RuntimeException(e);
    }


}
}
