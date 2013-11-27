public class IfThenElse extends Instruction {
    private Expression condition;

    private Instruction selfIf;
    private Instruction selfThen;

    public IfThenElse(Expression condition, Instruction selfIf, Instruction selfThen) {
        this.condition = condition;
        this.selfIf = selfIf;
        this.selfThen = selfThen;
    }

    public String evaluer(int registreCourant){
       return "TOTO";
    }
}

