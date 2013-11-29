public class Affectation extends Instruction {

    private Expression variable;
    private Expression droite;

    //On verra plus tard les tableaux
    public Affectation(Expression variable, Expression droite){
        this.variable = variable;
        this.droite = droite;
    }

    public void genererCode(Label suivant) {
        Identifiant resDroite = droite.genererCode();
        Identifiant resVariable = variable.genererCode();
        System.out.println(resVariable + " = " + resDroite);
    }
}
