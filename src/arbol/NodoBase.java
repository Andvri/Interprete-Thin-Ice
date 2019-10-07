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
public class NodoBase {
    private NodoBase HermanoD;

    public NodoBase(NodoBase HermanoD) {
        super();
        this.HermanoD = HermanoD;
    }

    public NodoBase() {
        super();
        HermanoD=null;
    }

    public NodoBase getHermanoD() {
        return HermanoD;
    }

    public void setHermanoD(NodoBase HermanoD) {
        this.HermanoD = HermanoD;
    }

    public boolean withoutHermanoD() {
        return (HermanoD == null);
    }
}
