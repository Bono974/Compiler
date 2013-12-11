package tac;
import java.util.*;

public class GenererErreur {

    public static boolean inProcedure = false;
    public static String currentProcedure = null;

    public static boolean genErreurDeclaration(HashMap hm, EnumType type, String nomVariable, InfosErreur info) {

        // Si on se trouve dans une procédure, on ne test pas les types des variables
        if(GenererErreur.inProcedure)
            return false;

        if(!hm.containsKey(nomVariable)) { // Si la variable n'a pas encore été déclarée

            if(type == null) {
                System.out.println("\n/*===============");
                info.AfficherPositionErreur();
                System.out.println("La variable/procédure : \"" + nomVariable + "\" n'a pas été déclarée précédemment.");
                System.out.println("===============*/");
            }

        } else { // Si la variable est deja dans la table des variables
            if(type != null) {
                System.out.println("\n/*===============");
                info.AfficherPositionErreur();
                System.out.println("La variable/procédure : \"" + nomVariable + "\" a déjà été déclarée !!");
                System.out.println("===============*/");
            }
        }

        // Il n'y a pas eu d'erreurs, on peut ajouter la variable et son type à la Table
        hm.put(nomVariable, type);
        return false;
    }

    public static boolean genErreurProcedure(HashMap hm, String nomVariable, InfosErreur info) {

        // Si on se trouve dans une procédure, on ne test pas les types des variables
        if(GenererErreur.inProcedure)
            return false;

        if(!hm.containsKey(nomVariable)) { // Si la variable n'a pas encore été déclarée

            System.out.println("\n/*===============");
            info.AfficherPositionErreur();
            System.out.println("La variable/procédure : \"" + nomVariable + "\" n'a pas été déclarée précédemment.");
            System.out.println("===============*/");

        } else { // Si la variable est deja dans la table des variables
            
            if((EnumType)hm.get(nomVariable) != EnumType.PROCEDURE) {
                System.out.println("\n/*===============");
                info.AfficherPositionErreur();
                System.out.println("La variable/procédure : \"" + nomVariable + "\" n'a pas été déclarée en tant que procédure.");
                System.out.println("===============*/");
            }
        }

        return false;
    }

    public static boolean genErreurAffectation(HashMap hm, EnumType typeGauche, EnumType typeDroite, String nomVariableGauche, String nomVariableDroite, InfosErreur info) {

        boolean erreur = false;

        // Si on se trouve dans une procédure, on ne test pas les types des variables
        if(GenererErreur.inProcedure)
            return false;

        if(typeGauche == null) {
            if(hm.containsKey(nomVariableGauche)) {
                typeGauche = (EnumType)hm.get(nomVariableGauche);
            } else {
                System.out.println("\n/*===============");
                info.AfficherPositionErreur();
                System.out.println("La variable : \"" + nomVariableGauche + "\" n'a pas été déclarée précédemment.");
                System.out.println("===============*/");

                erreur = true;
            }
        }

        if(typeDroite == EnumType.VARIABLE) {
            if(hm.containsKey(nomVariableDroite)) {
                typeDroite = (EnumType)hm.get(nomVariableDroite);
            } else {
                System.out.println("\n/*===============");
                info.AfficherPositionErreur();
                System.out.println("La variable : \"" + nomVariableDroite + "\" n'a pas été déclarée précédemment.");
                System.out.println("===============*/");

                erreur = true;
            }
        }

        if(erreur)
            return true;

        if(comparerType(typeGauche, typeDroite)){
            System.out.println("\n/*===============");
            info.AfficherPositionErreur();
            System.out.println("Affectation impossible avec la variable : \"" + nomVariableGauche + "\"");
            System.out.println("L'élément à gauche est de type : " + typeGauche);
            System.out.println("Alors que celui de droite est de type : " + typeDroite);
            System.out.println("===============*/");  
        }

        // Il n'y a pas eu d'erreurs, on peut ajouter la variable et son type à la Table
        hm.put(nomVariableGauche, typeGauche);

        return false;
    }

    public static void genErreurIntervalle(String nomVariable, InfosErreur info) {
        System.out.println("\n/*===============");
        info.AfficherPositionErreur();
        System.out.println("La variable : \"" + nomVariable + "\" est un tableau avec intervalle.");
        System.out.println("Il n'est pas possible d'affecter une valeur à un intervalle.");
        System.out.println("===============*/");
    }

    public static void genErreurProcRecursive(String nomProc, String nomProcCalled, InfosErreur info) {
        if(!nomProc.equals(nomProcCalled)) {
            System.out.println("\n/*===============");
            info.AfficherPositionErreur();
            System.out.println("Il est interdit d'appeler une procédure dans le corps d'une procédure");
            System.out.println("en dehors d'elle même.");
            System.out.println("La procédure : " + nomProcCalled + " a été appelée dans : " + nomProc);
            System.out.println("===============*/");
        }
    }

    public static void genErreurOperation(EnumType typeGauche, EnumType typeDroite, InfosErreur info) {
        if((typeGauche == EnumType.OP_BOOL) && (typeDroite != EnumType.OP_BOOL)
            || (typeGauche != EnumType.OP_BOOL) && (typeDroite == EnumType.OP_BOOL)) {
            System.out.println("\n/*===============");
            info.AfficherPositionErreur();
            System.out.println("Il n'est pas autorisé de faire une opération arithmétique");
            System.out.println("entre des nombres et des booléens.");
            System.out.println("===============*/");
        }
    }

    public static boolean comparerType(EnumType typeGauche, EnumType typeDroite) {

        boolean erreur = false;

        switch(typeGauche) {
            case SHORT:
                if(typeDroite == EnumType.INTEGER) erreur = true;
                if(typeDroite == EnumType.UNSIGNED_INTEGER) erreur = true;
                if(typeDroite == EnumType.REAL) erreur = true;
                if(typeDroite == EnumType.UNSIGNED_REAL) erreur = true;
                if(typeDroite == EnumType.OP_BOOL) erreur = true;
                if(typeDroite == EnumType.BOOLEAN) erreur = true;
                if(typeDroite == EnumType.ENUM) erreur = true;
                if(typeDroite == EnumType.CHARACTER) erreur = true;
                if(typeDroite == EnumType.CHARACTERS) erreur = true;
                if(typeDroite == EnumType.POINTER_INT) erreur = true;
                if(typeDroite == EnumType.POINTER_REAL) erreur = true;
                if(typeDroite == EnumType.POINTER_CHARACTER) erreur = true;
                if(typeDroite == EnumType.POINTER_CHARACTERS) erreur = true;
                break;
            case UNSIGNED_SHORT:
                if(typeDroite == EnumType.INTEGER) erreur = true;
                if(typeDroite == EnumType.UNSIGNED_INTEGER) erreur = true;
                if(typeDroite == EnumType.REAL) erreur = true;
                if(typeDroite == EnumType.UNSIGNED_REAL) erreur = true;
                if(typeDroite == EnumType.OP_BOOL) erreur = true;
                if(typeDroite == EnumType.BOOLEAN) erreur = true;
                if(typeDroite == EnumType.ENUM) erreur = true;
                if(typeDroite == EnumType.CHARACTER) erreur = true;
                if(typeDroite == EnumType.CHARACTERS) erreur = true;
                if(typeDroite == EnumType.POINTER_INT) erreur = true;
                if(typeDroite == EnumType.POINTER_REAL) erreur = true;
                if(typeDroite == EnumType.POINTER_CHARACTER) erreur = true;
                if(typeDroite == EnumType.POINTER_CHARACTERS) erreur = true;
                break;
            case INTEGER:
                if(typeDroite == EnumType.OP_BOOL) erreur = true;
                if(typeDroite == EnumType.BOOLEAN) erreur = true;
                if(typeDroite == EnumType.ENUM) erreur = true;
                if(typeDroite == EnumType.CHARACTER) erreur = true;
                if(typeDroite == EnumType.CHARACTERS) erreur = true;
                if(typeDroite == EnumType.POINTER_INT) erreur = true;
                if(typeDroite == EnumType.POINTER_REAL) erreur = true;
                if(typeDroite == EnumType.POINTER_CHARACTER) erreur = true;
                if(typeDroite == EnumType.POINTER_CHARACTERS) erreur = true;
                break;
            case UNSIGNED_INTEGER:
                if(typeDroite == EnumType.OP_BOOL) erreur = true;
                if(typeDroite == EnumType.BOOLEAN) erreur = true;
                if(typeDroite == EnumType.ENUM) erreur = true;
                if(typeDroite == EnumType.CHARACTER) erreur = true;
                if(typeDroite == EnumType.CHARACTERS) erreur = true;
                if(typeDroite == EnumType.POINTER_INT) erreur = true;
                if(typeDroite == EnumType.POINTER_REAL) erreur = true;
                if(typeDroite == EnumType.POINTER_CHARACTER) erreur = true;
                if(typeDroite == EnumType.POINTER_CHARACTERS) erreur = true;
                break;
            case REAL:
                if(typeDroite == EnumType.OP_BOOL) erreur = true;
                if(typeDroite == EnumType.BOOLEAN) erreur = true;
                if(typeDroite == EnumType.ENUM) erreur = true;
                if(typeDroite == EnumType.CHARACTER) erreur = true;
                if(typeDroite == EnumType.CHARACTERS) erreur = true;
                if(typeDroite == EnumType.POINTER_INT) erreur = true;
                if(typeDroite == EnumType.POINTER_REAL) erreur = true;
                if(typeDroite == EnumType.POINTER_CHARACTER) erreur = true;
                if(typeDroite == EnumType.POINTER_CHARACTERS) erreur = true;
                break;
            case UNSIGNED_REAL:
                if(typeDroite == EnumType.OP_BOOL) erreur = true;
                if(typeDroite == EnumType.BOOLEAN) erreur = true;
                if(typeDroite == EnumType.ENUM) erreur = true;
                if(typeDroite == EnumType.CHARACTER) erreur = true;
                if(typeDroite == EnumType.CHARACTERS) erreur = true;
                if(typeDroite == EnumType.POINTER_INT) erreur = true;
                if(typeDroite == EnumType.POINTER_REAL) erreur = true;
                if(typeDroite == EnumType.POINTER_CHARACTER) erreur = true;
                if(typeDroite == EnumType.POINTER_CHARACTERS) erreur = true;
                break;
            case BOOLEAN:
                if(typeDroite == EnumType.REAL) erreur = true;
                if(typeDroite == EnumType.UNSIGNED_REAL) erreur = true;
                if(typeDroite == EnumType.ENUM) erreur = true;
                if(typeDroite == EnumType.CHARACTER) erreur = true;
                if(typeDroite == EnumType.CHARACTERS) erreur = true;
                if(typeDroite == EnumType.POINTER_INT) erreur = true;
                if(typeDroite == EnumType.POINTER_REAL) erreur = true;
                if(typeDroite == EnumType.POINTER_CHARACTER) erreur = true;
                if(typeDroite == EnumType.POINTER_CHARACTERS) erreur = true;
                break;
            case ENUM:
                if(typeDroite != EnumType.ENUM) erreur = true;
                break;
            case CHARACTER:
                if(typeDroite != EnumType.CHARACTER) erreur = true;
                break;
            case CHARACTERS:
                if(typeDroite != EnumType.CHARACTERS) erreur = true;
                break;
            case POINTER_INT:
                if(typeDroite == EnumType.OP_BOOL) erreur = true;
                if(typeDroite == EnumType.BOOLEAN) erreur = true;
                if(typeDroite == EnumType.ENUM) erreur = true;
                if(typeDroite == EnumType.CHARACTER) erreur = true;
                if(typeDroite == EnumType.CHARACTERS) erreur = true;
                if(typeDroite == EnumType.POINTER_REAL) erreur = true;
                break;
            case POINTER_REAL:
                if(typeDroite == EnumType.OP_BOOL) erreur = true;
                if(typeDroite == EnumType.BOOLEAN) erreur = true;
                if(typeDroite == EnumType.ENUM) erreur = true;
                if(typeDroite == EnumType.CHARACTER) erreur = true;
                if(typeDroite == EnumType.CHARACTERS) erreur = true;
                if(typeDroite == EnumType.POINTER_INT) erreur = true;
                break;
            case POINTER_CHARACTER:
                if(typeDroite == EnumType.OP_BOOL) erreur = true;
                if(typeDroite == EnumType.BOOLEAN) erreur = true;
                if(typeDroite == EnumType.ENUM) erreur = true;
                if(typeDroite == EnumType.POINTER_INT) erreur = true;
                if(typeDroite == EnumType.POINTER_REAL) erreur = true;
                break;
            case POINTER_CHARACTERS:
                if(typeDroite == EnumType.OP_BOOL) erreur = true;
                if(typeDroite == EnumType.BOOLEAN) erreur = true;
                if(typeDroite == EnumType.ENUM) erreur = true;
                if(typeDroite == EnumType.POINTER_INT) erreur = true;
                if(typeDroite == EnumType.POINTER_REAL) erreur = true;
                break;
            default:
                System.out.println("Le type : " + typeGauche + " n'est pas un type valide.");
                erreur = true;
        }

        return erreur;
    }
}
