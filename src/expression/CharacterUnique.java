package expression;

import tac.EnumOp;

public class CharacterUnique extends Variable {

    public CharacterUnique(String nomVariable) {
        super(nomVariable);
    }

    public EnumOp getType() {
        return EnumOp.CHARACTER;
    }
}
