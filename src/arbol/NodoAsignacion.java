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
    private String identificador;
    private NodoBase asignacion;

    public NodoAsignacion(String identificador) {
        super();
        this.identificador = identificador;
        this.asignacion = null;
    }

    public NodoAsignacion(String identificador, NodoBase asignacion) {
        super();
        this.identificador = identificador;
        this.asignacion = asignacion;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public NodoBase getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(NodoBase asignacion) {
        this.asignacion = asignacion;
    }
}
