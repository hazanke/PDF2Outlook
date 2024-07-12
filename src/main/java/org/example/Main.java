package org.example;


import java.util.ArrayList;
import java.util.List;

import static org.example.PDFfile.readPDF;
import static org.example.Person.createPerson;

public class Main {
    public static void main(String[] args) {

        List<Person> chor = new ArrayList<>();

        //PDF-Liste in einzelne Zeilen zerlegen. Jede Zeile entspricht einer Person (unnötige Zeilen werden gefiltert)
        List<String> PDFlines = readPDF("C:\\Users\\hans.SERVER\\IdeaProjects\\PDFtoOffice\\Data\\Geburtstagsliste.pdf");

        //aus jeder Zeile ein Personen-Objekt erzeugen
        for (String pdFline : PDFlines) {
            Person p = createPerson(pdFline);
            chor.add(p);

            System.out.println(STR."Mitglieder im Chor: \{chor.size()}");
        }
    }
}