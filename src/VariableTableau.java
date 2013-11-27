public class VariableTableau extends Variable {
    public Expression taille;

    public VariableTableau(String nomVariable, Expression taille) {
        super(nomVariable);
        this.taille = taille;
    }

    public Identifiant genererCode() {
        return null;
    }
}

