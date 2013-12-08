package expression;

import tac.*;
import identifiant.Identifiant;

public abstract class Expression {

    public abstract Identifiant genererCode ();
    public abstract void genererJumpCode (Label oui, Label non);

    public abstract EnumType getType ();
    public String getNomVariable() { return "ErreurGetNomVariable"; }
}

