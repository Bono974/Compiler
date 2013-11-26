public enum EnumOp {
    //Opérations numérique
    PLUS("+"), TIMES("*"), DIVIDE("/"), MINUS("-"), MINUS_U("-"), EQUALS("NOT DEFINED => EnumOp"),
    //Opérations booléennes
    AND("NOT DEFINED => EnumOp"), OR("NOT DEFINED => EnumOp"), LT("NOT DEFINED => EnumOp"), 
    GT("NOT DEFINED => EnumOp"), LE("NOT DEFINED => EnumOp"), GE("NOT DEFINED => EnumOp"), 
    EQ("NOT DEFINED => EnumOp"), DIFF("NOT DEFINED => EnumOp"), MOD("%"), NOT("NOT DEFINED => EnumOp"), 
    TRUE("true"), FALSE("false"),
    //Opérateur inconnu
    UNKNOWN("NOT DEFINED => EnumOp"),
    //Opérateur d'affectation
    AFFECT("NOT DEFINED => EnumOp");

    private String name = "";
   
	//Constructeur
	EnumOp(String name){
		this.name = name;
	}

	public String toString(){
		return name;
	}
}

