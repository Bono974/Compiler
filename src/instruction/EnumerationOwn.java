package instruction;

import java.util.*;

import expression.*;
import identifiant.*;
import tac.*;

public class EnumerationOwn extends Instruction {

    private Expression variable;
    private List<Expression> valeurs;
    private EnumType type;
    private InfosErreur info;

    public EnumerationOwn (EnumType type, Expression variable, List<Expression> valeurs, InfosErreur info) {
        this.variable = variable;
        this.valeurs = valeurs;
        this.type = type;
        this.info = info;
    }

    public void genererCode(Label suivant) {
        //Pas de code à générer.
        //EnumOp droiteType = droite.getType();

        //HashMap hm = (HashMap)pileTableVariable.peek();

        GenererErreur.genErreurDeclaration(type, variable.getNomVariable(), info);
    }
}

