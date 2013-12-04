public class CharacterMultiple extends Variable {

    public CharacterMultiple(String nomVariable) {
        super(nomVariable);
    }

    public EnumOp getType(){
        return EnumOp.CHARACTERS;
    }
}
