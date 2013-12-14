package expression;

import identifiant.Identifiant;
import tac.EnumOp;
import tac.Label;

public class ComparaisonBool extends OperationBooleenne {

    public ComparaisonBool (Expression gauche, Expression droite, EnumOp op) {
        this.gauche = gauche;
        this.droite = droite;
        this.op = op;
    }

    public void genererJumpCode(Label oui, Label non) {
        Identifiant gaucheRes = gauche.genererCode();
        Identifiant droiteRes = droite.genererCode();
        String res = "if "+ gaucheRes + " " + this.op + " " + droiteRes +
                     " jump " + oui + "\njump " + non;
        System.out.println(res);
    }
}
