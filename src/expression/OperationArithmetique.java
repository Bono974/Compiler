package expression;

import tac.*;
import identifiant.*;

public abstract class OperationArithmetique extends Expression {

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
