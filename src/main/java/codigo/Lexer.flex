package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r]+
%{
    public String lexeme;
%}
%%
entero { lexeme=yytext(); return Entero;}
si { lexeme=yytext(); return Si;}
sino { lexeme=yytext(); return Sino;}
mientras {lexeme=yytext(); return Mientras;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"\n" {return Linea;}
":=" { lexeme=yytext(); return Igual;}
"+" { lexeme=yytext(); return Suma;}
"-" { lexeme=yytext(); return Resta;}
"*" { lexeme=yytext(); return Multiplicacion;}
"/" { lexeme=yytext(); return Division;}
"programa" { lexeme=yytext(); return Programa;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
 . {return ERROR;}
