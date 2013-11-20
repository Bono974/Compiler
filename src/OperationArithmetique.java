public class OperationArithmetique extends Expression {
    private Expression gauche;
    private Expression droite;
    private EnumOp op;

    private boolean unaire;

    public OperationArithmetique(Expression gauche, Expression droite, EnumOp op) {
        this.gauche = gauche;
        this.droite = droite;
        this.op = op;
        this.unaire = false;
    }

    public OperationArithmetique(Expression unaire, EnumOp op) {
        //Si opération unaire, alors seule l'expression de gauche sera utilisée
        this.gauche = unaire;
        this.op = op;
        this.unaire = true;
    }

    public boolean verifier(){
        // Verification de gauche.type == droite.type et unaire ou pas
        return true;
    }

    public String evaluer(){
        if (unaire)
            return op + gauche.evaluer();
        return gauche.evaluer() + op + droite.evaluer();
    }

}

