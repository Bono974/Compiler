package instruction;

import java.util.*;

import expression.Expression;
import identifiant.*;
import tac.*;

public class Affectation extends Instruction {

    private Expression variable;
    private Expression droite;
    private EnumType type;
    private InfosErreur info;

    public Affectation(EnumType type, Expression variable, Expression droite, InfosErreur info){
        this.variable = variable;
        this.droite = droite;
        this.type = type;
        this.info = info;
    }

    public void genererCode(Label suivant) {
        EnumType droiteType = droite.getType();
        String expName;
        expName = variable.getNomVariable();

        if(variable.getType() == EnumType.INTERVALLE) {
            GenererErreur.genErreurIntervalle(expName, info);
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

        GenererErreur.genErreurAffectation(type, droiteType, expName, droite.getNomVariable(), info);
    }
}
