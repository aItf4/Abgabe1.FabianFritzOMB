package Abgabe1;

import java.util.ArrayList;

public class Regal {

    ArrayList<Produkt> produkte = new ArrayList<>();
    Produkt produkt;

    void produktHinzufuegen(String name, int anzahl, float preis, Regal regal1) {

        int hilfe = 0;

        for (int i = 0; i < produkte.size(); i++) {
            if (name.equals(produkte.get(i).name)) {
                anzahl += produkte.get(i).bestand;
                Produkt produkt1 = new Produkt(name, anzahl, preis);
                regal1.produkte.set(i, produkt1);
                hilfe++;
            }
        }
        if (hilfe == 0) {
            Produkt produkt = new Produkt(name, anzahl, preis);
            regal1.produkte.add(produkt);
        }
    }

    void produktEntnehmen(String name, int anzahl, float preis, Regal regal1) {
        int hilfe1 = 0;
        int hilfe2 = 0;
        for (int i = 0; i < produkte.size(); i++) {
            if (name.equals(produkte.get(i).name)) {
                hilfe1 = produkte.get(i).bestand;
                hilfe2 = produkte.get(i).bestand - anzahl;
                if (hilfe2 < 0) {
                    System.out.println("...");
                    System.out.println("Tut mir Leid, es sind nur noch " + hilfe1 + "x " + name + " übrig.");
                }
                if (hilfe2 == 0) {
                    regal1.produkte.remove(i);
                    System.out.println("...");
                    System.out.println("Du hast " + anzahl + "x " + name + " aus dem Regal genommen.");
                }
                if (hilfe2 > 0) {
                    Produkt produkt1 = new Produkt(name, hilfe2, preis);
                    regal1.produkte.set(i, produkt1);
                    System.out.println("...");
                    System.out.println("Du hast " + anzahl + "x " + name + " aus dem Regal genommen.");
                }
            }
        }
    }

    void getBestand(String name) {

        for (int i = 0; i < produkte.size(); i++) {
            if (name.equals(produkte.get(i).name)) {
                System.out.println("Aktueller Bestand " + produkte.get(i).name + " : " + produkte.get(i).bestand);
            }
        }
    }

    void getPreisProdukt(String name) {

        for (int i = 0; i < produkte.size(); i++) {

            if (name.equals(produkte.get(i).name)) {
                System.out.println("Preis pro " + produkte.get(i).name + " :   " + produkte.get(i).preis + "€");
            }
        }
    }

    void getInfo(Regal regal1, Regal regal2){

        if (regal1.produkte.size() == 0) {
            System.out.println(" ~~~ Regal 1 ~~~ ");
            System.out.println("Hier ist noch nichts drin.");
        }
        else {
            System.out.println(" ~~~ Regal 1 ~~~ ");
            for (int i = 0; i < produkte.size(); i++) {
                System.out.println("Produkt: " + regal1.produkte.get(i).name);
                System.out.println("Bestand: " + regal1.produkte.get(i).bestand);
                System.out.println("Preis: " + regal1.produkte.get(i).preis + " €");
                System.out.println("--------------------------------------");
            }
        }
        if (regal2.produkte.size() == 0) {
            System.out.println(" ~~~ Regal 2 ~~~ ");
            System.out.println("Hier ist noch nichts drin.");
        }
        else {
            System.out.println(" ~~~ Regal 2 ~~~ ");
            for (int i = 0; i < produkte.size(); i++) {
                System.out.println("Produkt: " + regal2.produkte.get(i).name);
                System.out.println("Bestand: " + regal2.produkte.get(i).bestand);
                System.out.println("Preis: " + regal2.produkte.get(i).preis + " €");
                System.out.println("--------------------------------------");
            }
        }
    }
}
