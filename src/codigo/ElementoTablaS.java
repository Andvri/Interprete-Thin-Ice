/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

/**
 *
 * @author kvnsnchz
 */
public class ElementoTablaS {
    String identificador;
    TiposIds tipo;
    boolean isVector;
    int valor;
    int tamVector;
    

    public ElementoTablaS(String identificador){
        this.identificador = identificador;
        this.tipo = null;
        this.isVector = false;
    }

    public ElementoTablaS(String identificador, TiposIds tipo){
        this.identificador = identificador;
        this.tipo = tipo;
        this.isVector = false;
    }

    public ElementoTablaS(String identificador, TiposIds tipo, boolean isVector){
        this.identificador = identificador;
        this.tipo = tipo;
        this.isVector = isVector;
    }
    
    public String getIdentificador(){
        return identificador;
    }

    public void setIdentificador(String identificador){
        this.identificador = identificador;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public TiposIds getTipo() {
        return tipo;
    }

    public void setTipo(TiposIds tipo) {
        this.tipo = tipo;
    }

    public boolean isIsVector() {
        return isVector;
    }

    public void setIsVector(boolean isVector) {
        this.isVector = isVector;
    }

    public int getTamVector() {
        return tamVector;
    }

    public void setTamVector(int tamVector) {
        this.tamVector = tamVector;
    }
}
