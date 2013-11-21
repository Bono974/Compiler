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
        //if (unaire)
        //    return op + gauche.evaluer(EnumOp.UNKNOWN);
        
        //return gauche.evaluer(EnumOp.UNKNOWN) + op + droite.evaluer(op);

    	//if (prevOp == EnumOp.UNKNOWN)
    	//	return ""; 

    	return gauche.evaluer(EnumOp.UNKNOWN) + "\nt" + 
    		registreCourant + " = " + "t" + (registreCourant - 1) + " " + 
    		op + " " + droite.evaluer(op);
    }
}
