public class IdentifiantVariableTableau implements Identifiant {

    private String nom;
    private Identifiant taille;

    public IdentifiantVariableTableau(String nom, Identifiant taille){
        this.nom = nom;
        this.taille = taille;
    }

    public String toString() {
        return this.nom + "[" + this.taille + "]";
    }
}

