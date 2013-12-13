package instruction;

import tac.Label;

public interface Instruction {
    public void genererCode(Label suivant);
}
