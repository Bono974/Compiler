public class IfThenElse extends Instruction {
    private Expression condition;

    private Instruction blocIf;
    private Instruction blocThen;

    public IfThenElse(Instruction blocIf, Instruction blocThen, Expression condition) {
        this.blocIf = blocIf;
        this.blocThen = blocThen;
        this.condition = condition;
    }

    public IfThenElse(Instruction blocIf, Expression condition) {
        this.blocIf = blocIf;
        this.blocThen = null;
        this.condition = condition;
    }

    public boolean verifier(){
        // Verification de gauche.type == droite.type
        return true;
    }

    public String evaluer(int registreCourant){
        //TEST
        String condition =  this.condition.evaluer(null);
        String result = "REGISTRE = \n"; // + Recuperer ici le dernier registre utilisé

        //THEN
        result += "if not"+ "REGISTRE " + "then goto " + "LABEL ELSE: \n";
        result += blocIf.evaluer(0) + "\ngoto" + "LABEL ENDIF:\n";

        if (this.blocThen != null)
            //ELSE
            result += blocThen.evaluer(0) + "\n " + "LABEL ENDIF:";




        return result;
    }
}

