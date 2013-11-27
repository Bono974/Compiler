public abstract class OperationArithmetique extends Expression {

    public void genererJumpCode(Label oui, Label non) {
           Identifiant res = genererCode();
           String result = "if " + res + " != 0 goto " + oui + "\n" + "goto " + non;
           System.out.println(result);
    }

    public abstract Identifiant genererCode();
}
