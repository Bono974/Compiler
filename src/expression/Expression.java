package expression;

import identifiant.Identifiant;
import tac.EnumType;
import tac.Label;

public interface Expression {
    public Identifiant genererCode ();
    public void genererJumpCode (Label oui, Label non);

    public EnumType getType ();
    public String getNomVariable();
}

