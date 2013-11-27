public class Affectation extends Instruction {

    private String nom;
    private Expression droite;

    //On verra plus tard les tableaux
    public Affectation(String nom, Expression droite){
        this.nom = nom;
        this.droite = droite;
    }

    public void genererCode(Label suivant) {
        Identifiant res = droite.genererCode();
        System.out.println(this.nom + " = " + res);
    }
}
