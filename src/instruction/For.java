package instruction;

import java.util.*;
import expression.Expression;
import tac.*;

public class For extends Instruction {

    private Instruction affectation;
    private Expression condition;
    private Instruction increment;

    private Instruction self;

    public For(Instruction affectation, Expression condition, Instruction increment, Instruction self) {
        this.affectation = affectation;
        this.condition = condition;
        this.increment = increment;
        this.self = self;
    }

    public void genererCode(Label suivant, Stack pileTableVariable) {
        Label avantFor = new Label();
        Label selfLabel = new Label();
        ModifierStack.pushTV(pileTableVariable);

        affectation.genererCode(avantFor, pileTableVariable);
        System.out.println(avantFor + ":");
        condition.genererJumpCode(selfLabel, suivant);

        System.out.println(selfLabel + ":");
        self.genererCode(avantFor, pileTableVariable);

        if(increment != null)
            increment.genererCode(avantFor, pileTableVariable);

        System.out.println("jump "+ avantFor);
        ModifierStack.popTV(pileTableVariable);
    }
}

