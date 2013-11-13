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

":="     { return new Symbol(parser.EQUALS, yyline, yycolumn); }

"["      { return new Symbol(parser.LPAR, yyline, yycolumn); }
"]"      { return new Symbol(parser.RPAR, yyline, yycolumn); }

";"      { return new Symbol(parser.SEMIC, yyline, yycolumn); }
","      { return new Symbol(parser.COMMA, yyline, yycolumn); }


/* -------------------------------------------------
        Valeurs
   ------------------------------------------------- */

{Integer}      { return new Symbol(parser.INT, yyline, yycolumn,
				   new Integer(yytext())); }
{Real}         { return new Symbol(parser.REAL, yyline, yycolumn,
				   new Float(yytext())); }

/* -------------------------------------------------
        Variables
   ------------------------------------------------- */

"int"          { return new Symbol(parser.ENUMTYPE, yyline, yycolumn,
				   EnumType.INT); }
"real"         { return new Symbol(parser.ENUMTYPE, yyline, yycolumn,
				   EnumType.REAL); }
{Id}           { return new Symbol(parser.ID, yyline, yycolumn,
				   yytext()); }

/* -------------------------------------------------
        Commentaires - Caracteres non pris en compte
   ------------------------------------------------- */

{Comment} {}

/* -------------------------------------------------
   ------------------------------------------------- */
.|\n {}
