/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.File;

/**
 *
 * @author kvnsnchz
 */
public class Principal {
    
    public static void main(String[] args) {
        System.out.println("Hel");
        String ruta = "/home/kvnsnchz/Documents/UNET/Semestre 7/Compiladores/Interprete-Thin-Ice/src/main/java/codigo/Lexer.flex";
        generarLexer(ruta);
    }
    
    public static void generarLexer(String ruta){
        File archivo = new File(ruta);
        jflex.Main.generate(archivo);
    }
}
