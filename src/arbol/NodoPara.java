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
public class NodoPara extends NodoBase {
    private NodoBase Inicializador;
    private NodoBase Paso;
    private NodoBase Verificacion;
    private NodoBase Segmento;

    public NodoPara(NodoBase Inicializador, NodoBase Paso, NodoBase Verificacion, NodoBase Segmento) {
        super();
        this.Inicializador = Inicializador;
        this.Paso = Paso;
        this.Verificacion = Verificacion;
        this.Segmento = Segmento;
    }

    public NodoPara() {
        super();
        this.Inicializador = null;
        this.Paso = null;
        this.Verificacion = null;
        this.Segmento = null;		
    }

    public NodoBase getInicializador() {
        return Inicializador;
    }

    public void setInicializador(NodoBase Inicializador) {
        this.Inicializador = Inicializador;
    }

    public NodoBase getPaso() {
        return Paso;
    }

    public void setPaso(NodoBase Paso) {
        this.Paso = Paso;
    }

    public NodoBase getVerificacion() {
        return Verificacion;
    }

    public void setVerificacion(NodoBase Verificacion) {
        this.Verificacion = Verificacion;
    }

    public NodoBase getSegmento() {
        return Segmento;
    }

    public void setSegmento(NodoBase Segmento) {
        this.Segmento = Segmento;
    }
}
