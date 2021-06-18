import java.util.ArrayList;
import java.util.Scanner;

public class Personalverwaltung {

    ArrayList<Person> personen = new ArrayList<>();
    ArrayList<Zimmer> zimmer = new ArrayList<>();

    void update() {
        boolean programmLäuft = true;

        Scanner s = new Scanner(System.in);
        String eingabe;
        System.out.println("\nFür eine Übersicht über alle möglichen Aktionen, geben Sie bitte ein: /help");

        while (programmLäuft) {
            System.out.println("\nWas möchten Sie tun?");

            eingabe = s.nextLine();

                if (eingabe.equals("/help")) {
                    System.out.println("Folgende Aktionen stehen Ihnen zur Verfügung:\n");
                    System.out.println("/person --> um eine neue Person in das System aufzunehmen.");
                    System.out.println("/room --> um ein neues Zimmer anzulegen.");
                    System.out.println("/del --> um ein Zimmer zu löschen.");
                    System.out.println("/rel --> um einen Patienten zu entlassen.");
                    System.out.println("/move --> um einen Patienten in ein anderes Zimmer zu verlegen.");
                    System.out.println("/info --> um alle Personendaten auszugeben.");
                    System.out.println("/lohn --> um den Monatslohn eines Angestellten auszugeben.");
                    System.out.println("/soll --> um die Sollzeit eines Angestellten zu ändern.");
                    System.out.println("/ist --> um die Istzeit eines Angestellten zu ändern.");
                    System.out.println("/gearbeitet --> um Zugriff auf die Arbeitszeit eines Angestellten zu erhalten.");
                    System.out.println("/convert --> um Minuten in Stunden umzurechnen.");
                    System.out.println("/exit --> um das Programm zu beenden.");
                }

               if (eingabe.equals("/person")) {
                   System.out.println("Möchten Sie einen Patienten, einen Arzt oder einen Krankenpfleger anlegen?");
                   System.out.println("Geben sie entsprechend /patient, /arzt oder /krank ein.");
                   eingabe = s.nextLine();

                   if (eingabe.equals("/patient")) {
                       System.out.println("Geben Sie den vollen Namen des Patienten an:");
                       String namePatient = s.nextLine();
                       System.out.println("Geben Sie das Alter des Patienten an:");
                       int alterPatient = s.nextInt();
                       System.out.println("Geben Sie an, ob der Patient privatversichert ist (true/false):");
                       boolean privatPatient = s.nextBoolean();
                       patientAnlegen(namePatient, alterPatient, privatPatient);
                   }

                   if (eingabe.equals("/arzt")) {
                       Arzt.Rang rang = null;
                       System.out.println("Geben Sie den vollen Namen des Arztes an:");
                       String nameArzt = s.nextLine();
                       System.out.println("Geben Sie das Alter des Arztes an:");
                       int alterArzt = s.nextInt();
                       System.out.println("Geben Sie den Stundenlohn des Arztes an:");
                       float stundenlohnArzt = s.nextFloat();
                       System.out.println("Geben Sie die Steuerklasse des Arztes als Zahl von 0-6 an:");
                       Steuerklasse steuerklasseArzt = Steuerklasse.values()[s.nextInt()];
                       System.out.println("Geben Sie die Sollzeit des Arztes in Minuten an:");
                       int sollZeitArzt = s.nextInt();
                       System.out.println("Geben Sie den Rang des Arztes an.");
                       System.out.println("Zur Auswahl stehen: AiA, Assistenzarzt, Facharzt, Oberarzt und Chefarzt.");  //Bitte erklärt mir am Dienstag, warum ich
                       String rangArzt = s.nextLine();                                                                  //ab hier nichts mehr eingeben kann und
                       rangHilfe(rangArzt, rang);                                                                       //immer direkt wieder an den anfang der
                       Arzt arztNeu = new Arzt(nameArzt, alterArzt, stundenlohnArzt, steuerklasseArzt, rang, sollZeitArzt);           //update methode geworfen werde >:(
                       personen.add(arztNeu);
                   }

                   if (eingabe.equals("/krank")) {
                       System.out.println("Geben Sie den vollen Namen des Krankenpflegers an:");
                       String nameKrank = s.nextLine();
                       System.out.println("Geben Sie das Alter des Krankenpflegers an:");
                       int alterKrank = s.nextInt();
                       System.out.println("Geben Sie den Stundenlohn des Krankenpflegers an:");
                       float stundenlohnKrank = s.nextFloat();
                       System.out.println("Geben Sie die Steuerklasse des Krankenpflegers als Zahl von 0-6 an:");
                       Steuerklasse steuerklasseKrank = Steuerklasse.values()[s.nextInt()];
                       System.out.println("Geben Sie die Sollzeit des Krankenpfleger in Minuten an:");
                       int sollZeitKrank = s.nextInt();
                       System.out.println("In welcher Schicht arbeitet der Krankenpfleger? Frühschicht, Spätschicht oder Nachtschicht?");
                       String schichtLALA = s.nextLine();
                       Krankenpfleger.Schicht schicht = Krankenpfleger.Schicht.Frühschicht;
                       if (schichtLALA.equals("Spätschicht"))
                           schicht = Krankenpfleger.Schicht.Spätschicht;
                       if (schichtLALA.equals("Nachtschicht"))
                           schicht = Krankenpfleger.Schicht.Nachtschicht;
                       Krankenpfleger krankNeu = new Krankenpfleger(nameKrank, alterKrank, stundenlohnKrank, steuerklasseKrank, schicht, sollZeitKrank);
                       personen.add(krankNeu);
                   }
               }

                if (eingabe.equals("/room")) {
                    System.out.println("Welche Zimmernummer hat dieses Zimmer?");
                    int zimmerNummer = s.nextInt();
                    System.out.println("Wie viele Betten hat das neue Zimmer?");
                    int anzahlBetten = s.nextInt();
                    neuesZimmerAnlegen(zimmerNummer, anzahlBetten);
                }


                if (eingabe.equals("/del")) {
                    System.out.println("Welches der folgenden Zimmer wollen Sie entfernen?");

                    for (int i = 0; i < zimmer.size(); i++) {
                        System.out.println("[" + i + 1 + "]   Zimmer " + zimmer.get(i).zimmerNummer + " mit " + zimmer.get(i).anzahlBetten + " Betten.");
                    }
                    System.out.println("Geben Sie die Zimmernummer des Zimmers an, welches entfernt werden soll:");
                    int zimmerNummerAbfrage = s.nextInt();
                    zimmerLoeschen(zimmerNummerAbfrage);
                }

                if (eingabe.equals("/rel")) {
                    System.out.println("Welche der folgenden Personen wollen Sie entlassen?");
                    int zähler = 1;
                    for (int i = 0; i < personen.size(); i++) {
                        System.out.println("[" + zähler + "]   " + personen.get(i).getClass() +
                                ":\nName: " + personen.get(i).name + ", Alter: " + personen.get(i).alter + ".");
                        zähler++;
                    }
                    System.out.println("Geben Sie den vollen Namen der Person an, die entlassen werden soll:");
                    String namenAbfrage = s.nextLine();
                    personEntlassen(namenAbfrage);
                }

                if (eingabe.equals("/move")) {
                    System.out.println("Geben Sie den Namen des Patienten an, der verlegt werden soll:");
                    String namePatient = s.nextLine();
                    System.out.println("Geben Sie die Zimmernummer des Zimmers an, in dem sich der Patient befindet.");
                    int zimmerNummerAlt = s.nextInt();
                    System.out.println("Geben Sie die Zimmernummer des Zimmers an, in das der Patient verlegt werden soll:");
                    int zimmerNummerNeu = s.nextInt();
                    patientVerlegen(namePatient, zimmerNummerAlt, zimmerNummerNeu);
                }

                if (eingabe.equals("/info")) {
                    for (int i = 0; i < personen.size(); i++) {
                        System.out.println(zimmer.get(i).patienten.get(i).name);
                        System.out.println(zimmer.get(i).patienten.get(i).alter);
                        System.out.println(zimmer.get(i).patienten.get(i).privatVer);
                        System.out.println(-----------------------------------------);
                        System.out.println(zimmer.get(i).angestellte.get(i).name);
                        System.out.println(zimmer.get(i).angestellte.get(i).alter);
                        System.out.println(zimmer.get(i).angestellte.get(i).sollZeit);
                        System.out.println(zimmer.get(i).angestellte.get(i).stundenlohn);
                        System.out.println(zimmer.get(i).angestellte.get(i).steuerklasse);
                        System.out.println(--------------------------------------------);

                    }
                }

                if (eingabe.equals("/lohn")) {
                    System.out.println("Geben Sie den Namen des Angestellten an, dessen Lohn ausgegeben werden soll:");
                    String nameLohn = s.nextLine();
                    monatsLohnBerechnen(nameLohn);
                }

                if (eingabe.equals("/soll")) {
                    System.out.println("Geben Sie den Namen des Angestellten an, dessen Sollzeit geändert werden soll:");
                    String name = s.nextLine();
                    System.out.println("Geben Sie die gewünschte Sollzeit in Minuten an:");
                    int zeit = s.nextInt();
                    sollZeitÄndern(zeit, name);

                }

                if (eingabe.equals("/ist")) {

                }

                if (eingabe.equals("/arbeit")) {

                }

                if (eingabe.equals("/convert")) {
                    System.out.println("Wie viele Minuten wollen Sie in Stunden umrechnen?");
                    int minuten = s.nextInt();
                    Zeitkonto.minToHour(minuten);
                }

                if (eingabe.equals("/exit")) {
                    programmLäuft = false;
                }
            }
        }

    void patientAnlegen(String name, int alter, boolean privat) {
        Patient patientNeu = new Patient(name, alter, privat);
        for (int i = 0; i < zimmer.size(); i++) {
            if (zimmer.get(i).anzahlBetten > zimmer.get(i).patienten.size()) {
                personen.add(patientNeu);
                zimmer.get(i).patienten.add(patientNeu);
                System.out.println("Sie haben einen neuen Patienten angelegt.");
            } else {
                System.out.println("Dieses Zimmer ist bereits voll.");
            }
        }
    }

    void neuesZimmerAnlegen(int zimmerNummer, int anzahlBetten) {

        int hilfe = 0;
        Zimmer neuesZimmer = new Zimmer(zimmerNummer, anzahlBetten);

        for (int i = 0; i < zimmer.size(); i++)
            if (neuesZimmer.zimmerNummer == zimmer.get(i).zimmerNummer)
                hilfe++;

        if (hilfe > 0)
            System.out.println("Es gibt bereits ein Zimmer mit dieser Nummer.");
        else {
            zimmer.add(neuesZimmer);
            System.out.println("Das anhelegte Zimmer " + zimmerNummer + " hat " + anzahlBetten + " Betten.");
        }
    }

    void zimmerLoeschen(int nummer) {
        int hilfe = 0;
        int hilfe1 = 0;

        for (int i = 0; i < zimmer.size(); i++) {
            if (nummer == zimmer.get(i).zimmerNummer) {
                hilfe1 = i;
                hilfe++;
            }
        }
        if (hilfe > 0) {
            zimmer.remove(hilfe1);
            System.out.println("Das Zimmer " + zimmer.get(hilfe1).zimmerNummer + " wurde entfernt.");
        } else
            System.out.println("Fehler: Es konnte kein Zimmer mit dieser Nummer gefunden werden.");
    }

    void personEntlassen(String name) {
        for (int i = 0; i < personen.size(); i++) {
            if (name.equals(personen.get(i).name)) {
                personen.remove(i);
                System.out.println(name + " wurde entlassen.");
                return;
            }
        }
        System.out.println("Fehler: Die Person konnte nicht gefunden werden.");
    }

    void monatsLohnBerechnen(String name) {
        for (int i = 0; i < personen.size(); i++) {
            if (name.equals(personen.get(i).name)) {
                if (personen.get(i) instanceof Arzt) {
                    float nettoLohn = ((Arzt) personen.get(i)).getMonatslohn(false);
                    float bruttoLohn = ((Arzt) personen.get(i)).getMonatslohn(true);
                    System.out.println(personen.get(i).name + ", Arzt:\nNettoLohn: " + nettoLohn + " €\nBruttolohn: " + bruttoLohn + "€");
                }
                if (personen.get(i) instanceof Angestellter) {
                    float nettoLohn = ((Krankenpfleger) personen.get(i)).getMonatslohn(false);
                    float bruttoLohn = ((Krankenpfleger) personen.get(i)).getMonatslohn(true);
                    System.out.println(personen.get(i).name + ", Krankenpfleger:\nNettoLohn: " + nettoLohn + " €\nBruttolohn: " + bruttoLohn + "€");

                }
            }
        }
    }

    void patientVerlegen(String name,int zimmerNummerAlt, int zimmerNummerNeu) {

        Patient patHilfe = new Patient(null, 0, true);
        for (int i = 0; i < personen.size(); i++) {
            if (name.equals(personen.get(i).name)) {
                try {
                    if (zimmer.get(i).patienten.get(i).privatVer) {
                        if (zimmerNummerAlt == zimmer.get(i).zimmerNummer) {
                            patHilfe = new Patient(zimmer.get(i).patienten.get(i).name, zimmer.get(i).patienten.get(i).alter, zimmer.get(i).patienten.get(i).privatVer);
                            zimmer.get(i).patienten.remove(i);
                            System.out.println("Der Patient wurde aus Zimmer " + zimmerNummerAlt + " entfernt.");
                        }
                        if (zimmerNummerNeu == zimmer.get(i).zimmerNummer) {
                            zimmer.get(i).patienten.add(patHilfe);
                            System.out.println("Der Patient ist jetzt in Zimmer " + zimmerNummerNeu + ".");
                        }

                    } else {
                        throw new ExceptionPrivat();
                    }
                } catch (ExceptionPrivat exceptionPrivat) {
                    System.out.println("Der Patient ist nicht privatversichert und kann deshalb nicht verschoben werden.");
                }
            }

        }
    }

    Arzt.Rang rangHilfe(String rangArzt, Arzt.Rang rang) {
        if (rangArzt.equals("AiA"))
            rang = Arzt.Rang.AiA;
        if (rangArzt.equals("Assistenzarzt"))
            rang = Arzt.Rang.Assistenzarzt;
        if (rangArzt.equals("Facharzt"))
            rang = Arzt.Rang.Facharzt;
        if (rangArzt.equals("Oberarzt"))
            rang = Arzt.Rang.Oberarzt;
        if (rangArzt.equals("Chefarzt"))
            rang = Arzt.Rang.Chefarzt;
        System.out.println("test1");
        return rang;
    }

    void sollZeitÄndern(int sollZeit, String name) {
        for (int i = 0; i < personen.size(); i++) {
            if (name.equals(personen.get(i).name)){
                zimmer.get(i).angestellte.get(i).sollZeit = sollZeit;
            }
        }
        System.out.println("Die Sollzeit des Angestellten beträgt nun " + sollZeit + " min");
    }
}
