package juego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andvri
 */
public class ContenedorCodigo extends JPanel implements Constantes, MouseListener {
    private JTextArea displayInput;
    private JTextArea displayOutput;
    
    public ContenedorCodigo() {
        setPreferredSize(new Dimension(ANCHO_CONTENEDOR_CODIGO, ALTO_VENTANA));
        JTextArea codigo = new JTextArea(30,30);
        setLayout(null);
        setBounds(ANCHO_CONTENEDOR_JUEGO, 0, ANCHO_CONTENEDOR_CODIGO, ALTO_VENTANA);
        codigo.setBounds(10,10,100,100);
        
        JLabel codigoLabel = new JLabel("Codigo");
        JLabel salidaLabel = new JLabel("Salida");
        
        JButton generar = new JButton("Generar");
        
        this.displayOutput = new JTextArea();
        this.displayInput = new JTextArea();
        
        JScrollPane scrollInput = new JScrollPane(this.displayInput);
        JScrollPane scrollOutput = new JScrollPane(this.displayOutput);
        
        
        this.displayOutput.setEditable(false);
        
        scrollInput.setBounds(
                PIXEL,
                PIXEL,
                ANCHO_CONTENEDOR_CODIGO - (2*PIXEL), 
                (ALTO_VENTANA*2/3) - PIXEL
        );
        
        codigoLabel.setBounds(
                PIXEL, 
                PIXEL/4,
                ANCHO_CONTENEDOR_CODIGO - (2*PIXEL),
                18 
        );
        
        salidaLabel.setBounds(
                PIXEL, 
                (ALTO_VENTANA*2/3) + (PIXEL*3/2),
                ANCHO_CONTENEDOR_CODIGO - (2*PIXEL),
                18
        );
        
        scrollOutput.setBounds(
                PIXEL,
                (ALTO_VENTANA*2/3) + (PIXEL*5/2),
                ANCHO_CONTENEDOR_CODIGO - (2*PIXEL), 
                PIXEL*2
        );
        
        generar.setBounds(
                PIXEL, 
                (ALTO_VENTANA*2/3) + (PIXEL*1/2),
                ANCHO_CONTENEDOR_CODIGO - (2*PIXEL),
                18
        );
        
        this.displayOutput.setEditable(false);
        
        
        generar.addMouseListener(this);
        add(codigoLabel);
        add(scrollInput);
        add(scrollOutput);
        add(generar);
        add(salidaLabel);
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        this.displayOutput.setText(this.displayInput.getText());
    }

    @Override
    public void mousePressed(MouseEvent arg0) {

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {

    }

    @Override
    public void mouseExited(MouseEvent arg0) {

    }
}
    