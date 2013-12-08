package instruction;

import java.util.*;
import expression.Expression;
import tac.*;
import identifiant.Identifiant;

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

    public void genererCode(Label suivant, Stack pileTableVariable) {
        System.out.println(this.nom + ":");
        System.out.println("func "+ this.nom);
        ModifierStack.pushTV(pileTableVariable);
        GenererErreur.inProcedure = true;

        blocInstruction.genererCode(suivant, pileTableVariable);

        if (this.valeurRetour != null) {
            Identifiant res = this.valeurRetour.genererCode();
            System.out.println("return " + res);
        }

        GenererErreur.inProcedure = false;
        ModifierStack.popTV(pileTableVariable);
    }
}
