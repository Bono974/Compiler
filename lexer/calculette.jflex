import java_cup.runtime.Symbol;

%%
%class CalculetteLexer
%line
%column
%cupsym CalculetteSymbol
%cup

EndOfLine = \r|\n|\r\n
Characters = [^\r\n]

Integer = [[:digit:]]+
Real = {Integer}(\.{Integer})?([Ee][+-]?{Integer})?
Id = [a-zA-Z_]+([a-zA-Z_] | [[:digit:]])*
Char = [a-zA-Z]
Comment = "/*" [^*] ~"*/" | "/*" "*"+ "/" | "//" {Characters}* {EndOfLine}

%%

/* -------------------------------------------------
        Variables Pointers
   ------------------------------------------------- */

"&"{Id}         { return new Symbol(CalculetteSymbol.ID, yyline, yycolumn,
           yytext()); }

/* -------------------------------------------------
        Increments / Decrements
   ------------------------------------------------- */
/*
"++" { return new Symbol(CalculetteSymbol.INC, yyline, yycolumn); }
"--" { return new Symbol(CalculetteSymbol.DEC, yyline, yycolumn); }*/

/* -------------------------------------------------
        Operateurs  
   ------------------------------------------------- */

"="      { return new Symbol(CalculetteSymbol.AFFECT, yyline, yycolumn); }

"["      { return new Symbol(CalculetteSymbol.LSBRA, yyline, yycolumn); }
"]"      { return new Symbol(CalculetteSymbol.RSBRA, yyline, yycolumn); }
"{"      { return new Symbol(CalculetteSymbol.LBRACE, yyline, yycolumn); }
"}"      { return new Symbol(CalculetteSymbol.RBRACE, yyline, yycolumn); }
"("      { return new Symbol(CalculetteSymbol.LRBRA,  yyline, yycolumn); }
")"      { return new Symbol(CalculetteSymbol.RRBRA,  yyline, yycolumn); }

";"      { return new Symbol(CalculetteSymbol.SEMIC, yyline, yycolumn); }
","      { return new Symbol(CalculetteSymbol.COMMA, yyline, yycolumn); }

"+"      { return new Symbol(CalculetteSymbol.PLUS,  yyline, yycolumn); }
"-"      { return new Symbol(CalculetteSymbol.MINUS, yyline, yycolumn); }
"*"      { return new Symbol(CalculetteSymbol.TIMES, yyline, yycolumn); }
"/"      { return new Symbol(CalculetteSymbol.DIVIDE,yyline, yycolumn); }

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


"if"      { return new Symbol(CalculetteSymbol.IF, yyline, yycolumn);       }
"else"    { return new Symbol(CalculetteSymbol.ELSE, yyline, yycolumn);     }
"for"     { return new Symbol(CalculetteSymbol.FOR, yyline, yycolumn);      }
"while"   { return new Symbol(CalculetteSymbol.WHILE, yyline, yycolumn);    }
"do"      { return new Symbol(CalculetteSymbol.DO, yyline, yycolumn);       }
"pointer" { return new Symbol(CalculetteSymbol.POINTER, yyline, yycolumn);  }

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

"int"           { return new Symbol(CalculetteSymbol.ENUM_TYPE, yyline, yycolumn,
           EnumType.INTEGER); }
"real"          { return new Symbol(CalculetteSymbol.ENUM_TYPE, yyline, yycolumn,
           EnumType.FLOAT); }
"char"          { return new Symbol(CalculetteSymbol.ENUM_TYPE, yyline, yycolumn,
           EnumType.CHARACTER); }
"bool"          { return new Symbol(CalculetteSymbol.ENUM_TYPE, yyline, yycolumn,
           EnumType.BOOLEAN); }
"char"          { return new Symbol(CalculetteSymbol.ENUM_TYPE, yyline, yycolumn,
           EnumType.CHARACTER); }
"string"        { return new Symbol(CalculetteSymbol.ENUM_TYPE, yyline, yycolumn,
           EnumType.STRING); }
{Id}            { return new Symbol(CalculetteSymbol.ID, yyline, yycolumn,
           yytext()); }
"'"{Id}"'"      { return new Symbol(CalculetteSymbol.CHARACTER, yyline, yycolumn,
           yytext()); }
"\""{Id}"\""    { return new Symbol(CalculetteSymbol.CHARACTERS, yyline, yycolumn,
           yytext()); }

/* -------------------------------------------------
        Commentaires - Caracteres non pris en compte
   ------------------------------------------------- */

{Comment} {}

/* -------------------------------------------------
   ------------------------------------------------- */
.|\n {}
