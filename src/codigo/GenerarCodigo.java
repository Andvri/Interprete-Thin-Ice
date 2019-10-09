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
    
    public void llamarFuncion (String funcion, String parametros) {
        this.salida.add(funcion + "(" + parametros + ")");
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
                        NodoIdentificador nodo = ((NodoIdentificador)raiz);
                        ElementoTablaS elemId = tablaS.buscar(nodo.getIdentificador());
                        if (elemId.getIsVector()) {
                           return elemId.getValorVector( generarSalida(nodo.getIndiceVector(), tablaS) );
                        } else {
                            return elemId.getValor();
                        }
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
                                NodoAsignacion nodo = ((NodoAsignacion)raiz);
                                ElementoTablaS elemId = tablaS.buscar(nodo.getIdentificador());
                                String value = generarSalida(nodo.getAsignacion(), tablaS);
                                if (elemId.getIsVector()) {
                                    String posicion = generarSalida(nodo.getIndiceVector(), tablaS);
                                    tablaS.editarVector(((NodoAsignacion)raiz).getIdentificador(), value, posicion);
                                    ElementoTablaS nE =  tablaS.buscar(((NodoAsignacion)raiz).getIdentificador());
                                    System.out.println(nE.getIdentificador()+ "["+posicion+"]:=" + nE.getValor());
                                } else {
                                    
                                    tablaS.editar(((NodoAsignacion)raiz).getIdentificador(), value);
                                    ElementoTablaS nE =  tablaS.buscar(((NodoAsignacion)raiz).getIdentificador());
                                    System.out.println(nE.getIdentificador()+ ":=" + nE.getValor());
                                }
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
                                            if (raiz instanceof NodoFuncion) {
                                                NodoFuncion nodo = (NodoFuncion) raiz;
                                                llamarFuncion(nodo.getIdentificador(),generarSalida(nodo.getParametro(), tablaS));
                                            }
                                            else {
                                                if (raiz instanceof  NodoDefinicion){
                                                    NodoDefinicion nodo = ((NodoDefinicion)raiz);
                                                    if(nodo.getIndiceVector() != null){
                                                        ElementoTablaS elemId = tablaS.buscar(nodo.getIdentificador());
                                                        if (elemId != null) {
                                                            elemId.inicializarValorVector(generarSalida(nodo.getIndiceVector(), tablaS));
                                                            System.out.println(elemId.getIdentificador() + "[]:=" + elemId.getValor()  );
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
            
            
            //Recorrido de Arbol
            
            if (raiz instanceof  NodoPrograma){
              generarSalida(((NodoPrograma)raiz).getSegmento(), tablaS);
            }
            
            raiz = raiz.getHermanoD();
        }
        return null;
    }
    
    public Vector<String> getSalida() {
        return this.salida;
    }
    public String getImprimir() {
        return String.join("\n", this.salida);
    }
}
