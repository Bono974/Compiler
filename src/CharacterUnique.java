public class CharacterUnique extends Expression {

    protected String nomVariable;

    public CharacterUnique(String nomVariable) {
        this.nomVariable = nomVariable;
    }

    public void genererJumpCode(Label oui, Label non) {}

    public Identifiant genererCode(){
        return new IdentifiantVariable(this.nomVariable);
    }

    public EnumOp getType(){
        return EnumOp.CHARACTER;
    }
}
