package instruction;
import java_cup.runtime.Symbol;

import java.util.*;

import expression.Expression;
import tac.*;

public class Declaration extends Instruction {

    private List<Expression> variable;
    private EnumType type;
    private InfosErreur info;

    public Declaration(EnumType type, List<Expression> variable, InfosErreur info) {
        this.type = type;
        this.variable = variable;
        this.info = info; 
    }

    public void genererCode(Label suivant) {
        String expName;

        for (int i = 0; i < variable.size(); i++){
            //HashMap hm = (HashMap)pileTableVariable.peek();
            expName = variable.get(i).getNomVariable();
            GenererErreur.genErreurDeclaration(type, expName, info);
        }
    }
}

