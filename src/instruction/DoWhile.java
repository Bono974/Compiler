package instruction;

import expression.Expression;
import tac.Label;
import tac.PileTableVariable;

public class DoWhile extends While {

    public DoWhile(Instruction self, Expression condition) {
        super(condition, self);
    }

    public void genererCode(Label suivant) {
        Label avantDo = new Label();
        PileTableVariable.ajouterEnvironnement();

        System.out.println(avantDo + ":");
        self.genererCode(avantDo);

        condition.genererJumpCode(avantDo, suivant);
        PileTableVariable.retirerEnvironnement();
    }

}

