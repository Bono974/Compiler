
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Tue Nov 19 10:42:14 CET 2013
//----------------------------------------------------

import java_cup.runtime.*;
import java.lang.Number;
import java.util.*;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Tue Nov 19 10:42:14 CET 2013
  */
public class CalculetteParser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public CalculetteParser() {super();}

  /** Constructor which sets the default scanner. */
  public CalculetteParser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public CalculetteParser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\016\000\002\002\004\000\002\002\004\000\002\003" +
    "\005\000\002\005\003\000\002\006\005\000\002\006\003" +
    "\000\002\007\003\000\002\007\006\000\002\004\004\000" +
    "\002\004\003\000\002\010\006\000\002\011\006\000\002" +
    "\011\003\000\002\011\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\034\000\004\011\004\001\002\000\004\014\ufffe\001" +
    "\002\000\004\014\015\001\002\000\004\002\026\001\002" +
    "\000\004\014\010\001\002\000\004\006\014\001\002\000" +
    "\006\002\ufff8\014\ufff8\001\002\000\006\002\000\014\010" +
    "\001\002\000\006\002\ufff9\014\ufff9\001\002\000\010\012" +
    "\021\013\017\014\015\001\002\000\010\004\ufffb\005\ufffb" +
    "\007\ufffb\001\002\000\004\007\023\001\002\000\004\004" +
    "\ufff4\001\002\000\004\004\022\001\002\000\004\004\ufff5" +
    "\001\002\000\006\002\ufff7\014\ufff7\001\002\000\004\012" +
    "\024\001\002\000\004\010\025\001\002\000\006\004\ufff6" +
    "\007\ufffa\001\002\000\004\002\001\001\002\000\006\004" +
    "\035\005\034\001\002\000\010\004\ufffc\005\ufffc\007\031" +
    "\001\002\000\004\012\032\001\002\000\004\010\033\001" +
    "\002\000\010\004\ufffa\005\ufffa\007\ufffa\001\002\000\004" +
    "\014\015\001\002\000\004\014\uffff\001\002\000\010\004" +
    "\ufffd\005\ufffd\007\031\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\034\000\010\002\005\003\006\005\004\001\001\000" +
    "\002\001\001\000\006\006\026\007\027\001\001\000\002" +
    "\001\001\000\006\004\011\010\010\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\010\012\001\001\000\002" +
    "\001\001\000\006\007\015\011\017\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\007\035\001\001\000\002" +
    "\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$CalculetteParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$CalculetteParser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$CalculetteParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  /** User initialization code. */
  public void user_init() throws java.lang.Exception
    {
 //  initialisation des variables
    declVars = new ArrayList<Type>();
    usedVars = new ArrayList<Type>();
    tabLengths = new ArrayList<Integer>();
    deepness = 0;

    }

 // ajout de variables ou surcharge de methodes
    public List<Type> declVars;
    public List<Type> usedVars;
    public List<Integer> tabLengths;
    public int deepness;

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$CalculetteParser$actions {

 // methodes utiles pour les actions associees à la grammaire
    public void defineType(List<Type> list, EnumType type) {
        for (Type t : list)
            t.setType(type);
    }

    public Type addVar(List<Type> list, String name, List<Integer> tabLengths) {
        Type res = new Type(name, tabLengths);
        list.add(res);
        tabLengths.clear();
        return res;
    }

    public Type getVar(List<Type> list, String name) {
        for(Type t: list)
            if (t.getName().equals(name))
                return t;
        return null;
    }

    public boolean isDecl(String var, List<Type> declVars) {
        for(Type t: declVars)
            if (t.getName().equals(var))
                return true;
        return false;
    }

  private final CalculetteParser parser;

  /** Constructor */
  CUP$CalculetteParser$actions(CalculetteParser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$CalculetteParser$do_action(
    int                        CUP$CalculetteParser$act_num,
    java_cup.runtime.lr_parser CUP$CalculetteParser$parser,
    java.util.Stack            CUP$CalculetteParser$stack,
    int                        CUP$CalculetteParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$CalculetteParser$result;

      /* select the action based on the action number */
      switch (CUP$CalculetteParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // E ::= REAL 
            {
              Object RESULT =null;
		  
              CUP$CalculetteParser$result = parser.getSymbolFactory().newSymbol("E",7, ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.peek()), RESULT);
            }
          return CUP$CalculetteParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // E ::= INT 
            {
              Object RESULT =null;
		  
              CUP$CalculetteParser$result = parser.getSymbolFactory().newSymbol("E",7, ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.peek()), RESULT);
            }
          return CUP$CalculetteParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // E ::= I LPAR INT RPAR 
            {
              Object RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.elementAt(CUP$CalculetteParser$top-3)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.elementAt(CUP$CalculetteParser$top-3)).right;
		Object name = (Object)((java_cup.runtime.Symbol) CUP$CalculetteParser$stack.elementAt(CUP$CalculetteParser$top-3)).value;
		 
              CUP$CalculetteParser$result = parser.getSymbolFactory().newSymbol("E",7, ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.elementAt(CUP$CalculetteParser$top-3)), ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.peek()), RESULT);
            }
          return CUP$CalculetteParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // S ::= ID EQUALS E SEMIC 
            {
              Object RESULT =null;
		int var1left = ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.elementAt(CUP$CalculetteParser$top-3)).left;
		int var1right = ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.elementAt(CUP$CalculetteParser$top-3)).right;
		String var1 = (String)((java_cup.runtime.Symbol) CUP$CalculetteParser$stack.elementAt(CUP$CalculetteParser$top-3)).value;
		 
              CUP$CalculetteParser$result = parser.getSymbolFactory().newSymbol("S",6, ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.elementAt(CUP$CalculetteParser$top-3)), ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.peek()), RESULT);
            }
          return CUP$CalculetteParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // Ss ::= S 
            {
              Object RESULT =null;
		 
              CUP$CalculetteParser$result = parser.getSymbolFactory().newSymbol("Ss",2, ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.peek()), RESULT);
            }
          return CUP$CalculetteParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // Ss ::= Ss S 
            {
              Object RESULT =null;
		 
              CUP$CalculetteParser$result = parser.getSymbolFactory().newSymbol("Ss",2, ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.elementAt(CUP$CalculetteParser$top-1)), ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.peek()), RESULT);
            }
          return CUP$CalculetteParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // I ::= I LPAR INT RPAR 
            {
              Object RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.elementAt(CUP$CalculetteParser$top-3)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.elementAt(CUP$CalculetteParser$top-3)).right;
		Object name = (Object)((java_cup.runtime.Symbol) CUP$CalculetteParser$stack.elementAt(CUP$CalculetteParser$top-3)).value;
		 
              CUP$CalculetteParser$result = parser.getSymbolFactory().newSymbol("I",5, ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.elementAt(CUP$CalculetteParser$top-3)), ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.peek()), RESULT);
            }
          return CUP$CalculetteParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // I ::= ID 
            {
              Object RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.peek()).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.peek()).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$CalculetteParser$stack.peek()).value;
		 
              CUP$CalculetteParser$result = parser.getSymbolFactory().newSymbol("I",5, ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.peek()), RESULT);
            }
          return CUP$CalculetteParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // L ::= I 
            {
              Object RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.peek()).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.peek()).right;
		Object name = (Object)((java_cup.runtime.Symbol) CUP$CalculetteParser$stack.peek()).value;
		  
              CUP$CalculetteParser$result = parser.getSymbolFactory().newSymbol("L",4, ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.peek()), RESULT);
            }
          return CUP$CalculetteParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // L ::= L COMMA I 
            {
              Object RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.peek()).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.peek()).right;
		Object name = (Object)((java_cup.runtime.Symbol) CUP$CalculetteParser$stack.peek()).value;
		  
              CUP$CalculetteParser$result = parser.getSymbolFactory().newSymbol("L",4, ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.elementAt(CUP$CalculetteParser$top-2)), ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.peek()), RESULT);
            }
          return CUP$CalculetteParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // T ::= ENUMTYPE 
            {
              Object RESULT =null;
		  
              CUP$CalculetteParser$result = parser.getSymbolFactory().newSymbol("T",3, ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.peek()), RESULT);
            }
          return CUP$CalculetteParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // D ::= T L SEMIC 
            {
              Object RESULT =null;
		int typeleft = ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.elementAt(CUP$CalculetteParser$top-2)).left;
		int typeright = ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.elementAt(CUP$CalculetteParser$top-2)).right;
		Object type = (Object)((java_cup.runtime.Symbol) CUP$CalculetteParser$stack.elementAt(CUP$CalculetteParser$top-2)).value;
		 
              CUP$CalculetteParser$result = parser.getSymbolFactory().newSymbol("D",1, ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.elementAt(CUP$CalculetteParser$top-2)), ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.peek()), RESULT);
            }
          return CUP$CalculetteParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // P ::= D Ss 
            {
              Object RESULT =null;
		 
              CUP$CalculetteParser$result = parser.getSymbolFactory().newSymbol("P",0, ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.elementAt(CUP$CalculetteParser$top-1)), ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.peek()), RESULT);
            }
          return CUP$CalculetteParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= P EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.elementAt(CUP$CalculetteParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.elementAt(CUP$CalculetteParser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$CalculetteParser$stack.elementAt(CUP$CalculetteParser$top-1)).value;
		RESULT = start_val;
              CUP$CalculetteParser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.elementAt(CUP$CalculetteParser$top-1)), ((java_cup.runtime.Symbol)CUP$CalculetteParser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$CalculetteParser$parser.done_parsing();
          return CUP$CalculetteParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

