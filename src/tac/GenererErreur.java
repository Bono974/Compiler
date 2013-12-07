package tac;
import java.util.*;

public class GenererErreur {

    public static boolean genErreur(HashMap hm, EnumType type, String nomVariable) {

        if(!hm.containsKey(nomVariable)) { // Si la variable n'a pas encore été déclarée

            if(type == null) {
                System.out.println("\n/*===============");
                System.out.println("Veuillez préciser un \"Type\" car votre variable n'a pas été déclarée.");
                System.out.println("===============*/");
            } else {
                return true;
                //System.out.println("\nLa variable : " + nomVariable + " a été ajouté." + hm);
            }

        } else { // Si la variable est deja dans la table des variables
            if(type != null) {
                System.out.println("\n/*===============");
                System.out.println("La variable : " + nomVariable + " a déjà été déclarée !!");
                System.out.println("===============*/");
            }
        }

        return false;
    }
}
