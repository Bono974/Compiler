package instruction;

import java.util.*;
import expression.Expression;
import tac.Label;

public class DoWhile extends While {

    public DoWhile(Instruction self, Expression condition) {
        super(condition, self);
    }

    public void genererCode(Label suivant, Stack pileTableVariable) {
        Label avantDo = new Label();

        System.out.println(avantDo + ":");
        self.genererCode(avantDo, pileTableVariable);

        condition.genererJumpCode(avantDo, suivant);
    }

}

