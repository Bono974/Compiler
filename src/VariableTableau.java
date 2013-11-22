public class VariableTableau extends Variable {
    public Expression taille;

    public VariableTableau(String nomVariable, Expression taille) {
        super(nomVariable);
        this.taille = taille;
    }

    public boolean verifier() {
        //Verifier si taille passé en parametre <= this.taille
        return true;
    }

    public String evaluer(EnumOp prevOp){
        // retourne le String de taille evalué en 3-code adress
        // suivi de this.variable [dernier registre taille]
        return "TOTO";
    }
}

