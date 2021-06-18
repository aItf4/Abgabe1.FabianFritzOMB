abstract class Angestellter extends Person {

    float stundenlohn;
    Steuerklasse steuerklasse;
    Zeitkonto konto = new Zeitkonto();
    int sollZeit;

    public Angestellter(String name, int alter, float stundenlohn, Steuerklasse steuerklasse, int sollZeit) {
        super(name, alter);
        this.stundenlohn = stundenlohn;
        this.steuerklasse = steuerklasse;
        this.sollZeit = sollZeit;
    }

    abstract float getMonatslohn(boolean brutto);
}

enum Steuerklasse {
    SK0(0), SK1(0.12f), Sk2(0.18f), SK3(0.23f), SK4(0.29f), SK5(0.38f), SK6(0.45f);

    private final float steuerklasse;

    Steuerklasse(float steuerklasse){
        this.steuerklasse = steuerklasse;
    }

    public float steuerklasse() {
        return steuerklasse;
    }
}
