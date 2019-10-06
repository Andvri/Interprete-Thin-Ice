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
public class NodoDefinicion extends NodoBase{
    private String Identificador;
    private String TipoVariable;
    private NodoBase IndiceVector;

    public NodoDefinicion(String Identificador, String TipoVariable) {
        super();
        this.Identificador = Identificador;
        this.TipoVariable = TipoVariable;
        this.IndiceVector = null;
    }
    
    public NodoDefinicion(String Identificador, String TipoVariable, NodoBase IndiceVector) {
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
    
    public String getTipoDato() {
        return TipoVariable;
    }
    
    public void setTipoDato(String TipoVariable) {
       this.TipoVariable = TipoVariable;
    }
    
    public NodoBase getIndiceVector() {
        return IndiceVector;
    }
    
    public void setIndiceVector(NodoBase IndiceVector){
        this.IndiceVector = IndiceVector;
    }
}
