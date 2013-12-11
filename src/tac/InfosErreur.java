package tac;

public class InfosErreur {

    private int ligne;
    private int colonne;

    public InfosErreur(int ligne, int colonne){
    	this.ligne = ligne;
    	this.colonne = colonne;
    }

    public void AfficherPositionErreur() {
        System.out.println("Erreur à la ligne : " + (ligne + 1));
    }
}
