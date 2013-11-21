public class OperationArithmetique extends Operation {
	protected int registreCourant;

    public OperationArithmetique(Expression gauche, Expression droite, EnumOp op, int registreCourant) {
        super(gauche, droite, op);
        this.registreCourant = registreCourant;
    }

    public OperationArithmetique(Expression unaire, EnumOp op, int registreCourant) {
        super(unaire, op);
        this.registreCourant = registreCourant;
    }

    public String evaluer(EnumOp prevOp) {
        String result = "";

        if (prevOp == EnumOp.UNKNOWN)
            result += gauche.evaluer(null) + " " + op + " " +  droite.evaluer(op);
        else
            result += gauche.evaluer(null) + " " +  op + " " + droite.evaluer(op) +
                "\nt" + (registreCourant+1) + " = t" + (registreCourant);

        return result;
    }
}
