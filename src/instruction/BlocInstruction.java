package instruction;

import java.util.List;
import tac.Label;


public class BlocInstruction extends InstructionAbs {

    //Liste chainée d'Instructions
    private List<Instruction> list;

    public BlocInstruction(List<Instruction> list) {
        this.list = list;
    }

    public void genererCode(Label suivant) {
        int tailleListe = this.list.size();

        for (Instruction ptr: this.list) {
            Label suivantInstruction = new Label();
            ptr.genererCode(suivantInstruction);
            System.out.println(suivantInstruction + ":");
        }

        this.list.get(tailleListe - 1).genererCode(suivant);
    }
}
