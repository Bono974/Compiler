package instruction;

import java.util.*;
import expression.Expression;
import tac.Label;

public class IfThen extends Instruction {

    private Expression condition;
    private Instruction self;

    public IfThen(Expression condition, Instruction self) {
        this.condition = condition;
        this.self = self;
    }

    public void genererCode(Label suivant, Stack pileTableVariable) {
        Label selfLabel = new Label();
        condition.genererJumpCode(selfLabel, suivant);

        String result = selfLabel + ":";
        System.out.println(result);

        self.genererCode(suivant, pileTableVariable);
    }
}


