package expression;

import identifiant.Identifiant;
import identifiant.IdentifiantRegistre;
import tac.EnumType;
import tac.EnumOp;
import tac.Label;

public abstract class OperationBooleenne extends ExpressionAbs {

    protected Expression gauche;
    protected Expression droite;
    protected EnumOp op;

    public void genererJumpCode(Label oui, Label non) {
        Identifiant res = genererCode();
        String result = "if " + res + " != 0 jump " + oui +
                        "\njump " + non;
        System.out.println(result);
    }

    public Identifiant genererCode() {
        Identifiant gaucheRes = gauche.genererCode();
        Identifiant droiteRes = droite.genererCode();
        Identifiant res = new IdentifiantRegistre();

        String result = res + " = " + gaucheRes + " " + op  + " " + droiteRes;
        System.out.println(result);
        return res;
    }

    public EnumType getType(){
        return EnumType.OP_BOOL;
    }
}

