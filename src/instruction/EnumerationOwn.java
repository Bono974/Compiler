package instruction;

import java.util.*;

import expression.*;
import identifiant.*;
import tac.Label;
//import tac.EnumOp;

public class EnumerationOwn extends Instruction {

    private Expression variable;
    private List<Expression> valeurs;

    public EnumerationOwn (Expression variable, List<Expression> valeurs) {
        this.variable = variable;
        this.valeurs = valeurs;
    }

    public void genererCode(Label suivant) {
        //Pas de code à générer.
        //EnumOp droiteType = droite.getType();

        for (Expression ptr: this.valeurs) {
            //ADD dans table des variables
            //tableVariable.add(EnumTypr.ENUM, this.variable, ptr);
        }

    }
}

