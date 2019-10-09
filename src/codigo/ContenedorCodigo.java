package codigo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import codigo.*;
import arbol.*;
import java.io.StringReader;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
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
    private JButton generar;
    
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
        this.displayInput.setText(
            "programa() {\n" +
            "    entero a\n" +
            "    mirarDerecha()\n" +
            "    para(a := 0; a := a +1; a < 10) {\n" +
            "        avanzar(a)\n" +
            "    }\n" +
            "}"
        );
        
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
        this.generar = generar;
    }
     
    public JTextArea getOutput() {
        return this.displayOutput;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        String ST = this.displayInput.getText();
        StringReader str = new StringReader(ST);
        LexerCup lc = new codigo.LexerCup(str);
        Sintax s = new Sintax(lc);

        try {
            s.parse();
            NodoBase raiz= s.getNodoBase();
            TablaSimbolos ts = new TablaSimbolos();
            ts.cargar(raiz);
            
            Semantic semantic = new Semantic();
            semantic.analizar(raiz, ts);
            
            if (semantic.sinErrores()) {
                GenerarCodigo gc = new GenerarCodigo();
                gc.generarSalida(raiz, ts);
                this.displayOutput.setText(gc.getImprimir());
            }

        } catch (Exception ex) {
            if (ex instanceof ClassCastException){
                try {
                    //case 44: // OPERACION_MOD ::= OPERACION_MOD Modulo FACTOR line 525
                    // replace  par RESULT= new NodoOperacion((NodoBase) operI, (Tokens) Tokens.Modulo, (NodoBase) operD, TiposIds.entero);
                    throw ex;
                } catch (Exception ex1) {

                }
            }
        }
        
        
        
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
    