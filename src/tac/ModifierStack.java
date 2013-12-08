package tac;
import java.util.*;

public class ModifierStack {

    public static void pushTV(Stack pileTableVariable) {
    	HashMap top = (HashMap)pileTableVariable.peek(); 
      	HashMap clone = (HashMap)top.clone();
      	pileTableVariable.push(clone);
    }

    public static void popTV(Stack pileTableVariable) {
    	pileTableVariable.pop();
    }
}
