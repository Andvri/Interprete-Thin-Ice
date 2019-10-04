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
logico { lexeme=yytext(); return Logico;}
si { lexeme=yytext(); return Si;}
sino { lexeme=yytext(); return Sino;}
mientras {lexeme=yytext(); return Mientras;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"\n" {return Linea;}
":=" { lexeme=yytext(); return Asignacion;}
"=" { lexeme=yytext(); return Igual;}
"<=" { lexeme=yytext(); return Menor_igual;}
">=" { lexeme=yytext(); return Mayor_igual;}
"<>" { lexeme=yytext(); return Diferencia;}
"<" { lexeme=yytext(); return Menor;}
">" { lexeme=yytext(); return Mayor;}
"+" { lexeme=yytext(); return Suma;}
"-" { lexeme=yytext(); return Resta;}
"*" { lexeme=yytext(); return Multiplicacion;}
"/" { lexeme=yytext(); return Division;}
"[" { lexeme=yytext(); return Corchete_a;}
"]" { lexeme=yytext(); return Corchete_c;}
"(" { lexeme=yytext(); return Parentesis_a;}
")" { lexeme=yytext(); return Parentesis_c;}
"{" { lexeme=yytext(); return Llave_a;}
"}" { lexeme=yytext(); return Llave_c;}
"mod" { lexeme=yytext(); return Modulo;}
"Y" { lexeme=yytext(); return Y_logico;}
"O" { lexeme=yytext(); return O_logico;}
"!" { lexeme=yytext(); return Negacion_logica;}
"programa" { lexeme=yytext(); return Programa;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
 . {return ERROR;}
