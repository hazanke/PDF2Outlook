package org.example;


import java.util.List;

import static org.example.PDFfile.readPDF;
import static org.example.Person.createPerson;

public class Main {
    public static void main(String[] args) {

        //PDF-Liste in einzelne Zeilen zerlegen. Jede Zeile entspricht einer Person (unnötige Zeilen werden gefiltert)
        List<String> PDFlines = readPDF("C:\\Users\\hans.SERVER\\IdeaProjects\\PDFtoOffice\\Data\\Geburtstagsliste.pdf");

        //aus jeder Zeile ein Personen-Objekt erzeugen
        for(int i=0; i<PDFlines.size(); i++){
            Person p = createPerson(PDFlines.get(i));

            System.out.println(p.toString());
        }
    }
}