package tac;

public class Label {

    private int label;
    private static int labelSuivant = 0;

    public Label(){
        this.label = this.labelSuivant++;
    }

    public String toString() {
        return "L" + this.label;
    }
}
