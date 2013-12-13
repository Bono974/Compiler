package instruction;

import expression.Expression;
import tac.Label;
import tac.PileTableVariable;

public class For extends InstructionAbs {

    private Instruction affectation;
    private Expression condition;
    private Instruction increment;

    private Instruction self;

    public For(Instruction affectation, Expression condition,
               Instruction increment, Instruction self) {
        this.affectation = affectation;
        this.condition = condition;
        this.increment = increment;
        this.self = self;
    }

    public void genererCode(Label suivant) {
        Label avantFor = new Label();
        Label selfLabel = new Label();
        PileTableVariable.ajouterEnvironnement();

        affectation.genererCode(avantFor);
        System.out.println(avantFor + ":");
        condition.genererJumpCode(selfLabel, suivant);

        System.out.println(selfLabel + ":");
        self.genererCode(avantFor);

        if(increment != null)
            increment.genererCode(avantFor);

        System.out.println("jump "+ avantFor);
        PileTableVariable.retirerEnvironnement();
    }
}

