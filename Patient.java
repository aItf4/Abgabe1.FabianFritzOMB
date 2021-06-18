public class Patient extends Person {

    boolean privatVer;

    public Patient(String name, int alter, boolean privatVer) {
        super(name, alter);
        this.privatVer = privatVer;
    }
}
