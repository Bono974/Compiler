public class For extends IfThenElse {
    public For(Expression gauche, Expression droite){
        super(gauche, droite);
    }

    public boolean verifier(){
        // Verification de gauche.type == droite.type
        return true;
    }

    public String evaluer(int registreCourant){
        String result = "Label x :";
        //result += super.evaluer() + "\n GOTO Label x";
        //Rajouter cas de sortie de boucle.
        return "TOTO";
    }
}

