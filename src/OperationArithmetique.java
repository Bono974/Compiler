public class OperationArithmetique extends Operation {
	protected int registreCourant;

    public OperationArithmetique(Expression gauche, Expression droite, EnumOp op, int registreCourant) {
        super(gauche, droite, op);
        this.registreCourant = registreCourant;
    }

    public OperationArithmetique(Expression unaire, EnumOp op, int registreCourant) {
        super(unaire, op);
        this.registreCourant = registreCourant;
    }

    public String evaluer(EnumOp prevOp) {
        String result = "";

        /*if(gauche instanceof Expression)
            System.out.println("HERMANOS");*/

        /*if (prevOp == null) {
            //System.out.println("POLLOS");
        }

        else if (prevOp == EnumOp.UNKNOWN) {
            result += gauche.evaluer(null) + " " + op + " YALA " +  droite.evaluer(op);
        } else {

            if ((op == EnumOp.TIMES)||(op == EnumOp.DIVIDE)||(op == EnumOp.MOD)) {
                result += gauche.evaluer(null) + " " +  op + " " + droite.evaluer(op) +
                    "\nt" + (registreCourant+1) + " = t" + (registreCourant);

            } else {
                result += gauche.evaluer(null) + " " +  op + " " + droite.evaluer(op) +
                    "\nt" + (registreCourant+1) + " = t" + (registreCourant);
            } 
        }*/
        

        // if (prevOp == EnumOp.UNKNOWN)
        //     result += gauche.evaluer(null) + " " + op + " " +  droite.evaluer(op);
        // else
        //     result += gauche.evaluer(null) + " " +  op + " " + droite.evaluer(op) +
        //         "\nt" + (registreCourant+1) + " = t" + (registreCourant);

        //return result;


        return "NotValue"; // Les valeurs de la classe OperationArithmetique ne sont pas recuperees
    }


    // =============================================================
    // Fonction de generation du code 3 adresse a la volee qui 
    // retourne la valeur du dernier registre lors d'une operation 
    // a faible precedence (ou -1 si ce n'est pas le cas)
    // =============================================================

    public static int genCode(Expression gauche, Expression droite, EnumOp op, int registreCourant, boolean countOP, int registreAvantTimes) {
        //System.out.println("Gauche : " + gauche.evaluer(op) + " -- Droite : " + droite.evaluer(op) + " OP : " + op + " Registre : " + registreCourant + " Registre stocké : " + registreAvantTimes);
    
        /*if ((op == EnumOp.TIMES)||(op == EnumOp.DIVIDE)||(op == EnumOp.MOD)) { // Operations avec une Forte Precedence (TIMES, DIVIDE, MOD)
            if (countOP) // A la suite d'une OP avec Forte Prec.
                if(droite.evaluer(op) == "Erreur")
                    System.out.println("t" + registreCourant + " = t" + (registreCourant - 1) + " " + op + " " + gauche.evaluer(op));
                else
                    System.out.println("t" + registreCourant + " = t" + (registreCourant - 1) + " " + op + " " + droite.evaluer(op)); 
            else if (!countOP)
                System.out.println("t" + registreCourant + " = " + gauche.evaluer(op) + " " + op + " " + droite.evaluer(op));

            return -1; // Ce n'est pas une Op avec une faible Prec donc on renvoie -1

        } else if((op == EnumOp.PLUS)||(op == EnumOp.MINUS)||(op == EnumOp.MINUS_U)) { // Op avec une Faible Precedence (PLUS, MINUS, MINUS_U)

            if(registreCourant == 0)
                System.out.println("t" + registreCourant + " = " + gauche.evaluer(op) + " " + op + " " + droite.evaluer(op));
            else if(countOP && registreAvantTimes == -1) // Pas de registre a recuperer avant une Operation a Forte Prec.
                System.out.println("t" + registreCourant + " = t" + (registreCourant - 1) + " " + op + " " + gauche.evaluer(op));
            else if(countOP && registreAvantTimes != -1) // On recupere le registre "sauvegarde" avant la suite d'Operations a Forte Prec. precedente
                System.out.println("t" + registreCourant + " = t" + (registreCourant - 1) + " " + op + " t" + registreAvantTimes);   
            else if(!countOP) // Operation n'étant pas a la suite d'une Operation a Forte Prec.
                System.out.println("t" + registreCourant + " = t" + (registreCourant - 1) + " " + op + " " + droite.evaluer(op));

            // Ce numero de registre nous permet par la suite de 
            // ne pas perdre des opérations faites avant une Op a Forte Prec.
            return registreCourant; 
        }*/

        if(gauche.evaluer(op) == "NotValue" && droite.evaluer(op) != "NotValue") {
            System.out.println("t" + registreCourant + " = t" + (registreCourant - 1) + " " + op + " " + droite.evaluer(op));
        } else if(gauche.evaluer(op) != "NotValue" && droite.evaluer(op) == "NotValue") {
            System.out.println("t" + registreCourant + " = " + gauche.evaluer(op) + " " + op + " t" + (registreCourant - 1));
        } else if(gauche.evaluer(op) != "NotValue" && droite.evaluer(op) != "NotValue") {
            System.out.println("t" + registreCourant + " = " + gauche.evaluer(op) + " " + op + " " + droite.evaluer(op));

            // Si on a une Value des deux côtés et que ce n'est pas la premiere Opération, alors on stock le registre
            if(registreCourant > 0) 
                return (registreCourant - 1);
            
        } else if(gauche.evaluer(op) == "NotValue" && droite.evaluer(op) == "NotValue") {
            System.out.println("t" + registreCourant + " = t" + registreAvantTimes + " " + op + " t" + (registreCourant - 1));
        }

        return -1;
    }
}
