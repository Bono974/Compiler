package expression;

import identifiant.*;

public class Variable extends OperationArithmetique {

    protected String nomVariable;

    public Variable(String nomVariable) {
        this.nomVariable = nomVariable;
    }

    public Identifiant genererCode(){
        return new IdentifiantVariable(this.nomVariable);
    }
}

