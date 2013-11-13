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

":="     { return new Symbol(CalculetteSymbol.EQUALS, yyline, yycolumn); }

"["      { return new Symbol(CalculetteSymbol.LPAR, yyline, yycolumn); }
"]"      { return new Symbol(CalculetteSymbol.RPAR, yyline, yycolumn); }

";"      { return new Symbol(CalculetteSymbol.SEMIC, yyline, yycolumn); }
","      { return new Symbol(CalculetteSymbol.COMMA, yyline, yycolumn); }


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

"int"          { return new Symbol(CalculetteSymbol.ENUMTYPE, yyline, yycolumn,
				   EnumType.INT); }
"real"         { return new Symbol(CalculetteSymbol.ENUMTYPE, yyline, yycolumn,
				   EnumType.REAL); }
{Id}           { return new Symbol(CalculetteSymbol.ID, yyline, yycolumn,
				   yytext()); }

/* -------------------------------------------------
        Commentaires - Caracteres non pris en compte
   ------------------------------------------------- */

{Comment} {}

/* -------------------------------------------------
   ------------------------------------------------- */
.|\n {}
