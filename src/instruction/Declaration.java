package instruction;

import java.util.*;

import expression.Expression;
import tac.*;

public class Declaration extends Instruction {

    private List<Expression> variable;
    private EnumType type;

    public Declaration(EnumType type, List<Expression> variable) {
        this.type = type;
        this.variable = variable;
    }

    public void genererCode(Label suivant, Stack pileTableVariable) {
        String expName;

        for (int i = 0; i < variable.size(); i++){
            HashMap hm = (HashMap)pileTableVariable.peek();
            expName = variable.get(i).getNomVariable();
            GenererErreur.genErreurDeclaration(hm, type, expName);
        }
    }
}

