package expression;

import identifiant.Identifiant;
import identifiant.IdentifiantVariable;
import tac.EnumType;

public class Variable extends OperationArithmetique {

    protected String nomVariable;

    public Variable(String nomVariable) {
        this.nomVariable = nomVariable;
    }

    public Identifiant genererCode(){
        return new IdentifiantVariable(this.nomVariable);
    }

    public String getNomVariable(){
        return this.nomVariable;
    }

    public EnumType getType(){
        return EnumType.VARIABLE;
    }
}
