package instruction;

import java.util.List;

import expression.Expression;
import tac.EnumType;
import tac.Label;
import tac.GenererErreur;
import tac.InfosErreur;

public class Declaration extends InstructionAbs {

    private List<Expression> variable;
    private EnumType type;
    private InfosErreur info;

    public Declaration(EnumType type, List<Expression> variable,
                       InfosErreur info) {
        this.type = type;
        this.variable = variable;
        this.info = info;
    }

    public void genererCode(Label suivant) {
        String expName;

        for (Expression ptr: this.variable) {
            expName = ptr.getNomVariable();
            GenererErreur.genErreurDeclaration(type, expName, info);
        }
    }
}
