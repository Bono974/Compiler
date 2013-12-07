package instruction;

import java.util.*;
import tac.Label;

public abstract class Instruction {

    public abstract void genererCode(Label suivant, Stack pileTableVariable); 
}
