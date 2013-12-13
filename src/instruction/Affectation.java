package instruction;

import expression.Expression;
import identifiant.Identifiant;
import tac.EnumType;
import tac.GenererErreur;
import tac.InfosErreur;
import tac.Label;

public class Affectation extends InstructionAbs {

    private Expression variable;
    private Expression droite;
    private EnumType type;
    private InfosErreur info;

    public Affectation(EnumType type, Expression variable, Expression droite,
                       InfosErreur info){
        this.variable = variable;
        this.droite = droite;
        this.type = type;
        this.info = info;
    }

    public void genererCode(Label suivant) {
        EnumType droiteType = this.droite.getType();
        String expName = this.variable.getNomVariable();

        if(this.variable.getType() == EnumType.INTERVALLE)
            GenererErreur.genErreurIntervalle(expName, this.info);
        else {
            Identifiant resDroite = this.droite.genererCode();
            Identifiant resVariable = this.variable.genererCode();
            System.out.println(resVariable + " = " + resDroite);
        }

        GenererErreur.genErreurAffectation(this.type, droiteType, expName,
                                           this.droite.getNomVariable(),
                                           this.info);
    }
}
