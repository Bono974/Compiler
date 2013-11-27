import java.util.LinkedList;

public class BlocInstruction extends Instruction {
    //Liste chainée d'Instructions
    private LinkedList<Instruction> list;

    public BlocInstruction(LinkedList<Instruction> list) {
        this.list = list;
    }

    public boolean verifier() {
        return true;
    }

    public String evaluer(int registreCourant) {
        //Parcourir la liste et evaluer chaque element
        //idée : pop.evaluer()
        return "TOTO";
    }
}
