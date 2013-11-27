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
        String res = "if "+ gaucheRes + " " + op + " " + droiteRes + "goto " + oui + "\n" +
                    "goto " + non;
        System.out.println(res);
    }
}
