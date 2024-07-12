package org.example;



@SuppressWarnings("ALL")
public class Person {

    private String Stimme;
    private String Titel;
    private String Vorname;
    private String Name;
    private String Anschrift;
    private String PLZ;
    private String Ort;
    private String Mobil;
    private String Geburtsdatum;
    private Boolean Aktiv;

    private Integer PLZpos;
    private Integer VNpos=1;


    public static Person createPerson(String PDFline){

        //Zeile mit Leerzeichen splitten
        String[] lineParts = PDFline.split(" ");
        //S Tanja Schnitzler Memmingerstr. 18 89287 Bellenberg +49 162 9835718 11.01.1974 50

        Person p = new Person();
        //Stimme auf Basis des ersten Teilstrings ermittlen
        if (lineParts[0].matches("[SATB]")){
            switch (lineParts[0]){
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
                    p.Stimme = " ";
            }
            }else {
            //keine Stimme: Vorname steht einen Teilstring weiter links
            p.Stimme=" ";
            p.VNpos -= 1;
        }
            //prüfen, ob eine Person einen Titel vor dem Vornamen hat
            if (lineParts[p.VNpos].equals("Dr.")){
                p.Titel="Dr.";
                p.VNpos+=1;
            }

            //Geburtstag steht immer an vorletzter Stelle im String:
            p.Geburtsdatum=lineParts[lineParts.length-2];

            //wenn eine Person einer Stimme zugeordnet ist, ist sie 'Aktiv".
            p.Aktiv=!p.Stimme.equals(" ");

            //Postleitzahl ist ein Teilstring aus 5 Ziffern
            for (int i=0; i<lineParts.length; i++){
                if (lineParts[i].matches("\\d{5}")){
                    p.PLZ=lineParts[i];
                    p.PLZpos=i;
                }
            }

            // der Ort kommt nach der Postleitzahl
            p.Ort=lineParts[p.PLZpos+1];

            //die Telefonnummer geht von der 2. Position nach der Postleitzahl bis zur drittletzten Position
            //nur relevant, wenn diese mit einem "+" beginnt.
        if (lineParts[p.PLZpos + 2].equals("+49")) {
            p.Mobil = lineParts[p.PLZpos + 2];
            for (int i = p.PLZpos + 3; i < lineParts.length - 2; i++) {
                p.Mobil += lineParts[i];
            }
        }


        // die Anschrift beginnt 2 Positionen hinter dem Vornamen und endet vor der Postleitzahl
            p.Anschrift=lineParts[p.VNpos+2];
            for (int i = p.VNpos+3; i< p.PLZpos; i++){
                    p.Anschrift= STR."\{p.Anschrift} \{lineParts[i]}";

                }


            //Vorname
            p.Vorname=lineParts[p.VNpos];

            //Nachname
            p.Name=lineParts[p.VNpos+1];



        return p;
    }


}
