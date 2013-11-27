public class IdentifiantRegistre implements Identifiant {

    public static int suivant = 0;
    public int self;

    public IdentifiantRegistre(){
        this.self = this.suivant++;
    }

    public void reinitialiser() {
        suivant = 0;
    }

    public String toString() {
        return "t" + this.self;
    }
}

