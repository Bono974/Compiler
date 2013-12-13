package instruction;

import java.util.List;

import expression.Expression;
import tac.EnumType;
import tac.GenererErreur;
import tac.InfosErreur;
import tac.Label;

public class EnumerationOwn extends InstructionAbs {

    private Expression variable;
    private List<Expression> valeurs;
    private EnumType type;
    private InfosErreur info;

    public EnumerationOwn(EnumType type, Expression variable,
                          List<Expression> valeurs, InfosErreur info) {
        this.variable = variable;
        this.valeurs = valeurs;
        this.type = type;
        this.info = info;
    }

    public void genererCode(Label suivant) {
        GenererErreur.genErreurDeclaration(type, variable.getNomVariable(),
                                           info);
    }
}

