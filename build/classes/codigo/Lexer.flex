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

/* Programa Principal */
"programa" { lexeme=yytext(); return Programa;}


/* Bloques */
"[" { lexeme=yytext(); return Corchete_a;}
"]" { lexeme=yytext(); return Corchete_c;}
"(" { lexeme=yytext(); return Parentesis_a;}
")" { lexeme=yytext(); return Parentesis_c;}
"{" { lexeme=yytext(); return Llave_a;}
"}" { lexeme=yytext(); return Llave_c;}


/* Tipo de Datos */
entero { lexeme=yytext(); return Entero;}
logico { lexeme=yytext(); return Logico;}
vector { lexeme=yytext(); return Vector;}

/* Instrucción de Movimiento */
avanzar { lexeme=yytext(); return Avanzar;}

/* Instrucciones de Rotación */
mirarArriba { lexeme=yytext(); return MirarArriba;}
mirarAbajo { lexeme=yytext(); return MirarAbajo;}
mirarIzquierda { lexeme=yytext(); return MirarIzquierda;}
mirarDerecha { lexeme=yytext(); return MirarDerecha;}

/* Instrucciones Condicionales */
si { lexeme=yytext(); return Si;}
sino { lexeme=yytext(); return Sino;}

/* Instrucciones de Control */
para {lexeme=yytext(); return Para;}
repita {lexeme=yytext(); return Repita;}

/* Operación de Asignación */
":=" { lexeme=yytext(); return Asignacion;}

/* Operaciónes Aritmeticas */
"+" { lexeme=yytext(); return Suma;}
"-" { lexeme=yytext(); return Resta;}
"*" { lexeme=yytext(); return Multiplicacion;}
"/" { lexeme=yytext(); return Division;}
"mod" { lexeme=yytext(); return Modulo;}

/* Operaciónes Relacionales */
"<" { lexeme=yytext(); return Menor;}
"<=" { lexeme=yytext(); return Menor_igual;}
">" { lexeme=yytext(); return Mayor;}
">=" { lexeme=yytext(); return Mayor_igual;}
"=" { lexeme=yytext(); return Igual;}
"<>" { lexeme=yytext(); return Diferencia;}

/* Operaciónes Logicas */
"Y" { lexeme=yytext(); return Y_logico;}
"O" { lexeme=yytext(); return O_logico;}
"!" { lexeme=yytext(); return Negacion_logica;}

/* Otros */
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"\n" {return Linea;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
 . {return ERROR;}
