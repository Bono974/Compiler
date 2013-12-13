package instruction;

import tac.Label;

public abstract class InstructionAbs implements Instruction {
    public abstract void genererCode(Label suivant);
}
