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
    String valor;
    int tamVector;
    int numSent;

    public ElementoTablaS(String identificador){
        this.identificador = identificador;
        this.tipo = null;
        this.isVector = false;
    }

    public ElementoTablaS(String identificador, TiposIds tipo, int numSent){
        this.identificador = identificador;
        this.tipo = tipo;
        this.isVector = false;
        this.numSent = numSent;
        this.valor = (TiposIds.entero == tipo) ? "0" : "false";
    }

    public ElementoTablaS(String identificador, TiposIds tipo, int numSent, boolean isVector){
        this.identificador = identificador;
        this.tipo = tipo;
        this.isVector = isVector;
        this.numSent = numSent;
        this.valor = (TiposIds.entero == tipo) ? "0" : "false";
    }
    
    public String getIdentificador(){
        return identificador;
    }

    public void setIdentificador(String identificador){
        this.identificador = identificador;
    }

    public String getValor() {
        return valor;
    }
    
    public String getValorVector( String posicion) {
        String[] valueTmp = this.valor.split(",");
        return valueTmp[Integer.parseInt(posicion)];
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    public void setValor(String valor, String posicion) {
        String[] valueTmp = this.valor.split(",");
        valueTmp[Integer.parseInt(posicion)] = valor;
        this.valor = String.join(",", valueTmp);
    }
    
    public void inicializarValorVector(String cantidad) {
       String[] valores = new String[Integer.parseInt(cantidad)];
       for (int i = 0; i < valores.length; i ++) {
           valores[i] = (TiposIds.entero == tipo) ? "0" : "false";
       }
       
       this.valor = String.join(",", valores);
       
    }
    
    public TiposIds getTipo() {
        return tipo;
    }

    public void setTipo(TiposIds tipo) {
        this.tipo = tipo;
    }

    public boolean getIsVector() {
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

    public int getNumSent() {
        return numSent;
    }

    public void setNumSent(int numSent) {
        this.numSent = numSent;
    }
    
}
