package expression;

import identifiant.Identifiant;
import identifiant.IdentifiantVariableTableau;
import tac.EnumType;

public class VariableIntervalle extends Variable {
    // Partiellement géré

    private Expression borneInf;
    private Expression borneSup;

    public VariableIntervalle(String nomVariable, Expression borneInf,
                              Expression borneSup) {
        super(nomVariable);
        this.borneInf = borneInf;
        this.borneSup = borneSup;
    }

    public Identifiant genererCode(){
        Identifiant inf = this.borneInf.genererCode();
        //Identifiant sup = this.borneSup.genererCode();
        return new IdentifiantVariableTableau(this.nomVariable, inf);
    }

    public EnumType getType(){
        return EnumType.INTERVALLE;
    }
}

