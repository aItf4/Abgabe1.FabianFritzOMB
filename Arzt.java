public class Arzt extends Angestellter {

    Rang rang;

    public Arzt(String name, int alter, float stundenlohn, Steuerklasse steuerklasse, Rang rang, int sollzeit) {
        super(name, alter, stundenlohn, steuerklasse, sollzeit);
        this.rang = rang;
    }

    enum Rang {
        AiA(0), Assistenzarzt(0.1f), Facharzt(0.25f), Oberarzt(0.4f), Chefarzt(0.8f);

        private final float bonus;

        Rang(float bonus) {
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
                monatsLohn += nettoLohn * rang.bonus() + üBonus;
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
