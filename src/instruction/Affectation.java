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
        EnumOp droiteType = droite.getType();
        //System.out.println("Type de gauche : " + type + " Variable : " + variable.genererCode() +  " -- Type de droite : " + droiteType);
        /*HashMap hm = (HashMap)pileTableVariable.peek();

        if(!GenererErreur.genErreur(hm, type, variable.genererCode().toString()))
            hm.put(variable.genererCode().toString(), type);*/

        Identifiant resDroite = droite.genererCode();
        Identifiant resVariable = variable.genererCode();
        System.out.println(resVariable + " = " + resDroite);
    }
}
