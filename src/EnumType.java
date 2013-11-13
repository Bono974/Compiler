public enum EnumType {
    INT    ,
    REAL   ,
    UNKNOW ;
    private final String tag;

    EnumType(String s) {
	    tag = s;
    }

    public String toString() {
	    return tag;
    }
}
