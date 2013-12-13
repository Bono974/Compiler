package expression;

import identifiant.Identifiant;
import tac.EnumType;
import tac.Label;

public abstract class ExpressionAbs implements Expression {
    public abstract Identifiant genererCode ();
    public abstract void genererJumpCode (Label oui, Label non);

    public abstract EnumType getType ();
    public String getNomVariable() { return "ErreurGetNomVariable"; }
}
