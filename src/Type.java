import java.util.*;

/*
   Pour pouvoir combiner les tableaux avec des structures et des pointeurs,
   il faudrait remplacer le tabLengths par un Type fils, de manière à créer
   un arbre de Type
 */

public class Type {
    private EnumType type;
    private List<Integer> tabLengths;
    private String name;

    public Type(String name, List<Integer> tabLengths) {
	    this.type = EnumType.UNKNOWN;
	    this.name = name;
        //Copie en itération
	    this.tabLengths = new ArrayList<Integer>(tabLengths.size());
        for (Integer i: tabLengths){
            this.tabLengths.add(i);
        }
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
        if (o instanceof Type) {
            Type tmp = (Type) o;
            return tmp.getName().equals(this.getName());
        }
        return false;
    }

    public boolean validPos(int deepness, int pos) {
        if (deepness == 0 && this.tabLengths.isEmpty())
            return true;
        //return (0 < deepness <= this.tabLengths.size())
        //    && (0 <= pos < this.tabLengths.get(deepness-1));
        return estBorne(deepness, this.tabLengths.size(), true)
                && estBorne(pos, this.tabLengths.get(deepness-1), false);
    }

  //  private int getLength(int deepness) {
  //      return this.tabLengths.get(deepness);
  //  }


    public static boolean estBorne(int A, int B, boolean sens){
        //retourne true si A est entre [0, B] selon sens
        //sinon false
        return (A > 0 && A < B)?((sens)?(A <= B):(0<=A)):false;
    }
}
