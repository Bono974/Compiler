package tac;

public class Label {

    private static int suivant = 0;
    private int self;

    public Label() {
        this.self = this.suivant++;
    }

    public String toString() {
        return "L" + this.self;
    }
}
