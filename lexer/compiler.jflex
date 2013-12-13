import java_cup.runtime.Symbol;
import tac.EnumType;

%%
%class CompilerLexer
%line
%column
%cupsym CompilerSymbol
%cup

EndOfLine = \r|\n|\r\n
Characters = [^\r\n]

Integer = [[:digit:]]+
Real    = {Integer}(\.{Integer})?([Ee][+-]?{Integer})?
Id      = [a-zA-Z_]+([a-zA-Z_] | [[:digit:]])*
Comment = "/*" [^*] ~"*/" | "/*" "*"+ "/" | "//" {Characters}* {EndOfLine}

%%

/* -------------------------------------------------
        Operateurs
   ------------------------------------------------- */

".."     { return new Symbol(CompilerSymbol.INTER,  yyline, yycolumn); }
"="      { return new Symbol(CompilerSymbol.AFFECT, yyline, yycolumn); }

"["      { return new Symbol(CompilerSymbol.LSBRA,  yyline, yycolumn); }
"]"      { return new Symbol(CompilerSymbol.RSBRA,  yyline, yycolumn); }
"{"      { return new Symbol(CompilerSymbol.LBRACE, yyline, yycolumn); }
"}"      { return new Symbol(CompilerSymbol.RBRACE, yyline, yycolumn); }
"("      { return new Symbol(CompilerSymbol.LRBRA,  yyline, yycolumn); }
")"      { return new Symbol(CompilerSymbol.RRBRA,  yyline, yycolumn); }

";"      { return new Symbol(CompilerSymbol.SEMIC, yyline, yycolumn); }
","      { return new Symbol(CompilerSymbol.COMMA, yyline, yycolumn); }

"+"      { return new Symbol(CompilerSymbol.PLUS,  yyline, yycolumn); }
"-"      { return new Symbol(CompilerSymbol.MINUS, yyline, yycolumn); }
"*"      { return new Symbol(CompilerSymbol.TIMES, yyline, yycolumn); }
"/"      { return new Symbol(CompilerSymbol.DIVIDE,yyline, yycolumn); }

"&&"     { return new Symbol(CompilerSymbol.AND,   yyline, yycolumn); }
"||"     { return new Symbol(CompilerSymbol.OR,    yyline, yycolumn); }
"<"      { return new Symbol(CompilerSymbol.LT,    yyline, yycolumn); }
">"      { return new Symbol(CompilerSymbol.GT,    yyline, yycolumn); }
"<="     { return new Symbol(CompilerSymbol.LE,    yyline, yycolumn); }
">="     { return new Symbol(CompilerSymbol.GE,    yyline, yycolumn); }
"=="     { return new Symbol(CompilerSymbol.EQ,    yyline, yycolumn); }
"!="     { return new Symbol(CompilerSymbol.DIFF,  yyline, yycolumn); }
"%"      { return new Symbol(CompilerSymbol.MOD,   yyline, yycolumn); }
"!"      { return new Symbol(CompilerSymbol.NOT,   yyline, yycolumn); }
"&"      { return new Symbol(CompilerSymbol.AMPERSAND,   yyline, yycolumn); }

/* -------------------------------------------------
        Mots réservés du langage
   ------------------------------------------------- */

"if"      { return new Symbol(CompilerSymbol.IF,    yyline, yycolumn);  }
"then"    { return new Symbol(CompilerSymbol.THEN,  yyline, yycolumn);  }
"else"    { return new Symbol(CompilerSymbol.ELSE,  yyline, yycolumn);  }
"for"     { return new Symbol(CompilerSymbol.FOR,   yyline, yycolumn);  }
"while"   { return new Symbol(CompilerSymbol.WHILE, yyline, yycolumn);  }
"do"      { return new Symbol(CompilerSymbol.DO,    yyline, yycolumn);  }
"def"     { return new Symbol(CompilerSymbol.DEF,   yyline, yycolumn);  }
"return"  { return new Symbol(CompilerSymbol.RETURN,yyline, yycolumn);  }


/* -------------------------------------------------
        Types
   ------------------------------------------------- */

// Entier sur 1 octet
"short"                            { return new Symbol(CompilerSymbol.ENUM_TYPE, yyline, yycolumn, EnumType.SHORT); }
"unsigned" " "+ "short"            { return new Symbol(CompilerSymbol.ENUM_TYPE, yyline, yycolumn, EnumType.UNSIGNED_SHORT); }

// Entier sur 2 octets
"int"                              { return new Symbol(CompilerSymbol.ENUM_TYPE, yyline, yycolumn, EnumType.INTEGER); }
"unsigned" " "+ "int"              { return new Symbol(CompilerSymbol.ENUM_TYPE, yyline, yycolumn, EnumType.UNSIGNED_INTEGER); }

"real"                             { return new Symbol(CompilerSymbol.ENUM_TYPE, yyline, yycolumn, EnumType.REAL); }
"unsigned" " "+ "real"             { return new Symbol(CompilerSymbol.ENUM_TYPE, yyline, yycolumn, EnumType.UNSIGNED_REAL); }


"bool"                             { return new Symbol(CompilerSymbol.ENUM_TYPE, yyline, yycolumn, EnumType.BOOLEAN); }
"char"                             { return new Symbol(CompilerSymbol.ENUM_TYPE, yyline, yycolumn, EnumType.CHARACTER); }
"string"                           { return new Symbol(CompilerSymbol.ENUM_TYPE, yyline, yycolumn, EnumType.CHARACTERS); }
"enum"                             { return new Symbol(CompilerSymbol.ENUM_TYPE, yyline, yycolumn, EnumType.ENUM); }

"pointer int"                      { return new Symbol(CompilerSymbol.ENUM_TYPE, yyline, yycolumn, EnumType.POINTER_INT); }
"pointer real"                     { return new Symbol(CompilerSymbol.ENUM_TYPE, yyline, yycolumn, EnumType.POINTER_REAL); }
"pointer char"                     { return new Symbol(CompilerSymbol.ENUM_TYPE, yyline, yycolumn, EnumType.POINTER_CHARACTER); }
"pointer string"                   { return new Symbol(CompilerSymbol.ENUM_TYPE, yyline, yycolumn, EnumType.POINTER_CHARACTERS); }


/* -------------------------------------------------
        Valeurs
   ------------------------------------------------- */

{Integer}                          { return new Symbol(CompilerSymbol.INT,  yyline, yycolumn, new Integer(yytext())); }
{Real}                             { return new Symbol(CompilerSymbol.REAL, yyline, yycolumn, new Float(yytext())); }

"true"                             { return new Symbol(CompilerSymbol.BOOL, yyline, yycolumn, yytext()); }
"false"                            { return new Symbol(CompilerSymbol.BOOL, yyline, yycolumn, yytext()); }

"'"([a-zA-Z] | [[:digit:]])"'"     { return new Symbol(CompilerSymbol.CHARACTER,  yyline, yycolumn, yytext()); }
{Id}                               { return new Symbol(CompilerSymbol.ID,         yyline, yycolumn, yytext()); }
"\""{Id}"\""                       { return new Symbol(CompilerSymbol.CHARACTERS, yyline, yycolumn, yytext()); }


/* -------------------------------------------------
   Commentaires - Caracteres non pris en compte
   ------------------------------------------------- */

{Comment} {}

/* -------------------------------------------------
   ------------------------------------------------- */
.|\n {}
