package instruction;

import expression.Expression;
import tac.Label;

public class Declaration extends Instruction {

    private Expression variable;

    public Declaration(Expression variable) {
        this.variable = variable;
    }

    public void genererCode(Label suivant) { }
}

