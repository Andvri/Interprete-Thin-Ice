/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

import codigo.TiposIds;

/**
 *
 * @author kvnsnchz
 */
public class NodoDefinicion extends NodoBase{
    private String Identificador;
    private TiposIds TipoVariable;
    private NodoBase IndiceVector;

    public NodoDefinicion(String Identificador, TiposIds TipoVariable) {
        super();
        this.Identificador = Identificador;
        this.TipoVariable = TipoVariable;
        this.IndiceVector = null;
    }
    
    public NodoDefinicion(String Identificador, TiposIds TipoVariable, NodoBase IndiceVector) {
        super();
        this.Identificador = Identificador;
        this.TipoVariable = TipoVariable;
        this.IndiceVector = IndiceVector;
    }
    
    public NodoDefinicion() {
        super();
        this.Identificador = null;
        this.TipoVariable = null;
        this.IndiceVector = null;
    }

    public String getIdentificador() {
        return Identificador;
    }

    public void setIdentificador(String Identificador) {
        this.Identificador = Identificador;
    }
    
    public TiposIds getTipoDato() {
        return TipoVariable;
    }
    
    public void setTipoDato(TiposIds TipoVariable) {
       this.TipoVariable = TipoVariable;
    }
    
    public NodoBase getIndiceVector() {
        return IndiceVector;
    }
    
    public void setIndiceVector(NodoBase IndiceVector){
        this.IndiceVector = IndiceVector;
    }
}
