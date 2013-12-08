package expression;

import identifiant.*;

public class ValueBool<T> extends OperationBooleenne {

    private T value;

    public ValueBool(T value){
        this.value = value;
    }

    public Identifiant genererCode() {
        return new IdentifiantValeur(this.value);
    }
}

