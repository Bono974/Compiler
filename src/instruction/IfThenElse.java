package instruction;

import java.util.*;
import expression.Expression;
import tac.*;

public class IfThenElse extends Instruction {

    private Expression condition;

    private Instruction selfIf;
    private Instruction selfElse;

    public IfThenElse(Expression condition, Instruction selfIf, Instruction selfElse) {
        this.condition = condition;
        this.selfIf = selfIf;
        this.selfElse = selfElse;
    }

    public void genererCode(Label suivant, Stack pileTableVariable) {
        Label oui = new Label();
        Label non = new Label();
        ModifierStack.pushTV(pileTableVariable);
        condition.genererJumpCode(oui, non);

        System.out.println(oui + ":");
        selfIf.genererCode(suivant, pileTableVariable);

        System.out.println("jump " + suivant +
                           "\n" + non + ":");
        selfElse.genererCode(suivant, pileTableVariable);
        ModifierStack.popTV(pileTableVariable);
    }
}