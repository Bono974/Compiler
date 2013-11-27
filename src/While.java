public class While extends Instruction {
    private Expression condition;
    private Instruction self;

    public While(Expression condition, Instruction self) {
        this.condition = condition;
        this.self = self;
    }

    public void genererCode(Label suivant) {
        Label avantWhile = new Label();
        Label selfLabel = new Label();

        System.out.println(avantWhile + ":");
        condition.genererJumpCode(selfLabel, suivant);

        System.out.println(selfLabel + ":");
        self.genererCode(avantWhile);
        System.out.println("goto "+ avantWhile);
    }
}
