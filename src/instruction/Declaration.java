package instruction;

import java.util.*;
import expression.Expression;
import tac.*;

public class Declaration extends Instruction {

    private Expression variable;
    //Son type
    private EnumType type;

    public Declaration(EnumType type, Expression variable) {
        this.type = type;
        this.variable = variable;
    }

    public void genererCode(Label suivant, Stack pileTableVariable) {
        //ADD dans table des variables
        //tableVariable.add(this.type, this.variable);

        HashMap hm = (HashMap)pileTableVariable.peek();

        if(GenererErreur.genErreur(hm, type, variable.genererCode().toString()))
            hm.put(variable.genererCode().toString(), type);
    }
}

