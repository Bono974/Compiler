package instruction;

import expression.Expression;
import tac.Label;
import tac.PileTableVariable;

public class While extends InstructionAbs {

    protected Expression condition;
    protected Instruction self;

    public While(Expression condition, Instruction self) {
        this.condition = condition;
        this.self = self;
    }

    public void genererCode(Label suivant) {
        Label avantWhile = new Label();
        Label selfLabel = new Label();
        PileTableVariable.ajouterEnvironnement();

        System.out.println(avantWhile + ":");
        condition.genererJumpCode(selfLabel, suivant);

        System.out.println(selfLabel + ":");
        self.genererCode(avantWhile);
        System.out.println("jump "+ avantWhile);
        PileTableVariable.retirerEnvironnement();
    }
}
