package expression;

import identifiant.Identifiant;
import identifiant.IdentifiantVariableTableau;
import tac.EnumType;

public class VariableTableau extends Variable {

    public Expression taille; // ou indice

    public VariableTableau(String nomVariable, Expression taille) {
        super(nomVariable);
        this.taille = taille;
    }

    public Identifiant genererCode() {
        Identifiant res = this.taille.genererCode();
        return new IdentifiantVariableTableau(this.nomVariable, res);
    }

    public EnumType getType(){
        return EnumType.TABLEAU;
    }
}
