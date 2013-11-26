public class While extends IfThenElse {
    public While(Instruction blocIf, Instruction blocThen, Expression condition){
        super(blocIf, blocThen, condition);
    }

    public boolean verifier(){
        // Verification de gauche.type == droite.type
        return true;
    }

    public String evaluer(int registreCourant){
        //String result = "Label x :";
        //result += super.evaluer() + "\n GOTO Label x";
        //Rajouter cas de sortie de boucle.
        return "TOTO";
    }
}
