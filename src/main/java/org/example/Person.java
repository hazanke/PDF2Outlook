package org.example;

public class Person {

    private String Stimme;
    private String Vorname;
    private String Name;
    private String Anschrift;
    private String PLZ;
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

            //wenn eine Person einer Stimme zugeordnet ist, ist sie 'Aktiv".
            p.Aktiv= !p.Stimme.isEmpty();

        }
        return p;
    }
}
