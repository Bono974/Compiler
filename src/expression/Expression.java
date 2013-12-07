package expression;

import tac.EnumOp;
import tac.Label;
import identifiant.Identifiant;

public abstract class Expression {

    public abstract Identifiant genererCode ();
    public abstract void genererJumpCode (Label oui, Label non);

    public abstract EnumOp getType ();
    public String getNomVariable() { return "ErreurGetNomVariable"; }
}

