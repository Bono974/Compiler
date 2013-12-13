package instruction;

import expression.Expression;
import tac.Label;
import tac.PileTableVariable;

public class IfThen extends InstructionAbs {

    private Expression condition;
    private Instruction self;

    public IfThen(Expression condition, Instruction self) {
        this.condition = condition;
        this.self = self;
    }

    public void genererCode(Label suivant) {
        Label selfLabel = new Label();
        PileTableVariable.ajouterEnvironnement();
        condition.genererJumpCode(selfLabel, suivant);

        String result = selfLabel + ":";
        System.out.println(result);

        self.genererCode(suivant);
        PileTableVariable.retirerEnvironnement();
    }
}


