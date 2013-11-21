public class Affectation extends Instruction {
    private Expression gauche;
    private Expression droite;

    public Affectation(Expression gauche, Expression droite){
        this.gauche = gauche;
        this.droite = droite;
    }

    public boolean verifier(){
        // Verification de gauche.type == droite.type
        return true;
    }

    public String evaluer(int registreCourant){
        String result = "t0 = " + droite.evaluer(EnumOp.UNKNOWN) + "\n";
        result += gauche.evaluer(EnumOp.AFFECT) + " = t" + registreCourant;

        return result;
    }
}

