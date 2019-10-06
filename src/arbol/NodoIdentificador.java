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
public class NodoIdentificador extends NodoBase{
    private String Identificador;
    private NodoBase IndiceVector;
    
    public NodoIdentificador(String Identificador) {
        super();
        this.Identificador = Identificador;
    }
    
    public NodoIdentificador(String Identificador, NodoBase IndiceVector) {
        super();
        this.Identificador = Identificador;
        this.IndiceVector = IndiceVector;
    }

    public NodoIdentificador() {
        super();
    }

    public String getIdentificador() {
        return Identificador;
    }
    
    public NodoBase getIndiceVector() {
        return IndiceVector;
    }
    
    public void setIndiceVector(NodoBase IndiceVector){
        this.IndiceVector = IndiceVector;
    }
}
