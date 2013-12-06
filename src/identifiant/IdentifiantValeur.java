package identifiant;

public class IdentifiantValeur<T> implements Identifiant {

    private T valeur;

    public IdentifiantValeur(T valeur){
        this.valeur = valeur;
    }

    public String toString() {
        return "" + this.valeur;
    }
}

