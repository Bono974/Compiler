package instruction;

import java.util.*;
import expression.Expression;
import tac.*;

public class IfThen extends Instruction {

    private Expression condition;
    private Instruction self;

    public IfThen(Expression condition, Instruction self) {
        this.condition = condition;
        this.self = self;
    }

    public void genererCode(Label suivant) {
        Label selfLabel = new Label();
        //ModifierStack.pushTV(pileTableVariable);
        PileTableVariable.ajouterEnvironnement();
        condition.genererJumpCode(selfLabel, suivant);

        String result = selfLabel + ":";
        System.out.println(result);

        self.genererCode(suivant);
        //ModifierStack.popTV(pileTableVariable);
        PileTableVariable.retirerEnvironnement();
    }
}


