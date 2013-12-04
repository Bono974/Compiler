import java.util.LinkedList;

public class ProcedureDefinition extends Instruction {

    private String nom;
    private LinkedList<Expression> listeExpression;
    private Instruction blocInstruction;
    private Expression valeurRetour;

    public ProcedureDefinition(String nom, LinkedList<Expression> list, Instruction bloc, Expression valeurRetour) {
        this.nom = nom;
        this.listeExpression = list;
        this.blocInstruction = bloc;
        this.valeurRetour = valeurRetour;
    }

    public void genererCode(Label suivant) {
        System.out.println(this.nom + ":");

        blocInstruction.genererCode(suivant);

        if (this.valeurRetour != null) {
            Identifiant res = this.valeurRetour.genererCode();
            System.out.println("return " + res);
        }
    }
}

