/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

/**
 *
 * @author kvnsnchz
 */
public class NodoPrograma extends NodoBase{
    private NodoBase Segmento;
    
     public NodoPrograma(NodoBase Segmento) {
        super();
        this.Segmento = Segmento;
    }

    public NodoPrograma() {
        super();
        this.Segmento = null;		
    }
    
    public NodoBase getSegmento() {
        return Segmento;
    }

    public void setSegmento(NodoBase Segmento) {
        this.Segmento = Segmento;
    }
}
