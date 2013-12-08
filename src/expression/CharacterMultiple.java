package expression;

import tac.*;

public class CharacterMultiple extends Variable {

    public CharacterMultiple(String nomVariable) {
        super(nomVariable);
    }

    public EnumType getType() {
        return EnumType.CHARACTERS;
    }
}
