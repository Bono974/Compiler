import java_cup.runtime.Symbol;

%%
%class CalculetteLexer
%line
%column
%cupsym CalculetteSymbol
%cup

Integer = [[:digit:]]+
Real = "-"?{Integer}(\.{Integer})?([Ee][+-]?{Integer})?
Id = [a-zA-Z]+([a-zA-Z] | [[:digit:]])*
Comment = "/*" [^*] ~"*/" | "/*" "*"+ "/"

%%

/* -------------------------------------------------
        Operateurs
   ------------------------------------------------- */

":="     { return new Symbol(CalculetteSymbol.AFFECT, yyline, yycolumn); }

"["      { return new Symbol(CalculetteSymbol.LSBRA, yyline, yycolumn); }
"]"      { return new Symbol(CalculetteSymbol.RSBRA, yyline, yycolumn); }

";"      { return new Symbol(CalculetteSymbol.SEMIC, yyline, yycolumn); }
","      { return new Symbol(CalculetteSymbol.COMMA, yyline, yycolumn); }

"+"      { return new Symbol(CalculetteSymbol.PLUS,  yyline, yycolumn); }
"-"      { return new Symbol(CalculetteSymbol.MINUS, yyline, yycolumn); }
"*"      { return new Symbol(CalculetteSymbol.TIMES, yyline, yycolumn); }
"/"      { return new Symbol(CalculetteSymbol.DIVIDE,yyline, yycolumn); }
"("      { return new Symbol(CalculetteSymbol.LRBRA,  yyline, yycolumn); }
")"      { return new Symbol(CalculetteSymbol.RRBRA,  yyline, yycolumn); }

"&&"     { return new Symbol(CalculetteSymbol.AND,   yyline, yycolumn); }
"||"     { return new Symbol(CalculetteSymbol.OR,    yyline, yycolumn); }
"<"      { return new Symbol(CalculetteSymbol.LT,    yyline, yycolumn); }
">"      { return new Symbol(CalculetteSymbol.GT,    yyline, yycolumn); }
"<="     { return new Symbol(CalculetteSymbol.LE,    yyline, yycolumn); }
">="     { return new Symbol(CalculetteSymbol.GE,    yyline, yycolumn); }
"=="     { return new Symbol(CalculetteSymbol.EQ,    yyline, yycolumn); }
"!="     { return new Symbol(CalculetteSymbol.DIFF,  yyline, yycolumn); }
"%"      { return new Symbol(CalculetteSymbol.MOD,   yyline, yycolumn); }
"!"      { return new Symbol(CalculetteSymbol.NOT,   yyline, yycolumn); }
"true"   { return new Symbol(CalculetteSymbol.TRUE,  yyline, yycolumn); }
"false"  { return new Symbol(CalculetteSymbol.FALSE, yyline, yycolumn); }


/* -------------------------------------------------
        Valeurs
   ------------------------------------------------- */

{Integer}      { return new Symbol(CalculetteSymbol.INT, yyline, yycolumn,
				   new Integer(yytext())); }
{Real}         { return new Symbol(CalculetteSymbol.REAL, yyline, yycolumn,
				   new Float(yytext())); }

/* -------------------------------------------------
        Variables
   ------------------------------------------------- */

"int"          { return new Symbol(CalculetteSymbol.ENUM_TYPE, yyline, yycolumn,
				   EnumType.INTEGER); }
"real"         { return new Symbol(CalculetteSymbol.ENUM_TYPE, yyline, yycolumn,
				   EnumType.FLOAT); }
{Id}           { return new Symbol(CalculetteSymbol.ID, yyline, yycolumn,
				   yytext()); }

/* -------------------------------------------------
        Commentaires - Caracteres non pris en compte
   ------------------------------------------------- */

{Comment} {}

/* -------------------------------------------------
   ------------------------------------------------- */
.|\n {}
