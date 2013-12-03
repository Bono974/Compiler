public class CharacterMultiple extends Expression {

    protected String nomVariable;

    public CharacterMultiple(String nomVariable) {
        this.nomVariable = nomVariable;
    }

    public void genererJumpCode(Label oui, Label non) {}

    public Identifiant genererCode(){
        return new IdentifiantVariable(this.nomVariable);
    }

    public EnumOp getType(){
        return EnumOp.CHARACTERS;
    }
}
