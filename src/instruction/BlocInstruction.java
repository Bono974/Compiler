package instruction;

import java.util.List;
import tac.Label;
import tac.PileTableVariable;


public class BlocInstruction extends InstructionAbs {

    //Liste chainée d'Instructions
    private List<Instruction> list;

    public BlocInstruction(List<Instruction> list) {
        this.list = list;
    }

    public void genererCode(Label suivant) {
        PileTableVariable.ajouterEnvironnement();

        for (Instruction ptr: this.list) {
            if (ptr instanceof Declaration) {
                ptr.genererCode(null);
                continue;
            }

            Label suivantInstruction = new Label();
            ptr.genererCode(suivantInstruction);
            System.out.println(suivantInstruction + ":");
        }

        PileTableVariable.retirerEnvironnement();
    }
}
