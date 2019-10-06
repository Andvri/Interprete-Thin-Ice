/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
/**
 *
 * @author andvri
 */
public class ContenedorJuego extends JPanel  implements Constantes{
    
    
    public ContenedorJuego () {
        setPreferredSize(new Dimension(ANCHO_CONTENEDOR_JUEGO, ALTO_VENTANA));
        setBounds(0, 0, ANCHO_CONTENEDOR_JUEGO, ALTO_VENTANA);
        
    }
}
