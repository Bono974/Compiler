package instruction;

import java.util.*;
import expression.Expression;
import identifiant.Identifiant;
import tac.*;

public class ProcedureAppel extends Instruction {

    private String nom;
    private LinkedList<Expression> listeExpression;
    private InfosErreur info;

    public ProcedureAppel(String nom, LinkedList<Expression> list, InfosErreur info) {
        this.nom = nom;
        this.listeExpression = list;
        this.info = info;
    }

    public void genererCode(Label suivant) {
        
        //HashMap hm = (HashMap)pileTableVariable.peek();
        GenererErreur.genErreurProcedure(this.nom, info);

        //ModifierStack.pushTV(pileTableVariable);
        PileTableVariable.ajouterEnvironnement();
        
        if(GenererErreur.inProcedure) {
            GenererErreur.genErreurProcRecursive(GenererErreur.currentProcedure, this.nom, info);
        }

        for (Expression e: this.listeExpression) {
            Identifiant resTmp = e.genererCode();
            System.out.println("param "+ resTmp);
        }
        System.out.println("call "+ this.nom);
        //ModifierStack.popTV(pileTableVariable);
        PileTableVariable.retirerEnvironnement();
    }
}

