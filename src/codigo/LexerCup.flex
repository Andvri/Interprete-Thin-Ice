package codigo;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

/* Programa Principal */
"programa" { return new Symbol(sym.Programa, yychar, yyline, yytext()); }

/* Bloques */
"[" { return new Symbol(sym.Corchete_a, yychar, yyline, yytext());}
"]" { return new Symbol(sym.Corchete_c, yychar, yyline, yytext());}
"(" { return new Symbol(sym.Parentesis_a, yychar, yyline, yytext());}
")" { return new Symbol(sym.Parentesis_c, yychar, yyline, yytext());}
"{" { return new Symbol(sym.Llave_a, yychar, yyline, yytext());}
"}" { return new Symbol(sym.Llave_c, yychar, yyline, yytext());}

/* Tipo de Datos */
entero { return new Symbol(sym.Entero, yychar, yyline, yytext());}
logico { return new Symbol(sym.Logico, yychar, yyline, yytext());}

/* Instrucciones Condicionales */
si { return new Symbol(sym.Si, yychar, yyline, yytext());}
sino { return new Symbol(sym.Sino, yychar, yyline, yytext());}

/* Instrucciones de Control */
para { return new Symbol(sym.Para, yychar, yyline, yytext());}
repita { return new Symbol(sym.Repita, yychar, yyline, yytext());}
hasta { return new Symbol(sym.Hasta, yychar, yyline, yytext());}
que { return new Symbol(sym.Que, yychar, yyline, yytext());}
/* Operación de Asignación */
":=" { return new Symbol(sym.Asignacion, yychar, yyline, yytext());}

/* Operaciónes Aritmeticas */
"+" { return new Symbol(sym.Suma, yychar, yyline, yytext()); }
"-" { return new Symbol(sym.Resta, yychar, yyline, yytext()); }
"*" { return new Symbol(sym.Multiplicacion, yychar, yyline, yytext());}
"/" { return new Symbol(sym.Division, yychar, yyline, yytext());}
"mod" { return new Symbol(sym.Modulo, yychar, yyline, yytext());}

/* Operaciónes Relacionales */
"<" { return new Symbol(sym.Menor, yychar, yyline, yytext());}
"<=" { return new Symbol(sym.Menor_igual, yychar, yyline, yytext());}
">" { return new Symbol(sym.Mayor, yychar, yyline, yytext());}
">=" { return new Symbol(sym.Mayor_igual, yychar, yyline, yytext());}
"=" { return new Symbol(sym.Igual, yychar, yyline, yytext());}
"<>" { return new Symbol(sym.Diferencia, yychar, yyline, yytext());}

/* Operaciónes Logicas */
"Y" { return new Symbol(sym.Y_logico, yychar, yyline, yytext());}
"O" { return new Symbol(sym.O_logico, yychar, yyline, yytext());}
"!" { return new Symbol(sym.Negacion_logica, yychar, yyline, yytext());}

/* Otros */
{espacio} {/*Ignore*/}
";" { return new Symbol(sym.Punto_coma, yychar, yyline, yytext());}
"//".* {/*Ignore*/}
"true"|"false" { return new Symbol(sym.Booleano, yychar, yyline, yytext());}
{L}({L}|{D})* { return new Symbol(sym.Identificador, yychar, yyline, yytext()); }
{D}+ { return new Symbol(sym.Numero, yychar, yyline, yytext()); }
 . { return new Symbol(sym.ERROR, yychar, yyline, yytext()); }
