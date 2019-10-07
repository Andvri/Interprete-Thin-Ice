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
    private Vector<String> errores;
    static int numSent;
    HashSet<String> tiposFunc;
    
    public Semantic() {
        errores = new Vector<String>();
        numSent = 0;
        tiposFunc = new HashSet<String>();
        
        for (TiposFunc t : TiposFunc.values()) {
            tiposFunc.add(t.name());
        }
    }
    
    public void analizar(NodoBase raiz, TablaSimbolos tablaS) {
        errores.clear();
        
        while (raiz != null) {
            
            if (raiz instanceof  NodoAsignacion){
                NodoAsignacion nodo = (NodoAsignacion)raiz;
                ElementoTablaS elem = tablaS.buscar(nodo.getIdentificador());
                
                if(!(elem != null && elem.getNumSent() <= numSent)){
                    errores.add("La variable "+nodo.getIdentificador()+" no ha sido declarada.");
                }
                else{
                    if(elem != null && elem.getIsVector() &&  nodo.getIndiceVector() == null){
                        errores.add("Uso incorrecto del vector "+((NodoAsignacion)raiz).getIdentificador()+" como variable simple.");
                    }
                    else{
                        if(elem != null && !elem.getIsVector() &&  nodo.getIndiceVector() != null){
                            errores.add("Uso incorrecto de la variable simple "+((NodoAsignacion)raiz).getIdentificador()+" como vector.");
                        }
                    }
                }
                
                //Falta verificacion del tipo cuando se asigna
            }
            else{
                if(raiz instanceof NodoPara){
                    NodoPara nodo = (NodoPara)raiz;
                    
                    if(!(nodo.getInicializador() instanceof NodoAsignacion)){
                        errores.add("La inicializacion del ciclo para debe ser una asignacion");
                    }
                    
                    if(!(nodo.getPaso()instanceof NodoAsignacion)){
                        errores.add("El paso del ciclo para debe ser una asignacion");
                    }
                    
                    //Falta la verificacion de la verificacion
                }
                else{
                    if(raiz instanceof NodoFuncion){
                        NodoFuncion nodo = (NodoFuncion)raiz;
                        
                        if(!tiposFunc.contains(nodo.getIdentificador())){
                            errores.add("La funcion " + nodo.getIdentificador() + " no existe.");
                        }
                        
                    }
                    else{
                        if(raiz instanceof NodoSi){
                            NodoSi nodo = (NodoSi)raiz;
                            if(((NodoOperacion)nodo.getCondicion()).getTipo() != TiposIds.logico){
                                errores.add("La condicion del si debe ser una expresion logica.");
                            }
                        }
                    }
                }
            }
                          
            numSent++;
            
            if (raiz instanceof  NodoPrograma){
              analizar(((NodoPrograma)raiz).getSegmento(), tablaS);
            }
            //falta hacer la recursividad en los otros nodos
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
