package expression;

import tac.EnumType;

public class CharacterMultiple extends Variable {

    public CharacterMultiple(String nomVariable) {
        super(nomVariable);
    }

    public EnumType getType() {
        return EnumType.CHARACTERS;
    }
}
