package expression;

import identifiant.Identifiant;
import tac.EnumType;
import tac.Label;

public abstract class OperationArithmetique extends ExpressionAbs {

    public void genererJumpCode(Label oui, Label non) {
           Identifiant res = genererCode();
           String result = "if " + res + " != 0 jump " + oui +
                           "\njump " + non;
           System.out.println(result);
    }

    public EnumType getType() {
        return EnumType.OP_ARITHMETIQUE;
    }
}
