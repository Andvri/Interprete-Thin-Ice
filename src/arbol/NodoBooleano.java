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
public class NodoBooleano extends NodoBase {
    public String valor;

    public NodoBooleano(String valor) {
        super();
        this.valor = valor;
    }
    
    public NodoBooleano() {
        super();
        this.valor = null;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
     
}