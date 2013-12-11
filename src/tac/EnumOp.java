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
    AFFECT("NOT DEFINED => EnumOp");

    private String name = "";

	EnumOp(String name){
		this.name = name;
	}

	public String toString(){
		return name;
	}
}

