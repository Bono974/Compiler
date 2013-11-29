public class VariableTableau extends Variable {
    public Expression taille;

    public VariableTableau(String nomVariable, Expression taille) {
        super(nomVariable);
        this.taille = taille;
    }

    public Identifiant genererCode() {
        Identifiant res = this.taille.genererCode();
        return new IdentifiantVariableTableau(this.nomVariable, res);
    }
}
