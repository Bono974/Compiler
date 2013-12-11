package instruction;

import java.util.*;
import tac.Label;


public class BlocInstruction extends Instruction {

    //Liste chainée d'Instructions
    private LinkedList<Instruction> list;

    public BlocInstruction(LinkedList<Instruction> list) {
        this.list = list;
    }

    public void genererCode(Label suivant) {
        int tailleListe = this.list.size();

        for (int i = 0; i < tailleListe - 1; i++) {
            Label suivantInstruction = new Label();
            list.get(i).genererCode(suivantInstruction);
            System.out.println(suivantInstruction + ":");
        }

        list.get(tailleListe - 1).genererCode(suivant);
    }
}
