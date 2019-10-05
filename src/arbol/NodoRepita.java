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
public class NodoRepita extends NodoBase {
    private NodoBase Condicion;
    private NodoBase Segmento;

    public NodoRepita(NodoBase Condicion, NodoBase Segmento) {
        super();
        this.Condicion = Condicion;
        this.Segmento = Segmento;
    }

    public NodoRepita() {
        super();
        this.Condicion = null;
        this.Segmento = null;		
    }

    public NodoBase getCondicion() {
        return Condicion;
    }

    public void setCondicion(NodoBase Condicion) {
        this.Condicion = Condicion;
    }

    public NodoBase getSegmento() {
            return Segmento;
    }

    public void setSegmento(NodoBase Segmento) {
            this.Segmento = Segmento;
    }
}
