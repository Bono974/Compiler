package expression;

import identifiant.Identifiant;
import identifiant.IdentifiantValeur;

public class ValueBool extends OperationBooleenne {

    private boolean value;

    public ValueBool(boolean value){
        this.value = value;
    }

    public Identifiant genererCode() {
        return new IdentifiantValeur(this.value);
    }
}

