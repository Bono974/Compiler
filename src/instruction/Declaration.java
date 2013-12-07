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
        //ADD dans table des variables
        //tableVariable.add(this.type, this.variable);
        String expName;

        for (Expression exp: variable ) {
            HashMap hm = (HashMap)pileTableVariable.peek();
            
            if(exp.getType() == EnumOp.INTERVALLE)
                expName = exp.getNomVariable();
            else
                expName = exp.genererCode().toString();


            if(GenererErreur.genErreur(hm, type, expName)) {}
                hm.put(expName, type);
        }
    }
}

