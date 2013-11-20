public class Value<T> extends Expression {
    private T value;

    public Value(T value){
        this.value = value;
    }

    public boolean verifier() {
        return true;
    }

    public String evaluer() {
        return this.value + "";
    }
}

