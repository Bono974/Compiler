package instruction;

import tac.Label;

public abstract class Instruction {

    public abstract void genererCode(Label suivant);
}
