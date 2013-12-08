 package expression;

import identifiant.*;
import tac.*;

public class VariablePointeur extends OperationArithmetique {

    protected String nomVariable;
    private String symbole;

    public VariablePointeur(String nomVariable, String symbole) {
        this.nomVariable = nomVariable;
        this.symbole = symbole;
    }

    public Identifiant genererCode() {
        return new IdentifiantVariable(symbole + this.nomVariable);
    }

    public String getNomVariable(){
        return nomVariable;
    }

    public EnumType getType(){
        return EnumType.VARIABLE;
    }
}
