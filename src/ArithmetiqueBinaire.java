public class ArithmetiqueBinaire extends OperationArithmetique {

    private Expression gauche;
    private Expression droite;
    private EnumOp op;

    private Identifiant res;

    public ArithmetiqueBinaire(Expression gauche, Expression droite, EnumOp op) {
        this.gauche = gauche;
        this.droite = droite;
        this.op = op;
    }

    public Identifiant genererCode(){
        Identifiant gaucheRes = gauche.genererCode();
        Identifiant droiteRes = droite.genererCode();
        Identifiant res = new IdentifiantRegistre();

        String result = res + " = " + gaucheRes + " " + op  + " " +droiteRes;
        System.out.println(result);
        return res;
    }
}
