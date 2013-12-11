package tac;

import java.util.Map;
import java.util.HashMap;

import expression.Variable;
import tac.EnumType;

public class TableVariable {

    private Map table;
    private Map procedures;

    public TableVariable() {
        this.table = new HashMap <String, EnumType>();
        this.procedures = new HashMap <String, String>();

        //this.procedure = new HashMap <String, List<EnumType>>();
        //Vérification de type des expressions mises en paramètre (Idée)
    }

    public void ajouterVariable(String v, EnumType t) {
        this.table.put(v, t);
    }

    public void ajouterProcedure(String procedure /*,List<EnumType> listType*/) {
        this.procedures.put(procedure, "Procédure "+ procedure +" ajoutée");
    }

    public EnumType recupererTypeVariable(String v) {
        return (EnumType) this.table.get(v);
    }

    public boolean verifierDeclarationVariable(String v) {
        return this.table.containsKey(v);
    }

    public boolean verifierTypeVariable(String v, EnumType t) {
        return this.table.get(v).equals(t);
    }

    public boolean verifierDeclarationProcedure(String procedure) {
        return this.procedures.containsKey(procedure);
    }

    /*
     * Idée pour vérifier les types mis en paramètres d'un appel de procédure */
    /*
    public boolean verifierTypeProcedure(String procedure, List<EnumType> listTypeParametres) {
        if (! verifierDeclarationProcedure(procedure))
            return false;

        int tailleSelf = this.procedures.get(procedure).size();
        int tailleEntree = listTypeParametres.size();

        if (tailleSelf != tailleEntree)
            return false;

        for (int i = 0; i < tailleSelf; i++)
            if (this.procedures.get(procedure).get(i) != listTypeParametres.get(i))
                return false;

        return true;
    }
    */
}
