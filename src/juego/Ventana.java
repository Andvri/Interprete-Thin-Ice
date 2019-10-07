/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author andvri
 */
public class Ventana extends JFrame implements Constantes {

    private FlowLayout layout;
    private ContenedorJuego cj;
    private ContenedorCodigo cc;

    public Ventana() {
        setTitle("Thin Ice");
        setSize(new Dimension(ANCHO_VENTANA, ALTO_VENTANA));

        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        this.cc = new ContenedorCodigo();
        this.cj = new ContenedorJuego(this.cc.getOutput());
        
        this.cj.setBackground(new Color(128, 188, 252));
        this.cc.setBackground(new Color(128, 188, 252));
        setBackground(new Color(128, 188, 252));
        
        add(this.cj);
        add(this.cc);
        setVisible(true);
        setResizable(false);
       
    }

}