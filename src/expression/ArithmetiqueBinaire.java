package expression;

import tac.*;
import identifiant.*;

public class ArithmetiqueBinaire extends OperationArithmetique {

    private Expression gauche;
    private Expression droite;
    private EnumOp op;
    private InfosErreur info;
    private Identifiant res;

    public ArithmetiqueBinaire(Expression gauche, Expression droite, EnumOp op, InfosErreur info) {
        this.gauche = gauche;
        this.droite = droite;
        this.op = op;
        this.info = info;
    }

    public Identifiant genererCode() {
        Identifiant gaucheRes = gauche.genererCode();
        Identifiant droiteRes = droite.genererCode();
        Identifiant res = new IdentifiantRegistre();

        GenererErreur.genErreurOperation(gauche.getType(), droite.getType(), info);

        String result = res + " = " + gaucheRes + " " + op  + " " + droiteRes;
        System.out.println(result);
        return res;
    }
}
