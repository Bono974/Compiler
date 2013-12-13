 package expression;

import identifiant.Identifiant;
import identifiant.IdentifiantVariable;
import tac.EnumType;

public class VariablePointeur extends Variable {

    private String symbole;

    public VariablePointeur(String nomVariable, String symbole) {
        super(nomVariable);
        this.symbole = symbole;
    }

    public Identifiant genererCode() {
        return new IdentifiantVariable(symbole + this.nomVariable);
    }
}
