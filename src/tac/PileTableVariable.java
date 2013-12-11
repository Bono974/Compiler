package tac;

import java.util.List;
import java.util.ArrayList;

import expression.Variable;
import tac.EnumType;

import static tac.IterationInverse.reversed;

public class PileTableVariable {

    private static List<TableVariable> lTable = new ArrayList<TableVariable>();

    public PileTableVariable() {
        ajouterEnvironnement();
    }

    public static void ajouterEnvironnement() {
        lTable.add(new TableVariable());
    }

    public static void retirerEnvironnement() {
        lTable.remove(lTable.size() - 1);      
    }

    public static void ajouterVariable(String v, EnumType t) {
        lTable.get(lTable.size() - 1).ajouterVariable(v, t);
    }

    public static EnumType recupererTypeVariable(String v){
        for (TableVariable ptr: reversed(lTable))
            if (ptr.verifierDeclarationVariable(v))
                return ptr.recupererTypeVariable(v);
        return null;
    }

    public static void ajouterProcedure(String procedure) {
        lTable.get(lTable.size() - 1).ajouterProcedure(procedure);
    }

    public static void ajouter(String v, EnumType t) {
        if(t == EnumType.PROCEDURE)
            ajouterProcedure(v);
        else
            ajouterVariable(v, t);
    }

    public static boolean verifierDeclarationVariable(String v) {
        for (TableVariable ptr: reversed(lTable))
            if (ptr.verifierDeclarationVariable(v))
                return true;
        return false;
    }

    public static boolean verifierTypeVariable(String v, EnumType t){
        for (TableVariable ptr: reversed(lTable))
            if (ptr.verifierTypeVariable(v, t))
                return true;
        return false;
    }

    public static boolean verifierDeclarationProcedure(String procedure) {
        for (TableVariable ptr: reversed(lTable))
            if (ptr.verifierDeclarationProcedure(procedure))
                return true;
        return false;
    }

    /*
    public static boolean verifierTypeProcedure(String procedure, List<EnumType> listTypeParametres) { }
    */

    public  static void main(String args []) {
        PileTableVariable pv = new PileTableVariable();
        pv.ajouter("Toto", EnumType.INTEGER);

        pv.ajouter("Toto", EnumType.PROCEDURE);


        System.out.println("TEST" + pv.verifierDeclarationProcedure("Toto"));
        System.out.println("TEST" + pv.verifierDeclarationProcedure("Titi"));
        System.out.println("TEST" + pv.verifierDeclarationProcedure("Tutu"));
        System.out.println("TEST" + pv.verifierDeclarationVariable("Toto"));
        System.out.println("TEST" + pv.verifierDeclarationVariable("j"));

    }
}
