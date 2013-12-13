package expression;

import tac.Label;
import tac.EnumOp;

public class OrBool extends OperationBooleenne {

    public OrBool (Expression gauche, Expression droite) {
        this.gauche = gauche;
        this.droite = droite;
        this.op = EnumOp.OR;
    }

    public void genererJumpCode(Label oui, Label non) {
        Label labelDroite = new Label();
        gauche.genererJumpCode(oui, labelDroite);
        System.out.println(labelDroite + ":");
        droite.genererJumpCode(oui, non);
    }
}
