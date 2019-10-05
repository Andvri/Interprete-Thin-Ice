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
public class NodoNumero extends NodoBase{
    private int numero;

    public NodoNumero(String numero) {
        super();
        this.numero = Integer.parseInt(numero);
    }
    public NodoNumero(int numero) {
        super();
        this.numero = numero;
    }

    public NodoNumero() {
        super();
    }

    public int getNumero() {
        return numero;
    }
}
