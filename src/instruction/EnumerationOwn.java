package instruction;

import java.util.*;

import expression.*;
import identifiant.*;
import tac.*;

public class EnumerationOwn extends Instruction {

    private Expression variable;
    private List<Expression> valeurs;
    private EnumType type;

    public EnumerationOwn (EnumType type, Expression variable, List<Expression> valeurs) {
        this.variable = variable;
        this.valeurs = valeurs;
        this.type = type;
    }

    public void genererCode(Label suivant, Stack pileTableVariable) {
        //Pas de code à générer.
        //EnumOp droiteType = droite.getType();

        HashMap hm = (HashMap)pileTableVariable.peek();

        if(!GenererErreur.genErreurDeclaration(hm, type, variable.getNomVariable()))
            hm.put(variable.genererCode().toString(), type);
    }
}

