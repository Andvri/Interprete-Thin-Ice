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

entero { return new Symbol(sym.Entero, yychar, yyline, yytext());}
si { return new Symbol(sym.Si, yychar, yyline, yytext());}
sino { return new Symbol(sym.Sino, yychar, yyline, yytext());}
mientras { return new Symbol(sym.Mientras, yychar, yyline, yytext()); }
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
":=" { return new Symbol(sym.Igual, yychar, yyline, yytext()); }
"+" { return new Symbol(sym.Suma, yychar, yyline, yytext()); }
"-" { return new Symbol(sym.Resta, yychar, yyline, yytext()); }
"*" { return new Symbol(sym.Multiplicacion, yychar, yyline, yytext());}
"/" { return new Symbol(sym.Division, yychar, yyline, yytext());}
"(" { return new Symbol(sym.Parentesis_a, yychar, yyline, yytext());}
")" { return new Symbol(sym.Parentesis_c, yychar, yyline, yytext());}
"{" { return new Symbol(sym.Llave_a, yychar, yyline, yytext());}
"}" { return new Symbol(sym.Llave_c, yychar, yyline, yytext());}
"programa" { return new Symbol(sym.Programa, yychar, yyline, yytext()); }
{L}({L}|{D})* { return new Symbol(sym.Identificador, yychar, yyline, yytext()); }
("(-"{D}+")")|{D}+ { return new Symbol(sym.Numero, yychar, yyline, yytext()); }
 . { return new Symbol(sym.Error, yychar, yyline, yytext()); }
