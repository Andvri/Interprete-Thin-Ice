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
    private String identificador;

    public NodoIdentificador(String identificador) {
        super();
        this.identificador = identificador;
    }

    public NodoIdentificador() {
        super();
    }

    public String getIdentificador() {
        return identificador;
    }
}
