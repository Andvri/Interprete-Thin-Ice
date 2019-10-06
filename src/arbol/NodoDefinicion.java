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
    private boolean IsVector;

    public NodoDefinicion(String Identificador, String TipoVariable) {
        super();
        this.Identificador = Identificador;
        this.TipoVariable = TipoVariable;
        this.IsVector = false;
    }
    
    public NodoDefinicion(String Identificador, String TipoVariable, boolean IsVector) {
        super();
        this.Identificador = Identificador;
        this.TipoVariable = TipoVariable;
        this.IsVector = IsVector;
    }
    
    public NodoDefinicion() {
        super();
        this.Identificador = null;
        this.TipoVariable = null;
        this.IsVector = false;
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
    
    public boolean getIsVector() {
        return IsVector;
    }
    
    public void setIsVector(boolean IsVector){
        this.IsVector = IsVector;
    }
}
