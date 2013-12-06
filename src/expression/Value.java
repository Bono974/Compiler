package expression;

import identifiant.*;

public class Value<T> extends OperationArithmetique {

    private T value;

    public Value(T value){
        this.value = value;
    }

    public Identifiant genererCode() {
        return new IdentifiantValeur(this.value);
    }
}

