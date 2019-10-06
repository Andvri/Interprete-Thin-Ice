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

/**
 *
 *
 * javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
 * jPanel1.setLayout(jPanel1Layout); jPanel1Layout.setHorizontalGroup(
 * jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 * .addGap(0, 300, Short.MAX_VALUE) ); jPanel1Layout.setVerticalGroup(
 * jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 * .addGap(0, 510, Short.MAX_VALUE) );
 *
 * javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
 * jPanel2.setLayout(jPanel2Layout); jPanel2Layout.setHorizontalGroup(
 * jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 * .addGap(0, 565, Short.MAX_VALUE) ); jPanel2Layout.setVerticalGroup(
 * jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 * .addGap(0, 0, Short.MAX_VALUE) );
 *
 * jPanel1.setBackground(Color.red); jPanel2.setBackground(Color.yellow);
 *
 * javax.swing.GroupLayout layout = new
 * javax.swing.GroupLayout(getContentPane());
 * getContentPane().setLayout(layout); layout.setHorizontalGroup(
 * layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 * .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
 * layout.createSequentialGroup() .addComponent(jPanel2,
 * javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
 * Short.MAX_VALUE)
 * .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
 * .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
 * javax.swing.GroupLayout.DEFAULT_SIZE,
 * javax.swing.GroupLayout.PREFERRED_SIZE)) ); layout.setVerticalGroup(
 * layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
 * .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
 * javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) .addComponent(jPanel2,
 * javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
 * Short.MAX_VALUE) );
 */
