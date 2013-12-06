package instruction;

import expression.Expression;
import tac.Label;

public class Declaration extends Instruction {

    private Expression variable;
    //Son type
    //private EnumType type;

    public Declaration(/*EnumType type,*/ Expression variable) {
        //this.type = type;
        this.variable = variable;
    }

    public void genererCode(Label suivant) {
        //ADD dans table des variables
        //tableVariable.add(this.type, this.variable);
    }
}

