/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import arbol.*;
import java.util.HashMap;
import javax.swing.JTextArea;

/**
 *
 * @author kvnsnchz
 */
public class TablaSimbolos {
    private HashMap<String, ElementoTablaS> tabla;
    static int numSent;
    
    public TablaSimbolos() {
        super();
        tabla = new HashMap<String, ElementoTablaS>();
        numSent = 0;
    }
    
     public void cargar(NodoBase raiz){
        while (raiz != null) {
            
            if (raiz instanceof  NodoDefinicion){
                NodoDefinicion nodoD = (NodoDefinicion)raiz; 
                insertar(nodoD.getIdentificador(), nodoD.getTipoDato(), nodoD.getIndiceVector(), numSent);
            }
            
            numSent++;
            
            if (raiz instanceof  NodoPrograma){
              cargar(((NodoPrograma)raiz).getSegmento());
            }
            else{
                if (raiz instanceof  NodoSi){
                    cargar(((NodoSi)raiz).getCondicion());
                    cargar(((NodoSi)raiz).getSegmento());

                    if(((NodoSi)raiz).getSino() != null){
                            cargar(((NodoSi)raiz).getSino());
                    }
                  }
                  else{ 
                      if (raiz instanceof  NodoPara){
                          cargar(((NodoPara)raiz).getInicializador());
                          cargar(((NodoPara)raiz).getPaso());
                          cargar(((NodoPara)raiz).getVerificacion());
                          cargar(((NodoPara)raiz).getSegmento());
                      }
                      else{ 
                          if (raiz instanceof  NodoRepita){
                              cargar(((NodoRepita)raiz).getSegmento());
                              cargar(((NodoRepita)raiz).getCondicion());
                          }
                          else{ 
                              if (raiz instanceof  NodoDefinicion){
                                if(((NodoDefinicion)raiz).getIndiceVector() != null){
                                   cargar(((NodoDefinicion)raiz).getIndiceVector());
                                }  
                              }
                              else{
                                if (raiz instanceof  NodoAsignacion){
                                  cargar(((NodoAsignacion)raiz).getAsignacion());
                                  if(((NodoAsignacion)raiz).getIndiceVector() != null){
                                   cargar(((NodoAsignacion)raiz).getIndiceVector());
                                  } 
                                }
                                else{ 
                                    if (raiz instanceof  NodoOperacion){
                                        if(((NodoOperacion)raiz).getOpI() != null){
                                            cargar(((NodoOperacion)raiz).getOpI());
                                        }
                                        
                                        cargar(((NodoOperacion)raiz).getOpD());
                                    }
                                    if (raiz instanceof  NodoIdentificador){
                                        if(((NodoIdentificador)raiz).getIndiceVector() != null){
                                            cargar(((NodoIdentificador)raiz).getIndiceVector());
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
    }
    
    public boolean insertar(String identificador, TiposIds tipo, NodoBase indiceVector, int numSent){
        ElementoTablaS elemento;
        
        if(tabla.containsKey(identificador)){
            return false;
        }else{
            if(indiceVector == null){
                elemento = new ElementoTablaS(identificador, tipo, numSent);
            }
            else{
                elemento = new ElementoTablaS(identificador, tipo, numSent, true);
            }
            
            tabla.put(identificador, elemento);
            return true;			
        }
    }
    
    public ElementoTablaS buscar(String identificador){
        return (ElementoTablaS)tabla.get(identificador);
    }
    
    public void imprimir(JTextArea txt){
        txt.append("Tabla de Simbolos\n");
        tabla.keySet().forEach((i) -> {
            txt.append("id: " + i + " tipo: " + tabla.get(i).getTipo() + " isVector: " + tabla.get(i).getIsVector() + " numSent: " + tabla.get(i).getNumSent() + "\n");
        });
    }
}
