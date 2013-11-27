public class For extends Instruction {

    private Instruction affectation;
    private Expression condition;
    private Expression increment;

    private Instruction self;

    public For(Instruction affectation, Expression condition, Expression increment, Instruction self) {
        this.affectation = affectation;
        this.condition = condition;
        this.increment = increment;
        this.self = self;
    }

    public void genererCode(Label suivant) { }
}

