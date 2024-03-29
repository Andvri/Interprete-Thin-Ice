/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

/**
 *
 * @author andvri
 */
public interface Constantes {
   public int PIXEL = 30;
   public int ANCHO_JUEGO = 19;
   public int ANCHO_CODIGO = 10;
   public int ALTO = 17;
   
   public int COLUMNAS_JUEGO = 19;
   public int FILAS_JUEGO = 15;
   
   
   public String PROJECTPATH = System.getProperty("user.dir");
   public String IMAGENESPATH = PROJECTPATH + "/src/recursos/imagenes/";
   
   
   public int ANCHO_CONTENEDOR_CODIGO = PIXEL * ANCHO_CODIGO;
   public int ANCHO_CONTENEDOR_JUEGO = PIXEL * ANCHO_JUEGO;
   
   public int ALTO_VENTANA = PIXEL * ALTO;
   public int ANCHO_VENTANA = ANCHO_CONTENEDOR_CODIGO + ANCHO_CONTENEDOR_JUEGO;
   
   
   public final int [][] MAPA_1 = {
        {-2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2},
{-2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2},
{-2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2},
{-1, -1, -1, -1, -1, -2, -2, -2, -1, -1, -1, -1, -1, -2, -2, -2, -2, -2, -2},
{-1,  1,  1,  1, -1, -1, -1, -1, -1,  1,  1,  1, -1, -2, -2, -2, -2, -2, -2},
{-1,  1, -1,  1, -1, -1,  5, -1, -1,  1, -1,  1, -1, -2, -2, -2, -2, -2, -2},
{-1,  1,  1,  2,  1,  1,  2,  1,  1,  2,  1,  1, -1, -1, -1, -1, -2, -2, -2},
{-1, -1, -1,  1, -1, -1,  1, -1, -1,  1, -1, -1, -1, -1,  4, -1, -2, -2, -2},
{-2, -1, -1,  1, -1, -1,  1, -1, -1,  1, -1, -1, -1, -1,  1, -1, -1, -2, -2},
{-2, -1,  1,  1,  1,  1,  2,  1,  1,  2,  1,  1, -1, -1,  1, -1, -1, -2, -2},
{-2, -1,  1,  1,  1, -1,  1, -1, -1,  1, -1,  1, -1,  1,  1,  1, -1, -2, -2},
{-2, -1,  1,  1,  1,  1,  1, -1, -1,  1,  1,  1, -1,  1, -1, -1, -1, -2, -2},
{-2, -1,  1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  1,  1,  1, -1, -2, -2},
{-2, -1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, -1, -2, -2},
{-2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -2, -2}
    };
}
