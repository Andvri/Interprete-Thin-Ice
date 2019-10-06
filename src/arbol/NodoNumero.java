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
    private int Numero;

    public NodoNumero(String Numero) {
        super();
        this.Numero = Integer.parseInt(Numero);
    }
    public NodoNumero(int Numero) {
        super();
        this.Numero = Numero;
    }

    public NodoNumero() {
        super();
    }

    public int getNumero() {
        return Numero;
    }
}
