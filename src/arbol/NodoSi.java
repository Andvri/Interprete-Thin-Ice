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
public class NodoSi extends NodoBase{
    private NodoBase Condicion;
    private NodoBase Segmento;
    private NodoBase Sino;

    public NodoSi(NodoBase Condicion, NodoBase Segmento) {
        super();
        this.Condicion = Condicion;
        this.Segmento = Segmento;
        this.Sino = null;
    }

    public NodoSi(NodoBase Condicion, NodoBase Segmento, NodoBase Sino) {
        super();
        this.Condicion = Condicion;
        this.Segmento = Segmento;
        this.Sino = Sino;
    }

    public NodoSi() {
        super();
        this.Condicion = null;
        this.Segmento = null;
        this.Sino = null;		
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

    public NodoBase getSino() {
        return Sino;
    }

    public void setSino(NodoBase Sino) {
        this.Sino = Sino;
    }
}
