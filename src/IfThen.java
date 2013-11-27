public class IfThen extends Instruction {
    private Expression condition;

    private Instruction self;

    public IfThen(Expression condition, Instruction self) {
        this.condition = condition;
        this.self = self;
    }

    public String evaluer(int registreCourant){
        return "TOTO";
    }

}


