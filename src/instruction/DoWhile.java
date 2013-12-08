package instruction;

import java.util.*;
import expression.Expression;
import tac.*;

public class DoWhile extends While {

    public DoWhile(Instruction self, Expression condition) {
        super(condition, self);
    }

    public void genererCode(Label suivant, Stack pileTableVariable) {
        Label avantDo = new Label();
        ModifierStack.pushTV(pileTableVariable);

        System.out.println(avantDo + ":");
        self.genererCode(avantDo, pileTableVariable);

        condition.genererJumpCode(avantDo, suivant);
        ModifierStack.popTV(pileTableVariable);
    }

}

