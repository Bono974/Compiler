public class OperationArithmetique extends Operation {
    public OperationArithmetique(Expression gauche, Expression droite, EnumOp op) {
        super(gauche, droite, op);
    }

    public OperationArithmetique(Expression unaire, EnumOp op) {
        super(unaire, op);
    }
}
