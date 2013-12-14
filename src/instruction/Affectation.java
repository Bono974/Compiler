package instruction;

import expression.Expression;
import identifiant.Identifiant;
import identifiant.IdentifiantRegistre;
import tac.EnumType;
import tac.GenererErreur;
import tac.InfosErreur;
import tac.Label;

public class Affectation extends InstructionAbs {

    private Expression variable;
    private Expression droite;
    private EnumType type;
    private InfosErreur info;

    private Instruction procedure;

    public Affectation(EnumType type, Expression variable, Expression droite,
                       InfosErreur info){
        this.variable = variable;
        this.droite = droite;
        this.type = type;
        this.info = info;

        this.procedure = null;
    }

    public Affectation(EnumType type, Expression variable, Instruction procedure,
                       InfosErreur info){
        this.variable = variable;
        this.procedure = procedure;
        this.type = type;
        this.info = info;

        this.droite = null;
    }

    public void genererCode(Label suivant) {
        if (this.procedure != null)
            genererCodeProcedure(suivant);
        else if (this.droite != null)
            genererCodeExpression(suivant);
    }

    public void genererCodeExpression(Label suivant) {
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

    public void genererCodeProcedure(Label suivant) {
        Identifiant resVariable = this.variable.genererCode();

        this.procedure.genererCode(suivant);

        int registrePrecedent = IdentifiantRegistre.precedent();
        System.out.println(resVariable + " = t" + registrePrecedent);
    }

}
