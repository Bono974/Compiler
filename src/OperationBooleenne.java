public class OperationBooleenne extends Operation {
    public OperationBooleenne(Expression gauche, Expression droite, EnumOp op) {
        super(gauche, droite, op);
    }

    public OperationBooleenne(Expression unaire, EnumOp op) {
        super(unaire, op);
    }

}

