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
    private InfosErreur info;

    public ProcedureDefinition(String nom, LinkedList<Expression> list, Instruction bloc, Expression valeurRetour, InfosErreur info) {
        this.nom = nom;
        this.listeExpression = list;
        this.blocInstruction = bloc;
        this.valeurRetour = valeurRetour;
        this.info = info;
    }

    public void genererCode(Label suivant) {
        GenererErreur.genErreurDeclaration(EnumType.PROCEDURE, this.nom, info);

        System.out.println(this.nom + ":");
        System.out.println("func "+ this.nom);
        PileTableVariable.ajouterEnvironnement();

        GenererErreur.inProcedure = true;
        GenererErreur.currentProcedure = this.nom;

        blocInstruction.genererCode(suivant);

        if (this.valeurRetour != null) {
            Identifiant res = this.valeurRetour.genererCode();
            System.out.println("return " + res);
        }

        GenererErreur.currentProcedure = null;
        GenererErreur.inProcedure = false;
        PileTableVariable.retirerEnvironnement();
    }
}
