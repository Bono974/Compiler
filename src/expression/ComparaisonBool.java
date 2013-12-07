package expression;

import tac.Label;;
import tac.EnumOp;
import identifiant.*;

public class ComparaisonBool extends OperationBooleenne {

    private Expression gauche;
    private Expression droite;

    private EnumOp op;

    public ComparaisonBool (Expression gauche, Expression droite, EnumOp op) {
        this.gauche = gauche;
        this.droite = droite;
        this.op = op;
    }

    public void genererJumpCode(Label oui, Label non) {
        Identifiant gaucheRes = gauche.genererCode();
        Identifiant droiteRes = droite.genererCode();
        String res = "if "+ gaucheRes + " " + op + " " + droiteRes + " jump " + oui +
                     "\njump " + non;
        System.out.println(res);
    }

    public Identifiant genererCode() {
        Identifiant gaucheRes = gauche.genererCode();
        Identifiant droiteRes = droite.genererCode();
        Identifiant res = new IdentifiantRegistre();

        String result = res + " = " + gaucheRes + " " + op  + " " + droiteRes;
        System.out.println(result);
        return res;
    }
}
