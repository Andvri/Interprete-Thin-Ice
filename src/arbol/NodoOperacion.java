/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

import codigo.Tokens;

/**
 *
 * @author kvnsnchz
 */

public class NodoOperacion extends NodoBase {
    private NodoBase OpI;
    private NodoBase OpD;
    private Tokens Operacion;

    public NodoOperacion(NodoBase OpI, Tokens Operacion, NodoBase OpD) {
            super();
            this.OpI = OpI;
            this.OpD = OpD;
            this.Operacion = Operacion;
    }
    
    public NodoOperacion(Tokens Operacion, NodoBase OpD) {
            super();
            this.OpI = null;
            this.OpD = OpD;
            this.Operacion = Operacion;
    }
    
    public NodoOperacion() {
            super();
            this.OpI = null;
            this.OpD = null;
            this.Operacion = null;
    }

    public NodoBase getOpI() {
            return OpI;
    }

    public void setOpI(NodoBase OpI) {
            this.OpI = OpI;
    }

    public NodoBase getOpD() {
            return OpD;
    }

    public void setOpD(NodoBase OpD) {
            this.OpD = OpD;
    }

    public Tokens getOperacion() {
            return Operacion;
    }
}
