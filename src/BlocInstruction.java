import java.util.LinkedList;

public class BlocInstruction extends Instruction {

    //Liste chainée d'Instructions
    private LinkedList<Instruction> list;

    public BlocInstruction(LinkedList<Instruction> list) {
        this.list = list;
    }

    public void genererCode(Label suivant) {
    //todo label
        for (Instruction ptr : this.list)
            ptr.genererCode(suivant);
    }
}
