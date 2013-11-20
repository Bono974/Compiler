public class Affectation extends Instruction {
    private Expression gauche;
    private Expression droite;

    public Affectation(Expression gauche, Expression droite){
        this.gauche = gauche;
        this.droite = droite;
        verifier();
    }

    public boolean verifier(){
        // Verification de gauche.type == droite.type
        return true;
    }

    public String evaluer(){
        return gauche.evaluer() + "=" + droite.evaluer();
    }
}

