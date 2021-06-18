import java.util.ArrayList;

public class Zimmer {

    ArrayList<Patient> patienten = new ArrayList<>();
    ArrayList<Angestellter> angestellte = new ArrayList<>();

    int zimmerNummer;
    int anzahlBetten;

    public Zimmer(int zimmerNummer, int anzahlBetten) {
        this.zimmerNummer = zimmerNummer;
        this.anzahlBetten = anzahlBetten;
    }
}
