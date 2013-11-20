public class Variable extends Expression {
    private String nomVariable;

    public Variable(String nomVariable) {
        this.nomVariable = nomVariable;

    }

    public boolean verifier() {
        //Verification de la déclaration de variable dans la table des variables
        //Si elle existe, et si elle n'a pas été redéfinie
        //HashMap<Variable, Type>
        return true;
    }

    public String evaluer(){
        return this.nomVariable;
    }
}

