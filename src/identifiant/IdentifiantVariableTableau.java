package identifiant;

public class IdentifiantVariableTableau extends IdentifiantVariable {

    private Identifiant taille;

    public IdentifiantVariableTableau(String nom, Identifiant taille){
        super(nom);
        this.taille = taille;
    }

    public String toString() {
        return super.toString() + "[" + this.taille + "]";
    }
}

