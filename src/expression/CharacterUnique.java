package expression;

import tac.EnumType;

public class CharacterUnique extends Variable {

    public CharacterUnique(String nomVariable) {
        super(nomVariable);
    }

    public EnumType getType() {
        return EnumType.CHARACTER;
    }
}
