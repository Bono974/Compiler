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

    public static int genCode(Expression gauche, Expression droite, EnumOp op, int registreCourant, int registreAvantTimes) {
        //System.out.println("Gauche : " + gauche.evaluer(op) + " -- Droite : " + droite.evaluer(op) + " OP : " + op + " Registre : " + registreCourant + " Registre stocké : " + registreAvantTimes);

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

    public static int genCodeUnaire(Expression unaire, EnumOp op, int registreCourant, int registreAvantTimes) {
        
        if(unaire.evaluer(op) != "NotValue")
            System.out.println("t" + registreCourant + " = - " + unaire.evaluer(op));
        else
            System.out.println("t" + registreCourant + " = - t" + registreCourant);

        // Si on a une Value des deux côtés et que ce n'est pas la premiere Opération, alors on stock le registre
        if(registreCourant > 0) 
            return (registreCourant - 1);

        return -1;
    }
}
