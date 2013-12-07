package expression;

import identifiant.*;

public class VariableIntervalle extends OperationArithmetique {

    protected String nomVariable;
    protected Expression borneInf;
    protected Expression borneSup;

    public VariableIntervalle(String nomVariable, Expression borneInf, Expression borneSup) {
        this.nomVariable = nomVariable;
        this.borneInf = borneInf;
        this.borneSup = borneSup;
    }

    public Identifiant genererCode(){
        //TODO
        Identifiant inf = this.borneInf.genererCode();
        //Identifiant sup = this.borneSup.genererCode();
        return new IdentifiantVariableTableau(this.nomVariable, inf);
    }
}

