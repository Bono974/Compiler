package expression;

import identifiant.Identifiant;
import identifiant.IdentifiantRegistre;
import tac.EnumOp;
import tac.InfosErreur;
import tac.GenererErreur;

public class ArithmetiqueBinaire extends OperationArithmetique {

    private Expression gauche;
    private Expression droite;
    private EnumOp op;
    private InfosErreur info;

    public ArithmetiqueBinaire(Expression gauche, Expression droite, EnumOp op,
                               InfosErreur info) {
        this.gauche = gauche;
        this.droite = droite;
        this.op = op;
        this.info = info;
    }

    public Identifiant genererCode() {
        Identifiant gaucheRes = gauche.genererCode();
        Identifiant droiteRes = droite.genererCode();
        Identifiant res = new IdentifiantRegistre();

        GenererErreur.genErreurOperation(this.gauche.getType(),
                                         this.droite.getType(),
                                         this.info);

        String result = res + " = " + gaucheRes + " " + this.op  + " " +
                        droiteRes;
        System.out.println(result);
        return res;
    }
}
