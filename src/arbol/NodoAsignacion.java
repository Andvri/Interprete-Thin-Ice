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
public class NodoAsignacion extends NodoBase{
    private String Identificador;
    private NodoBase Asignacion;

    public NodoAsignacion(String Identificador) {
        super();
        this.Identificador = Identificador;
        this.Asignacion = null;
    }

    public NodoAsignacion(String Identificador, NodoBase Asignacion) {
        super();
        this.Identificador = Identificador;
        this.Asignacion = Asignacion;
    }

    public String getIdentificador() {
        return Identificador;
    }

    public void setIdentificador(String Identificador) {
        this.Identificador = Identificador;
    }

    public NodoBase getAsignacion() {
        return Asignacion;
    }

    public void setAsignacion(NodoBase Asignacion) {
        this.Asignacion = Asignacion;
    }
}
