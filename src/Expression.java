public abstract class Expression {

    public abstract Identifiant genererCode();
    public abstract void genererJumpCode(Label oui, Label non);
    
    public abstract EnumOp getType();
}

