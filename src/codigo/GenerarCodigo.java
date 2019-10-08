/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import arbol.*;
import java.util.Vector;

/**
 *
 * @author andvri
 */
public class GenerarCodigo {
    static Vector<String> salida;
    
    
    public GenerarCodigo () {
        this.salida = new Vector<String>();
    }
    
    
    public String calcularOperacion (Tokens ope, String valorI, String valorD){
        
        if (ope == Tokens.Suma) {
            return  "" +(Integer.parseInt(valorI) + Integer.parseInt(valorD));
        } 
        else {
            if (ope == Tokens.Resta) {
                return  "" +(Integer.parseInt(valorI) - Integer.parseInt(valorD));
            }
            else {
                if (ope == Tokens.Multiplicacion) {
                    return  "" +(Integer.parseInt(valorI) * Integer.parseInt(valorD));
                }
                else {
                    if (ope == Tokens.Division) {
                        return  "" +(Integer.parseInt(valorI) / Integer.parseInt(valorD));
                    }
                    else {
                        if (ope == Tokens.Modulo) {
                            return  "" +(Integer.parseInt(valorI) % Integer.parseInt(valorD));
                        }
                        else {
                            if (ope == Tokens.Menor) {
                                return  (Integer.parseInt(valorI) < Integer.parseInt(valorD))
                                        ? "true" 
                                        : "false";
                            }
                            else {
                                if (ope == Tokens.Menor_igual) {
                                    return  (Integer.parseInt(valorI) <= Integer.parseInt(valorD))
                                        ? "true" 
                                        : "false";
                                } 
                                else {
                                    if (ope == Tokens.Mayor) {
                                        return  (Integer.parseInt(valorI) > Integer.parseInt(valorD))
                                            ? "true" 
                                            : "false";
                                    } 
                                    else {
                                        if (ope == Tokens.Mayor_igual) {
                                            return  (Integer.parseInt(valorI) >= Integer.parseInt(valorD))
                                                ? "true" 
                                                : "false";
                                        } 
                                        else {
                                            if (ope == Tokens.Igual) {
                                                String r = null;
                                                try { 
                                                    r = (Integer.parseInt(valorI) == Integer.parseInt(valorD))
                                                    ? "true" 
                                                    : "false";
                                                } catch(NumberFormatException e) { 
                                                    r = (Boolean.parseBoolean(valorI) == Boolean.parseBoolean(valorD))
                                                    ? "true" 
                                                    : "false";
                                                }
                                                
                                                return  r;
                                            } 
                                            else {
                                                if (ope == Tokens.Diferencia) {
                                                    String r = null;
                                                    try { 
                                                        r = (Integer.parseInt(valorI) == Integer.parseInt(valorD))
                                                        ? "true" 
                                                        : "false";
                                                    } catch(NumberFormatException e) { 
                                                        r = (Boolean.parseBoolean(valorI) == Boolean.parseBoolean(valorD))
                                                        ? "true" 
                                                        : "false";
                                                    }
                                                    return r;
                                                }
                                                else {
                                                    if (ope == Tokens.Y_logico) {
                                                        return (Boolean.parseBoolean(valorI) && Boolean.parseBoolean(valorD))
                                                        ? "true" 
                                                        : "false";
                                                    }
                                                    else {
                                                        if (ope == Tokens.O_logico) {
                                                            return (Boolean.parseBoolean(valorI) || Boolean.parseBoolean(valorD))
                                                            ? "true" 
                                                            : "false";
                                                        }
                                                        else {
                                                            if (ope == Tokens.Negacion_logica) {
                                                                return (!Boolean.parseBoolean(valorD))
                                                                ? "true" 
                                                                : "false";
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return null;
    }
    
    public String generarSalida(NodoBase raiz, TablaSimbolos tablaS) {
        while (raiz != null) {
            if (raiz instanceof  NodoBooleano ){
                return ((NodoBooleano) raiz).getValor();
            } else {
                if (raiz instanceof  NodoNumero ){
                    return "" + ((NodoNumero) raiz).getNumero();
                }
                else {
                    if (raiz instanceof NodoIdentificador) {
                        ElementoTablaS elemId = tablaS.buscar(((NodoIdentificador)raiz).getIdentificador());
                        return elemId.valor;
                    }
                    else {
                        if (raiz instanceof NodoOperacion) {
                            NodoOperacion nodo  = (NodoOperacion) raiz;
                            String valorI = null;
                            String valorD = null;
                            
                            if (nodo.getOpI() != null) {
                                 valorI = generarSalida(nodo.getOpI(), tablaS);
                            }
                            
                            valorD = generarSalida(nodo.getOpD(), tablaS);
                            String value = this.calcularOperacion(nodo.getOperacion(), valorI, valorD);
                            System.out.println(valorI + " " + nodo.getOperacion()+ " " +  valorD + "= " +value);
                            return value;
                        }
                        else {
                            if (raiz instanceof NodoAsignacion) {
                                String value = generarSalida(((NodoAsignacion)raiz).getAsignacion(), tablaS);
                                tablaS.editar(((NodoAsignacion)raiz).getIdentificador(), value);
                                ElementoTablaS nE =  tablaS.buscar(((NodoAsignacion)raiz).getIdentificador());
                                System.out.println(nE.getIdentificador()+ ":=" + nE.getValor());
                            }
                            else {
                                if (raiz instanceof NodoSi) {
                                    
                                    NodoSi nodo = (NodoSi) raiz;        
                                    
                                    if (Boolean.parseBoolean(generarSalida(nodo.getCondicion(),tablaS))) {
                                        generarSalida(nodo.getSegmento(), tablaS);
                                    } else {
                                        if (nodo.getSino() != null){
                                            generarSalida(nodo.getSino(), tablaS);
                                        }
                                    }
                                }
                                else {
                                    if (raiz instanceof NodoPara) {
                                        NodoPara nodo = (NodoPara) raiz;        
                                        generarSalida(nodo.getInicializador(), tablaS);
                                        
                                        while (Boolean.parseBoolean(generarSalida(nodo.getVerificacion(), tablaS))) {
                                            generarSalida(nodo.getSegmento(), tablaS);
                                            generarSalida(nodo.getPaso(),tablaS);
                                        }
                                    }
                                    else {
                                        if (raiz instanceof NodoRepita) {
                                            NodoRepita nodo = (NodoRepita) raiz;
                                            do {
                                                generarSalida(nodo.getSegmento(), tablaS);
                                            } while (Boolean.parseBoolean(generarSalida(nodo.getCondicion(), tablaS)));
                                        }
                                        else {
                                            if (raiz instanceof NodoDefinicion) {
                                                
                                            }
                                        }
                                    } 
                                }
                            }
                        }
                    }
                }
               
            }
            
            
            //Recorrido de Arbol
            
            if (raiz instanceof  NodoPrograma){
              generarSalida(((NodoPrograma)raiz).getSegmento(), tablaS);
            }
            else{
                 if (raiz instanceof  NodoSi){
                    /*generarSalida(((NodoSi)raiz).getCondicion(), tablaS);
                    generarSalida(((NodoSi)raiz).getSegmento(), tablaS);

                    if(((NodoSi)raiz).getSino() != null){
                            generarSalida(((NodoSi)raiz).getSino(), tablaS);
                    }*/
                  }
                 else{ 
                      if (raiz instanceof  NodoPara){
                          /*generarSalida(((NodoPara)raiz).getInicializador(), tablaS);
                          generarSalida(((NodoPara)raiz).getPaso(), tablaS);
                          generarSalida(((NodoPara)raiz).getVerificacion(), tablaS);
                          generarSalida(((NodoPara)raiz).getSegmento(), tablaS);*/
                      }
                      else{ 
                          if (raiz instanceof  NodoRepita){
                              /*generarSalida(((NodoRepita)raiz).getSegmento(), tablaS);
                              generarSalida(((NodoRepita)raiz).getCondicion(), tablaS);*/
                          }
                          else{ 
                              if (raiz instanceof  NodoDefinicion){
                                if(((NodoDefinicion)raiz).getIndiceVector() != null){
                                   generarSalida(((NodoDefinicion)raiz).getIndiceVector(), tablaS);
                                }  
                              }
                              else{
                                if (raiz instanceof  NodoAsignacion){
                            /*      generarSalida(((NodoAsignacion)raiz).getAsignacion(), tablaS);
                                  
                                  if(((NodoAsignacion)raiz).getIndiceVector() != null){
                                   generarSalida(((NodoAsignacion)raiz).getIndiceVector(), tablaS);
                                  } */
                                }
                                else{ 
                                    if (raiz instanceof  NodoOperacion){
                                        /*if(((NodoOperacion)raiz).getOpI() != null){
                                            generarSalida(((NodoOperacion)raiz).getOpI(), tablaS);
                                        }
                                        
                                        generarSalida(((NodoOperacion)raiz).getOpD(), tablaS);*/
                                    }
                                    else{
                                        if (raiz instanceof  NodoIdentificador){
                                            if(((NodoIdentificador)raiz).getIndiceVector() != null){
                                                generarSalida(((NodoIdentificador)raiz).getIndiceVector(), tablaS);
                                            } 
                                        }
                                        else{
                                            if (raiz instanceof  NodoFuncion){
                                                if(((NodoFuncion)raiz).getParametro() != null){
                                                    generarSalida(((NodoFuncion)raiz).getParametro(), tablaS);
                                                } 
                                            }
                                        }
                                    }
                                }
                              }
                              
                          }
                      }
                  }
            }
            
            raiz = raiz.getHermanoD();
        }
        return null;
    }
    
    public Vector<String> getSalida() {
        return this.salida;
    }
}
