package expression;

import tac.EnumOp;
import tac.Label;

public class AndBool extends OperationBooleenne {

    public AndBool(Expression gauche, Expression droite) {
        this.gauche = gauche;
        this.droite = droite;
        this.op = EnumOp.AND;
    }

    public void genererJumpCode(Label oui, Label non) {
        Label labelDroite = new Label();
        gauche.genererJumpCode(labelDroite, non);
        System.out.println(labelDroite + ":");
        droite.genererJumpCode(oui, non);
    }
}
