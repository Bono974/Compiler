package instruction;

import java.util.*;
import expression.Expression;
import tac.*;

public class While extends Instruction {

    protected Expression condition;
    protected Instruction self;

    public While(Expression condition, Instruction self) {
        this.condition = condition;
        this.self = self;
    }

    public void genererCode(Label suivant, Stack pileTableVariable) {
        Label avantWhile = new Label();
        Label selfLabel = new Label();
        ModifierStack.pushTV(pileTableVariable);

        System.out.println(avantWhile + ":");
        condition.genererJumpCode(selfLabel, suivant);

        System.out.println(selfLabel + ":");
        self.genererCode(avantWhile, pileTableVariable);
        System.out.println("jump "+ avantWhile);
        ModifierStack.popTV(pileTableVariable);
    }
}
