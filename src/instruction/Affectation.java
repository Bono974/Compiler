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

        if(variable.getType() == EnumType.INTERVALLE) {
            expName = variable.getNomVariable();
            GenererErreur.genErreurIntervalle(expName);
        }
        else {
            expName = variable.genererCode().toString();

            Identifiant resDroite = droite.genererCode();
            Identifiant resVariable = variable.genererCode();
            System.out.println(resVariable + " = " + resDroite);
        }

        if(!GenererErreur.genErreurAffectation(hm, type, droiteType, expName, droite.getNomVariable()))
            hm.put(expName, type);

        /*if(!GenererErreur.genErreur(hm, type, expName))
                hm.put(expName, type);*/

        System.out.println("\n/*===============");
        System.out.println("Type de gauche : " + type + " Variable : " + expName +  " -- Type de droite : " + droiteType);
        System.out.println("AFFECTATION -- Type Variable : " + variable.getType());
        System.out.println("===============*/");
    }
}
