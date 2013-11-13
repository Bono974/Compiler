import java.util.*;

/*
   Pour pouvoir combiner les tableaux avec des structures et des pointeurs,
   il faudrait remplacer le tabLengths par un Type fils, de manière à créer
   un arbre de Type
 */

public class Type {
    EnumType type;
    List<Integer> tabLengths;
    String name;

    public Type(String name, List<Integer> tabLengths) {
	    this.type = EnumType.UNKNOWN;
	    this.name = name;
	    this.tabLengths = tabLengths.clone();
    }

    public void setType(EnumType t) {
	    this.type = t;
    }

    public void addLength(int len) {
	    this.tabLengths.add(len);
    }

    public String getName() {
        return this.name;
    }

    public EnumType getType() {
        return this.type;
    }

    public boolean equals(Object o) {
        if (o instanceof Type)
            return o.getName().equals(this.getName());
        return false;
    }

    public boolean validPos(int deepness, int pos) {
        if (deepness == 0 && this.tabLengths.empty())
            return true;
        return (0 < deepness <= this.tabLengths.size())
            && (0 <= pos < this.tabLengths.get(deepness-1));
    }

    private int getLength(int deepness) {
        return this.tabLengths.get(deepness);
    }
}
