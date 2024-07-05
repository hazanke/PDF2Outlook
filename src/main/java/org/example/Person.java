package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {

    private String Stimme;
    private String Vorname;
    private String Name;
    private String Anschrift;
    private String PLZ;
    private String Ort;
    private String Mobil;
    private String Geburtsdatum;
    private Boolean Aktiv;


    public static Person createPerson(String PDFline){

        Person p = new Person();
        //wenn das 2. Zeichen der Zeile ein Leerzeichen ist, gibt das 1. Zeichen die Stimme an.
        if (PDFline.charAt(1) == ' '){
            switch (PDFline.substring(0,1)){
                case "S":
                    p.Stimme = "Sopran";
                    break;
                case "A":
                    p.Stimme = "Alt";
                    break;
                case "T":
                    p.Stimme = "Tenor";
                    break;
                case "B":
                    p.Stimme = "Bass";
                    break;
                default:
                    p.Stimme = "";
            }

            //Restliche Bestandteile mit Leerzeichen splitten
            String[] lineParts = PDFline.split(" ");

            //wenn eine Person einer Stimme zugeordnet ist, ist sie 'Aktiv".
            p.Aktiv= !p.Stimme.isEmpty();
            p.Vorname=lineParts[1];
            p.Name=lineParts[2];
            p.Anschrift=lineParts[3]+" "+lineParts[4];
            p.PLZ=lineParts[5];
            p.Ort=lineParts[6];
            p.Mobil=lineParts[7]+lineParts[8]+lineParts[9];
            p.Geburtsdatum=lineParts[10];



        }
        return p;
    }
}
