package expression;

import tac.*;
//import identfiant.identifiant;

public abstract class OperationBooleenne extends Expression {

    //public Identifiant genererCode() { return null; };

    public EnumType getType(){
        return EnumType.OP_BOOL;
    }
}

