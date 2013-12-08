package instruction;

import java.util.*;
import expression.Expression;
import identifiant.Identifiant;
import tac.*;

public class ProcedureAppel extends Instruction {

    private String nom;
    private LinkedList<Expression> listeExpression;

    public ProcedureAppel(String nom, LinkedList<Expression> list) {
        this.nom = nom;
        this.listeExpression = list;
    }

    public void genererCode(Label suivant, Stack pileTableVariable) {
        
        HashMap hm = (HashMap)pileTableVariable.peek();
        GenererErreur.genErreurProcedure(hm, this.nom);

        ModifierStack.pushTV(pileTableVariable);
        
        if(GenererErreur.inProcedure) {
            GenererErreur.genErreurProcRecursive(GenererErreur.currentProcedure, this.nom);
        }

        for (Expression e: this.listeExpression) {
            Identifiant resTmp = e.genererCode();
            System.out.println("param "+ resTmp);
        }
        System.out.println("call "+ this.nom);
        ModifierStack.popTV(pileTableVariable);
    }
}

