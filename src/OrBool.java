public class OrBool extends OperationBooleenne {

    private Expression gauche;
    private Expression droite;

    public OrBool (Expression gauche, Expression droite) {
        this.gauche = gauche;
        this.droite = droite;
    }

    public void genererJumpCode(Label oui, Label non) {
        Label labelDroite = new Label();
        gauche.genererJumpCode(oui, labelDroite);
        System.out.println(labelDroite + ":");
        droite.genererJumpCode(oui, non);
    }

    public Identifiant genererCode(){
        return null;
    }
}
