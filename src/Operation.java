public class Operation extends Expression {
    protected Expression gauche;
    protected Expression droite;
    protected EnumOp op;

    private boolean unaire;

    public Operation(Expression gauche, Expression droite, EnumOp op) {
        this.gauche = gauche;
        this.droite = droite;
        this.op = op;
        this.unaire = false;
    }

    public Operation(Expression unaire, EnumOp op) {
        //Si opération unaire, alors seule l'expression de gauche sera utilisée
        this.gauche = unaire;
        this.op = op;
        this.unaire = true;
    }

    public boolean verifier(){
        // Verification de gauche.type == droite.type et unaire ou pas
        return true;
    }

    public String evaluer(EnumOp prevOp){
        return "TOTO";
    }
}
