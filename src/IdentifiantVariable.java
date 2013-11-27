public class IdentifiantVariable implements Identifiant {

    private String nom;

    public IdentifiantVariable(String nom){
        this.nom = nom;
    }

    public String toString() {
        return this.nom;
    }
}

