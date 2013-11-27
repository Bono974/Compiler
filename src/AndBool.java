public class AndBool extends OperationBooleenne {

    private Expression gauche;
    private Expression droite;

    public AndBool (Expression gauche, Expression droite) {
        this.gauche = gauche;
        this.droite = droite;
    }

    public void genererJumpCode(Label oui, Label non) {
        Label labelDroite = new Label();
        gauche.genererJumpCode(labelDroite, non);
        System.out.println(labelDroite + ":");
        droite.genererJumpCode(oui, non);
    }
}
