package identifiant;

public class IdentifiantRegistre implements Identifiant {

    private static int suivant = 0;
    private int self;

    public IdentifiantRegistre() {
        this.self = this.suivant++;
    }

    public static void reinitialiser() {
        suivant = 0;
    }

    public static int precedent() {
        return suivant - 1;
    }

    public String toString() {
        return "t" + this.self;
    }
}

