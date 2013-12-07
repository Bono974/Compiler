package instruction;

import java.util.List;
import expression.Expression;
import tac.Label;

public class Declaration extends Instruction {

    private List<Expression> variable;
    //Son type
    //private EnumType type;

    public Declaration(/*EnumType type,*/ List<Expression> variable) {
        //this.type = type;
        this.variable = variable;
    }

    public void genererCode(Label suivant) {
        //for (Expression id: this.variable){
        //    if (id.type == EnumType.VARIABLE)
        //        ADD dans table des variables
        //        tableVariable.add(this.type, this.variable);
        //}
    }
}

