package tac;

public enum EnumOp {
    //Opérations numérique
    PLUS("+"), TIMES("*"), DIVIDE("/"), MINUS("-"), MINUS_U("-"), EQUALS("=="),
    //Opérations booléennes
    AND("&&"), OR("||"), LT("<"), GT(">"), LE("<="), GE(">="),
    EQ("=="), DIFF("!="), MOD("%"), NOT("!"), TRUE("true"), FALSE("false"),
    //Opérateur inconnu
    UNKNOWN("NOT DEFINED => EnumOp"),
    //Opérateur d'affectation
    AFFECT("NOT DEFINED => EnumOp"),

    OP_ARITHMETIQUE("OP_ARITHMETIQUE"), OP_BOOL("OP_BOOL"),
    CHARACTER("CHARACTER"), CHARACTERS("CHARACTERS"),
    TABLEAU("TABLEAU"), INTERVALLE("INTERVALLE"), VARIABLE("VARIABLE");

    private String name = "";

	EnumOp(String name){
		this.name = name;
	}

	public String toString(){
		return name;
	}
}

