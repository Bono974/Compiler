import java.util.LinkedList;

public class ProcedureDefinition extends Instruction {

    private String nom;
    private LinkedList<Expression> listeExpression;
    private Instruction blocInstruction;

    public ProcedureDefinition(String nom, LinkedList<Expression> list, Instruction bloc) {
        this.nom = nom;
        this.listeExpression = list;
        this.blocInstruction = bloc;
    }

    public void genererCode(Label suivant) {
        for (Expression e: this.listeExpression) {
            Identifiant resTmp = e.genererCode();
            System.out.println("param "+ resTmp);
        }

        blocInstruction.genererCode(suivant);

        Identifiant res = new IdentifiantRegistre();

        System.out.println(res + " = call "+ this.nom /*+
                           "\n"+ suivant*/);
    }
}

