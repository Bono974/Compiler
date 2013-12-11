package instruction;

import java.util.*;
import tac.*;

public abstract class Instruction {

    public abstract void genererCode(Label suivant); 
}
