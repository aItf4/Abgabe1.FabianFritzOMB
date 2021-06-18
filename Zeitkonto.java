public class Zeitkonto {

    int sollZeit = 0;
    int istZeit = 0;

    static void minToHour(int minute) {
        int hour = minute / 60;
        int min  = minute % 60;
        System.out.println(minute + " Minuten sind " + hour + ":" + min + "h.");
    }

    int gearbeiteteZeit() {
        int gearbeiteteZeit = istZeit - sollZeit;
        return gearbeiteteZeit;
    }

    void sollZeitÄndern(int zeit) {
        sollZeit = zeit;
    }

    void istZeitÄndern(int zeit) {
        istZeit += zeit;
    }

}
