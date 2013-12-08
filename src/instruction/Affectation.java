package instruction;

import java.util.*;

import expression.Expression;
import identifiant.*;
import tac.*;

public class Affectation extends Instruction {

    private Expression variable;
    private Expression droite;
    private EnumType type;

    public Affectation(EnumType type, Expression variable, Expression droite){
        this.variable = variable;
        this.droite = droite;
        this.type = type;
    }

    public void genererCode(Label suivant, Stack pileTableVariable) {
        EnumType droiteType = droite.getType();
        String expName;
        HashMap hm = (HashMap)pileTableVariable.peek();
        expName = variable.getNomVariable();

        if(variable.getType() == EnumType.INTERVALLE) {
            GenererErreur.genErreurIntervalle(expName);
        }
        else {
            Identifiant resDroite = droite.genererCode();
            Identifiant resVariable = variable.genererCode();
            System.out.println(resVariable + " = " + resDroite);
        }

        // System.out.println("\n/*===============");
        // System.out.println("Type de gauche : " + type + " Variable : " + expName +  " -- Type de droite : " + droiteType);
        // System.out.println("AFFECTATION -- Type Variable : " + variable.getType());
        // System.out.println("===============*/");

        GenererErreur.genErreurAffectation(hm, type, droiteType, expName, droite.getNomVariable());
    }
}
