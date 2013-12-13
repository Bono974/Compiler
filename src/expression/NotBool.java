package expression;

import identifiant.Identifiant;
import identifiant.IdentifiantRegistre;
import tac.Label;

public class NotBool extends OperationBooleenne {

    private Expression exp;

    public NotBool(Expression exp) {
        this.exp = exp;
    }

    public void genererJumpCode(Label oui, Label non) {
        this.exp.genererJumpCode(non, oui);
    }

    public Identifiant genererCode() {
        Identifiant operande = exp.genererCode();
        Identifiant res = new IdentifiantRegistre();
        String result = res + " = ! " + operande;
        System.out.println(result);
        return res;
    }
}
