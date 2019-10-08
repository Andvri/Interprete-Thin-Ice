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
public class NodoFuncion extends NodoBase{
    private String Identificador;
    private NodoBase Parametro;

    public NodoFuncion(String Identificador, NodoBase Parametro) {
        super();
        this.Identificador = Identificador;
        this.Parametro = Parametro;
    }
    
    public NodoFuncion(String Identificador) {
        super();
        this.Identificador = Identificador;
        this.Parametro = null;
    }
    
    public NodoFuncion() {
        super();
        this.Identificador = null;
        this.Parametro = null;
    }

    public String getIdentificador() {
        return Identificador;
    }

    public void setIdentificador(String Identificador) {
        this.Identificador = Identificador;
    }

    public NodoBase getParametro() {
        return Parametro;
    }

    public void setParametro(NodoBase Parametro) {
        this.Parametro = Parametro;
    }
    
}
