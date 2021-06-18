public class Krankenpfleger extends Angestellter {

    Schicht schicht;

    public Krankenpfleger(String name, int alter, float stundenlohn, Steuerklasse steuerklasse, Schicht schicht, int sollZeit) {
        super(name, alter, stundenlohn, steuerklasse, sollZeit);
        this.schicht = schicht;
    }

    enum Schicht {
        Frühschicht(0.05f), Spätschicht(0.1f), Nachtschicht(0.25f);

        private final float bonus;

        Schicht(float bonus) {
            this.bonus = bonus;
        }

        public float bonus() {
            return bonus;
        }
    }

    float getMonatslohn(boolean brutto) {
        float monatsLohn = 0;
        float üBonus = 0.2f;
        float nettoLohn = (konto.istZeit / 60f) * stundenlohn;

        if (!brutto) {
            if (konto.gearbeiteteZeit() > 0) {
                üBonus = (konto.gearbeiteteZeit() / 60f) * üBonus;
                monatsLohn += monatsLohn * schicht.bonus() + üBonus;
            }
        } else {
            switch (steuerklasse) {
                case SK0 -> monatsLohn = monatsLohn;
                case SK1 -> monatsLohn = monatsLohn * 0.88f;
                case Sk2 -> monatsLohn = monatsLohn * 0.82f;
                case SK3 -> monatsLohn = monatsLohn * 0.77f;
                case SK4 -> monatsLohn = monatsLohn * 0.71f;
                case SK5 -> monatsLohn = monatsLohn * 0.62f;
                case SK6 -> monatsLohn = monatsLohn * 0.55f;
            }
        }
        return monatsLohn;
    }
}
