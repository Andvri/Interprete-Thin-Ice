/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.util.Vector;
import arbol.*;
import java.awt.Color;
import java.util.HashSet;
import javax.swing.JTextArea;

/**
 *
 * @author kvnsnchz
 */
public class Semantic {
    static Vector<String> errores;
    static int numSent;
    HashSet<String> tiposFunc;
    HashSet<String> operadoresArit;
    HashSet<String> operadoresLogi;
    
    public Semantic() {
        errores = new Vector<String>();
        numSent = 0;
        tiposFunc = new HashSet<String>();
        operadoresArit = new HashSet<String>();
        operadoresLogi = new HashSet<String>();
        
        for (TiposFunc t : TiposFunc.values()) {
            tiposFunc.add(t.name());
        }
        
        for (OperadoresLogicos t : OperadoresLogicos.values()) {
            operadoresLogi.add(t.name());
        }
        
        for (OperadoresAritmeticos t : OperadoresAritmeticos.values()) {
            operadoresArit.add(t.name());
        }
    }
    
    public void analizar(NodoBase raiz, TablaSimbolos tablaS) {
        
        while (raiz != null) {
            
            if (raiz instanceof  NodoAsignacion){
                NodoAsignacion nodo = (NodoAsignacion)raiz;
                ElementoTablaS elem = tablaS.buscar(nodo.getIdentificador());
                
                if(!(elem != null && elem.getNumSent() <= numSent)){
                    errores.add("La variable "+nodo.getIdentificador()+" no ha sido declarada.\n");
                }
                else{
                    if(elem.getIsVector() &&  nodo.getIndiceVector() == null){
                        errores.add("Uso incorrecto del vector "+((NodoAsignacion)raiz).getIdentificador()+" como variable simple.\n");
                    }
                    else{
                        if(!elem.getIsVector() &&  nodo.getIndiceVector() != null){
                            errores.add("Uso incorrecto de la variable simple "+((NodoAsignacion)raiz).getIdentificador()+" como vector.\n");
                        }
                    }
                    if(nodo.getAsignacion() instanceof NodoOperacion){
                        if(((NodoOperacion)nodo.getAsignacion()).getTipo() !=  elem.getTipo()){
                            errores.add("La variable " + nodo.getIdentificador() + " es de tipo " + elem.getTipo() + " no se le puede asignar un valor de tipo " + ((NodoOperacion)nodo.getAsignacion()).getTipo() + ".\n");
                        }
                    }
                    else{
                        if(nodo.getAsignacion() instanceof NodoIdentificador){
                            ElementoTablaS elemId = tablaS.buscar(((NodoIdentificador)nodo.getAsignacion()).getIdentificador()); 
                            
                            if(elemId != null && elemId.getNumSent() <= numSent){
                                if (elemId.getTipo() !=  elem.getTipo()) {
                                    errores.add("La variable " + nodo.getIdentificador() + " es de tipo " + elem.getTipo() + " no se le puede asignar un valor de tipo " + elemId.getTipo() + ".\n");
                                }
                            }
                        }
                        else{
                            if(nodo.getAsignacion() instanceof NodoNumero){
                                if(elem.getTipo() != TiposIds.entero){
                                    errores.add("La variable " + nodo.getIdentificador() + " es de tipo " + elem.getTipo() + " no se le puede asignar un valor de tipo entero.\n");
                                }
                            }
                            else{
                                if(nodo.getAsignacion() instanceof NodoBooleano){
                                    if(elem.getTipo() != TiposIds.logico){
                                        errores.add("La variable " + nodo.getIdentificador() + " es de tipo " + elem.getTipo() + " no se le puede asignar un valor de tipo logico.\n");
                                    }
                                }
                            }
                        }
                    }
                }
                
            }
            else{
                if(raiz instanceof NodoPara){
                    NodoPara nodo = (NodoPara)raiz;
                    
                    if(!(nodo.getInicializador() instanceof NodoAsignacion)){
                        errores.add("La inicializacion del ciclo para debe ser una asignacion.\n");
                    }
                    
                    if(!(nodo.getPaso() instanceof NodoAsignacion)){
                        errores.add("El paso del ciclo para debe ser una asignacion.\n");
                    }
                    
                    if(nodo.getVerificacion() instanceof NodoOperacion){
                        if(((NodoOperacion)nodo.getVerificacion()).getTipo() != TiposIds.logico){
                            errores.add("La verificacion del ciclo para debe ser una expresion logica.\n");
                        }
                    }
                    else{
                        if(nodo.getVerificacion() instanceof NodoIdentificador){
                            ElementoTablaS elemId = tablaS.buscar(((NodoIdentificador)nodo.getVerificacion()).getIdentificador()); 

                            if(elemId != null && elemId.getNumSent() <= numSent){
                                if (elemId.getTipo() !=  TiposIds.logico) {
                                    errores.add("La verificacion del ciclo para debe ser una expresion logica.\n");
                                }
                            }
                        }
                        else{
                            if(nodo.getVerificacion() instanceof NodoNumero){
                                errores.add("La verificacion del ciclo para debe ser una expresion logica.\n");
                            }
                        }
                    }
                }
                else{
                    if(raiz instanceof NodoFuncion){
                        NodoFuncion nodo = (NodoFuncion)raiz;
                        
                        if(!tiposFunc.contains(nodo.getIdentificador())){
                            errores.add("La funcion " + nodo.getIdentificador() + " no existe.\n");
                        }
                        
                    }
                    else{
                        if(raiz instanceof NodoRepita){
                            NodoRepita nodo = (NodoRepita)raiz;
                            if(nodo.getCondicion() instanceof NodoOperacion){
                                if(((NodoOperacion)nodo.getCondicion()).getTipo() != TiposIds.logico){
                                    errores.add("La condicion del ciclo repita debe ser una expresion logica.\n");
                                }
                            }
                            else{
                                if(nodo.getCondicion() instanceof NodoIdentificador){
                                    ElementoTablaS elemId = tablaS.buscar(((NodoIdentificador)nodo.getCondicion()).getIdentificador()); 

                                    if(elemId != null && elemId.getNumSent() <= numSent){
                                        if (elemId.getTipo() !=  TiposIds.logico) {
                                            errores.add("La condicion del ciclo repita debe ser una expresion logica.\n");
                                        }
                                    }
                                }
                                else{
                                    if(nodo.getCondicion() instanceof NodoNumero){
                                        errores.add("La condicion del ciclo repita debe ser una expresion logica.\n");
                                    }
                                }
                            }
                        }
                        else{
                             if(raiz instanceof NodoSi){
                                NodoSi nodo = (NodoSi)raiz;
                                
                                if(nodo.getCondicion() instanceof NodoOperacion){
                                    if(((NodoOperacion)nodo.getCondicion()).getTipo() != TiposIds.logico){
                                        errores.add("La condicion del si debe ser una expresion logica.\n");
                                    }
                                }
                                else{
                                    if(nodo.getCondicion() instanceof NodoIdentificador){
                                        ElementoTablaS elemId = tablaS.buscar(((NodoIdentificador)nodo.getCondicion()).getIdentificador()); 

                                        if(elemId != null && elemId.getNumSent() <= numSent){
                                            if (elemId.getTipo() !=  TiposIds.logico) {
                                                errores.add("La condicion del si debe ser una expresion logica.\n");
                                            }
                                        }
                                    }
                                    else{
                                        if(nodo.getCondicion() instanceof NodoNumero){
                                            errores.add("La condicion del si debe ser una expresion logica.\n");
                                        }
                                    }
                                }
                            //Falta la verificacion de la condicion cuando es un elemento simple
                            } else {
                                if (raiz instanceof NodoOperacion) {
                                    NodoOperacion nodo = (NodoOperacion)raiz;
                                    
                                    String tipoD =  nodo.getOpD() != null && nodo.getOpD() instanceof NodoOperacion 
                                                    ? ((NodoOperacion) nodo.getOpD()).getTipo().toString()
                                                    : nodo.getTipo().toString();
                                    
                                    String tipoI =  nodo.getOpI() != null && nodo.getOpI() instanceof NodoOperacion 
                                                    ? ((NodoOperacion) nodo.getOpI()).getTipo().toString()
                                                    : nodo.getTipo().toString();
                                    
                                    String tipoP = nodo.getTipo().toString();
                                    
                                    
                                    if ((tipoI != tipoP || tipoD != tipoP) && nodo.getOperacion().toString() != "Diferencia")
                                    {
                                        errores.add(
                                            "El tipo de operacion: "
                                            + nodo.getTipo().toString().toUpperCase()
                                            + " "
                                            + nodo.getOperacion().toString() 
                                            +" Recibio una operación "
                                            + tipoD.toUpperCase() 
                                            + " y una operación "
                                            + tipoI.toUpperCase() +
                                            ".\n"
                                        );
                                    }
                                    
                                    if (nodo.getOperacion().toString() == "Diferencia" && tipoI != tipoD) {
                                       errores.add(
                                            "La diferencia solo admite ambas operaciones"
                                            + " Enteras o Logicas. recibio:"
                                            + tipoI.toUpperCase() 
                                            + " y "
                                            + tipoD.toUpperCase() 
                                            +".\n"
                                        );
                                    }
                                }
                                else{
                                    if(raiz instanceof NodoIdentificador){
                                        ElementoTablaS elemId = tablaS.buscar(((NodoIdentificador)raiz).getIdentificador());
                                        if(elemId != null && elemId.getNumSent() <= numSent){
                                            if(elemId.getIsVector() &&  ((NodoIdentificador)raiz).getIndiceVector() == null ){
                                                errores.add("Uso incorrecto del vector "+((NodoIdentificador)raiz).getIdentificador()+" como variable simple.\n");
                                            }
                                            else{
                                                if(!elemId.getIsVector() &&  ((NodoIdentificador)raiz).getIndiceVector() != null){
                                                    errores.add("Uso incorrecto de la variable simple "+((NodoIdentificador)raiz).getIdentificador()+" como vector.\n");
                                                }
                                            }
                                        }
                                        else{
                                            errores.add("La variable " + ((NodoIdentificador)raiz).getIdentificador() + " no ha sido declarada.\n");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
                          
            numSent++;
            
            if (raiz instanceof  NodoPrograma){
              analizar(((NodoPrograma)raiz).getSegmento(), tablaS);
            }
            else{
                 if (raiz instanceof  NodoSi){
                    analizar(((NodoSi)raiz).getCondicion(), tablaS);
                    analizar(((NodoSi)raiz).getSegmento(), tablaS);

                    if(((NodoSi)raiz).getSino() != null){
                            analizar(((NodoSi)raiz).getSino(), tablaS);
                    }
                  }
                 else{ 
                      if (raiz instanceof  NodoPara){
                          analizar(((NodoPara)raiz).getInicializador(), tablaS);
                          analizar(((NodoPara)raiz).getPaso(), tablaS);
                          analizar(((NodoPara)raiz).getVerificacion(), tablaS);
                          analizar(((NodoPara)raiz).getSegmento(), tablaS);
                      }
                      else{ 
                          if (raiz instanceof  NodoRepita){
                              analizar(((NodoRepita)raiz).getSegmento(), tablaS);
                              analizar(((NodoRepita)raiz).getCondicion(), tablaS);
                          }
                          else{ 
                              if (raiz instanceof  NodoDefinicion){
                                if(((NodoDefinicion)raiz).getIndiceVector() != null){
                                   analizar(((NodoDefinicion)raiz).getIndiceVector(), tablaS);
                                }  
                              }
                              else{
                                if (raiz instanceof  NodoAsignacion){
                                  analizar(((NodoAsignacion)raiz).getAsignacion(), tablaS);
                                  
                                  if(((NodoAsignacion)raiz).getIndiceVector() != null){
                                   analizar(((NodoAsignacion)raiz).getIndiceVector(), tablaS);
                                  } 
                                }
                                else{ 
                                    if (raiz instanceof  NodoOperacion){
                                        if(((NodoOperacion)raiz).getOpI() != null){
                                            analizar(((NodoOperacion)raiz).getOpI(), tablaS);
                                        }
                                        
                                        analizar(((NodoOperacion)raiz).getOpD(), tablaS);
                                    }
                                    else{
                                        if (raiz instanceof  NodoIdentificador){
                                            if(((NodoIdentificador)raiz).getIndiceVector() != null){
                                                analizar(((NodoIdentificador)raiz).getIndiceVector(), tablaS);
                                            } 
                                        }
                                        else{
                                            if (raiz instanceof  NodoFuncion){
                                                if(((NodoFuncion)raiz).getParametro() != null){
                                                    analizar(((NodoFuncion)raiz).getParametro(), tablaS);
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
    }
    
    public void imprimir(JTextArea txt){
        txt.setText("");
        
        if(errores.size() == 0){
            txt.setText("Analisis Realizado con Exito");
            txt.setForeground(new Color(25, 111, 61));
        }
        else{
            for(int i=0; i<errores.size(); i++){
                txt.append(errores.get(i));
            }
            
            txt.setForeground(Color.red);
        }
    }
}
