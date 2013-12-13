package identifiant;

public class IdentifiantVariable implements Identifiant {

    protected String nom;

    public IdentifiantVariable(String nom){
        this.nom = nom;
    }

    public String toString() {
        return this.nom;
    }
}

