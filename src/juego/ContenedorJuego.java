/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 *
 * @author andvri
 */
public class ContenedorJuego extends JPanel  implements Constantes{
    private JPanel SubContenedor;
    private JPanel HeaderContenedor;
    private JPanel FooterContenedor;
    private BufferedImage imageJugador;
    private BufferedImage imageMuro;
    private BufferedImage imageInactivo;
    private BufferedImage imageAgua;
    private BufferedImage imageHielo;
    private BufferedImage imageLlegada;
    
    private JTextArea outputTextArea;
    private int x = 0;
    private int y = 0;
    private  JPanel [][] mapaGrafico = new JPanel[FILAS_JUEGO][COLUMNAS_JUEGO];
    private int [][] mapaLogico = {
        {-2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2},
        {-2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2},
        {-2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2},
        {-2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2},
        {-2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2},
        {-2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2},
        {-2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2},
        {-2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -1, -1, -1, -2, -2, -2},
        {-2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -1,  4, -1, -2, -2, -2},
        {-2, -2, -2, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  1, -1, -1, -1, -2},
        {-2, -1, -1, -1, -1,  1,  1,  1,  1,  1,  1,  1,  1, -1,  1,  1,  1, -1, -2},
        {-2, -1,  5,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, -1,  1,  1,  1, -1, -2},
        {-2, -1, -1, -1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, -1, -2},
        {-2, -2, -2, -1, -1, -1, -1,  1,  1,  1, -1, -1, -1, -1, -1, -1, -1, -1, -2},
        {-2, -2, -2, -2, -2, -2, -1, -1, -1, -1, -1, -2, -2, -2, -2, -2, -2, -2, -2},
        {-2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2}
    }; 
    
    
    public ContenedorJuego (JTextArea outputTextArea) {
        setPreferredSize(new Dimension(ANCHO_CONTENEDOR_JUEGO, ALTO_VENTANA));
        setBounds(0, 0, ANCHO_CONTENEDOR_JUEGO, ALTO_VENTANA);
 
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);
        
        this.HeaderContenedor = new JPanel();
        this.SubContenedor = new JPanel();
        this.FooterContenedor = new JPanel();
        
        this.HeaderContenedor.setSize(ANCHO_CONTENEDOR_JUEGO, PIXEL);
        this.SubContenedor.setSize(ANCHO_CONTENEDOR_JUEGO, ALTO_VENTANA - (2*PIXEL));
        this.FooterContenedor.setSize(ANCHO_CONTENEDOR_JUEGO, PIXEL);
        
        this.HeaderContenedor.setMaximumSize(new Dimension(ANCHO_CONTENEDOR_JUEGO, PIXEL));
        this.SubContenedor.setMaximumSize(new Dimension(ANCHO_CONTENEDOR_JUEGO, ALTO_VENTANA - (3*PIXEL)));
        this.FooterContenedor.setMaximumSize(new Dimension(ANCHO_CONTENEDOR_JUEGO, PIXEL));

        this.HeaderContenedor.setBackground(new Color(128, 188, 252));
        this.SubContenedor.setBackground(new Color(128, 188, 252));
        this.FooterContenedor.setBackground(new Color(128, 188, 252));
        
        add(this.HeaderContenedor);
        add(this.SubContenedor);
        add(this.FooterContenedor);
        
        JButton reiniciar = new JButton("Reiniciar");
        
        this.FooterContenedor.add(reiniciar);
        
        
        
        
        this.outputTextArea = outputTextArea;
        
        outputTextArea.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                ejecutarCambios();
            }

            @Override
            public void changedUpdate(DocumentEvent arg0) {
                ejecutarCambios();
            }
        });
        
        
        
        try {
            this.imageJugador = ImageIO.read(new File(IMAGENESPATH + "bloque-player.png"));
            this.imageAgua = ImageIO.read(new File(IMAGENESPATH + "bloque-agua.png"));
            this.imageHielo = ImageIO.read(new File(IMAGENESPATH + "bloque-hielo.png"));
            this.imageLlegada = ImageIO.read(new File(IMAGENESPATH + "bloque-llegada.png"));
            this.imageMuro = ImageIO.read(new File(IMAGENESPATH + "bloque-muro.png"));
            this.imageInactivo = ImageIO.read(new File(IMAGENESPATH + "bloque-inactivo.png"));
            
            generarMapa();
        } catch (IOException ex) {
            Logger.getLogger(ContenedorJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        reiniciar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                reiniciar();
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
        });
    }
    
    public void reiniciar () {
        int[][] copy = Arrays.stream(MAPA_1).map(int[]::clone).toArray(int[][]::new);
        this.mapaLogico = copy;
        this.SubContenedor.removeAll();
        this.SubContenedor.revalidate();
        this.SubContenedor.repaint();
        this.mapaGrafico = null;
        this.mapaGrafico = new JPanel[FILAS_JUEGO][COLUMNAS_JUEGO];
        
        
        generarMapa();
    }
    

    public void mirarArriba() {
        mirar(0,-1);
    }
    
    public void mirarAbajo() {
        mirar(0,1);
    }
    
    public void mirarIzquierda() {
        mirar(-1,0);
    }
    
    public void mirarDerecha() {
        mirar(1,0);
    }
    
    public void mirar(int x,int y) {
        this.x = x;
        this.y = y;
    }
    
    public void avanzar (int pasos) {
        int [] p = getPosicion();
        if (verificarTrayectoria(p) && pasos > 0 && p[0] != -1) {
            actualizarGrafico(p[1],p[0],0);
            actualizarGrafico(p[1]+this.x,p[0]+this.y,5);
            avanzar(pasos-1);
        }
    }
    
    public void actualizarGrafico(int i, int j, int value){
        int tmp = j;
        j = i;
        i = tmp;
        mapaLogico[i][j] = value;
        ImageIcon ii;
        JLabel imagenInterna = (JLabel) mapaGrafico[i][j].getComponent(0);
        switch(value) {
                    case -2: {
                        imagenInterna.setIcon(new ImageIcon(this.imageInactivo));
                        break;
                    }
                    case -1: {
                        imagenInterna.setIcon(new ImageIcon(this.imageMuro));
                        break;
                    }
                    case 1: {
                        imagenInterna.setIcon(new ImageIcon(this.imageHielo));
                        break;
                    }
                    case 5: {
                        
                        imagenInterna.setIcon(new ImageIcon(this.imageJugador));
                        break;
                    }
                    case 0: {
                        imagenInterna.setIcon(new ImageIcon(this.imageAgua));
                        break;
                    }
                    default: {
                        imagenInterna.setIcon(new ImageIcon(this.imageLlegada));
                    }
                }
    }
    
    public boolean verificarTrayectoria(int [] p) {
        return mapaLogico[p[0]+this.y][p[1]+this.x] == 1;
    }
    
    public void ejecutarCambios()  {
        String []lineas = this.outputTextArea.getText().split("\n");
        for (int delay = 0; delay < lineas.length ; delay++) 
        { 
                final String  l = lineas[delay];
                Timer timer = new Timer((1000*delay), new ActionListener(){
                  @Override
                  public void actionPerformed( ActionEvent e ){
                      System.out.println("Delay:" + l);
                      ejecutarLinea(l);  
                  }
                } );
                timer.setRepeats( false );
                timer.start();
        }
    }
    
    public int[] getPosicion () {
        int [] pos = {-1,-1};
        for (int i=0; i < FILAS_JUEGO ; i++) {
            for (int j=0; j< COLUMNAS_JUEGO; j++) {
                if (mapaLogico[i][j] == 5) {
                    pos[0] = i;
                    pos[1] = j;
                    return pos;
                }
            }
        }    
        return pos;
    }
    
    
    
    public void generarMapa () {
        


        JPanel mapa = this.SubContenedor;
        mapa.setLayout(new GridLayout(FILAS_JUEGO,COLUMNAS_JUEGO));
        
        for (int i=0; i < FILAS_JUEGO ; i++) {
            for (int j=0; j< COLUMNAS_JUEGO; j++) {
                JPanel lo = new JPanel();
                Color p;              
                JLabel l;
                ImageIcon ii;
                switch(mapaLogico[i][j]) {
                    case -2: {
                        p = Color.yellow;
                        ii = new ImageIcon(this.imageInactivo);
                        break;
                    }
                    case -1: {
                        p = Color.blue;
                        ii = new ImageIcon(this.imageMuro);
                        break;
                    }
                    case 1: {
                        p = Color.red;
                        ii = new ImageIcon(this.imageHielo);
                        break;
                    }
                    case 5: {
                        ii = new ImageIcon(this.imageJugador);
                        p = Color.orange;
                        break;
                    }
                    default: {
                        p = new Color(i+j,i*j,i^j);
                        ii = new ImageIcon(this.imageLlegada);
                    }
                }
                
                
                    JLabel picLabel = new JLabel(ii);
                    picLabel.setSize(PIXEL, PIXEL);
                    picLabel.setBounds(0, 0, PIXEL,PIXEL);
                    picLabel.setPreferredSize(new Dimension(PIXEL,PIXEL));
                    lo.setLayout(null);
                    lo.add(picLabel);
                

                //lo.setBackground(p);
                //lo.setPreferredSize(new Dimension(PIXEL,PIXEL));
                //lo.setSize(PIXEL,PIXEL);
                this.mapaGrafico[i][j] = lo;
                mapa.add(lo);
            }
        }
    }

    public void ejecutarLinea(String linea) {
        switch(linea){
            case "mirarArriba()": {
                mirarArriba();
                break;
            }
            case "mirarAbajo()": {
                mirarAbajo();
                break;
            }
            case "mirarIzquierda()": {
                mirarIzquierda();
                break;
            }
            case "mirarDerecha()": {
                mirarDerecha();
                break;
            }
            default: {
                if(linea.matches("avanzar\\([0-9]+\\)")) {
                    linea = linea.replaceAll("[^0-9]", "");
                    final int pasos = Integer.parseInt(linea);
                    avanzar(pasos);
                } else {
                    System.out.println("ERROR:" + linea);
                }
                
            }
            
        }
    }
}
