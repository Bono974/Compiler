public class Instructions extends Instruction {
    //Liste chainée d'Instructions
    private Instruction self;
    private Instruction next;

    public Instructions(Instruction inst) {
        this.self = inst;
        this.next = null;
    }

    public void addInstruction(Instruction next) {
        this.next = next;
    }

    public boolean verifier() {
        return true;
    }

    public String evaluer(int registreCourant) {
        return (this.next != null)? (this.self.evaluer(0) +
                this.next.evaluer(0)):(this.self.evaluer(0));
    }
}

