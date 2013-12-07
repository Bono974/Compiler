package expression;

import identifiant.*;
import tac.EnumOp;

public class Variable extends OperationArithmetique {

    protected String nomVariable;

    public Variable(String nomVariable) {
        this.nomVariable = nomVariable;
    }

    public Identifiant genererCode(){
        return new IdentifiantVariable(this.nomVariable);
    }

    public EnumOp getType(){
        return EnumOp.VARIABLE;
    }
}

