package Abgabe1;

import java.util.Scanner;

public class Kiosk {
    Regal regal1 = new Regal();
    Regal regal2 = new Regal();
    String name;
    int anzahl;
    float preis;

    boolean kioskoffen = true;


    void update() {

        Scanner s = new Scanner(System.in);
        String str;
        System.out.println("~~~ Kiosk ~~~\n");
        System.out.println("Gib /help ein für eine Liste aller Befehle.");

        while (kioskoffen) {

            str = s.nextLine();

            if (str.equals("/help")) {
                help();
            }
            if (str.equals("/add")) {
                System.out.println("Gib den Produktnamen ein: ");
                name = s.nextLine();
                System.out.println("Gib nun die Anzahl des Produktes ein, das hinzugefügt werden soll: ");
                anzahl = s.nextInt();
                System.out.println("Gib nun den Preis des Produktes ein: (Bsp.: 0,5 entspricht 50ct)");
                preis = s.nextFloat();
                System.out.println("Du hast " + anzahl + "x " + name + " zum Preis von je " + preis + "€ hinzugefügt.");
                regal1.produktHinzufuegen(name, anzahl, preis, regal1);

            }
            if (str.equals("/remove")) {
                System.out.println("Welches Produkt möchtest du herausnehmen?");
                name = s.nextLine();
                System.out.println("Und wie viel darf's sein?");
                anzahl = s.nextInt();
                System.out.println("Du möchtest " + anzahl + "x " + name + " aus dem Regal nehmen.");
                regal1.produktEntnehmen(name, anzahl, preis, regal1);
                regal2.produktEntnehmen(name, anzahl, preis, regal2);
            }
            if (str.equals("/move")) {
                System.out.println("Welches Produkt soll verschoben werden?");
                name = s.nextLine();
                produktVerschieben(name, anzahl, preis, regal1, regal2);
            }
            if (str.equals("/price")) {
                System.out.println("Von welchem Produkt soll der Preis ausgegeben werden?");
                name = s.nextLine();
                regal1.getPreisProdukt(name);
                regal2.getPreisProdukt(name);
            }
            if (str.equals("/stock")) {
                System.out.println("Zu welchem Produkt soll der Bestand ausgegeben werden?");
                name = s.nextLine();
                regal1.getBestand(name);
                regal2.getBestand(name);
            }

            if (str.equals("/info")) {
                System.out.println("~~~ Aktueller Lagerbestand ~~~\n");
                regal1.getInfo(regal1, regal2);
            }

            if (str.equals("/byebye")) {
                kioskoffen = false;
            }
        }

    }

    static void produktVerschieben(String name, int anzahl, float preis, Regal regal1, Regal regal2) {
        for (int i = 0; i < regal1.produkte.size(); i++) {
            if (name.equals(regal1.produkte.get(i).name)) {
                name = regal1.produkte.get(i).name;
                anzahl = regal1.produkte.get(i).bestand;
                preis = regal1.produkte.get(i).preis;
                int hilfe8 = 0;

                for (int j = 0; j < regal2.produkte.size(); j++) {
                    if (name.equals(regal2.produkte.get(j).name)) {
                        anzahl += regal2.produkte.get(j).bestand;
                        Produkt produkt1 = new Produkt(regal1.produkte.get(j).name, anzahl, regal1.produkte.get(i).preis);
                        regal2.produkte.set(j, produkt1);
                        hilfe8++;
                    }
                }
                if (hilfe8 == 0) {
                    Produkt produkt = new Produkt(name, anzahl, preis);
                    regal2.produkte.add(produkt);
                }

                regal1.produkte.remove(i);
            }
        }
            System.out.println("Das Produkt '" + name + "' wurde in Regal 2 verschoben.");
        /*int hilfe3 = 0;
        for (int i = 0; i < regal1.produkte.size(); i++) {
            if (name.equals(regal1.produkte.get(i).name)) {
                hilfe3++;
            }
            if (hilfe3 > 0) {


            } else {
                Produkt produkt3 = new Produkt(regal2.produkte.get(i).name, regal2.produkte.get(i).bestand, regal2.produkte.get(i).preis);
                regal1.produkte.add(produkt3);
                regal2.produkte.remove(i);
                System.out.println("Das Produkt '" + name + "' wurde in Regal 1 verschoben.");
                break;
            }
        }*/

        }


        void help () {
            System.out.println("Die folgenden Befehle kannst du benutzen:\n");
            System.out.println("/add -> um etwas ins Regal zu legen.");
            System.out.println("/remove -> um etwas aus dem Regal zu nehmen.");
            System.out.println("/price -> um den Preis eines bestimmten Produkts zu erfahren.");
            System.out.println("/stock -> um die Anzahl eines bestimmten Produktes zu erfahren.");
            System.out.println("/info -> um alle Infos zu allen Produkten auszugeben.");
            System.out.println("/move -> um einen Gegenstand von einem Regal ins andere zu verschieben.");
            System.out.println("/byebye -> um das Program zu beenden.");
        }
    }

