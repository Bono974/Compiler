public class OperationBooleenne extends Operation {
    public OperationBooleenne(Expression gauche, Expression droite, EnumOp op) {
        super(gauche, droite, op);
    }

    public OperationBooleenne(Expression unaire, EnumOp op) {
        super(unaire, op);
    }

    public String evaluer(EnumOp prevOp) {
        String result = "";
        result += gauche.evaluer(null) + " " + op + " " +  droite.evaluer(null);

        return result;
    }
}

