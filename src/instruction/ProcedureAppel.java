package instruction;

import java.util.List;

import expression.Expression;
import identifiant.Identifiant;
import identifiant.IdentifiantRegistre;
import tac.GenererErreur;
import tac.InfosErreur;
import tac.Label;
import tac.PileTableVariable;

public class ProcedureAppel extends InstructionAbs {

    private String nom;
    private List<Expression> listeExpression;
    private InfosErreur info;

    public ProcedureAppel(String nom, List<Expression> list, InfosErreur info) {
        this.nom = nom;
        this.listeExpression = list;
        this.info = info;
    }

    public void genererCode(Label suivant) {
        GenererErreur.genErreurProcedure(this.nom, info);
        PileTableVariable.ajouterEnvironnement();

        if(GenererErreur.inProcedure)
            GenererErreur.genErreurProcRecursive(GenererErreur.currentProcedure,
                                                 this.nom, info);

        for (Expression e: this.listeExpression) {
            Identifiant resTmp = e.genererCode();
            System.out.println("param "+ resTmp);
        }

        Identifiant res = new IdentifiantRegistre();

        System.out.println(res + " = call "+ this.nom + ", " + listeExpression.size());
        PileTableVariable.retirerEnvironnement();
    }
}

