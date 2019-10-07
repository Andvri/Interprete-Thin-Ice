/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

import codigo.Tokens;
import javax.swing.JTextArea;

/**
 *
 * @author kvnsnchz
 */
public class Imprimir {
    static int sangria = 0;
	
    public static void imprimir(NodoBase raiz, JTextArea textArea){
        sangria += 2;
        
        while (raiz != null) {
          imprimirSangria(textArea);
            
            if (raiz instanceof  NodoPrograma){
                textArea.append("programa");
            }
            else{
                if (raiz instanceof  NodoSi){
                    textArea.append("si");
                }
                else{
                  if (raiz instanceof  NodoPara){
                     textArea.append("para");
                  }
                  else{
                      if (raiz instanceof  NodoRepita){
                          textArea.append("repita");
                      }
                      else{
                          if (raiz instanceof  NodoDefinicion){
                              textArea.append(((NodoDefinicion)raiz).getTipoDato().toString() + " " + ((NodoDefinicion)raiz).getIdentificador());
                          }
                          else{
                            if (raiz instanceof  NodoAsignacion){
                                textArea.append(((NodoAsignacion)raiz).getIdentificador() + ":=");
                            }
                            else{
                                if (raiz instanceof NodoOperacion){
                                    Tokens operacion = ((NodoOperacion) raiz).getOperacion();

                                    if(operacion == Tokens.Menor){
                                        textArea.append("<"); 
                                    }

                                    if(operacion == Tokens.Mayor){
                                        textArea.append(">");
                                    }

                                    if(operacion == Tokens.Menor_igual){
                                        textArea.append("<="); 
                                    }

                                    if(operacion == Tokens.Mayor_igual){
                                        textArea.append(">="); 
                                    }

                                    if(operacion == Tokens.Igual){
                                        textArea.append("=");
                                    }

                                    if(operacion == Tokens.Y_logico){
                                        textArea.append("Y");
                                    }

                                    if(operacion == Tokens.O_logico){
                                        textArea.append("O");
                                    }

                                    if(operacion == Tokens.Negacion_logica){
                                        textArea.append("!");
                                    }

                                    if(operacion == Tokens.Diferencia){
                                        textArea.append("<>");
                                    }

                                    if(operacion == Tokens.Suma){
                                        textArea.append("+");
                                    }

                                    if(operacion == Tokens.Resta){
                                        textArea.append("-");
                                    }

                                    if(operacion == Tokens.Multiplicacion){
                                        textArea.append("*");
                                    }        

                                    if(operacion == Tokens.Division){
                                        textArea.append("/");
                                    }

                                }
                                else{
                                    if(raiz instanceof NodoFuncion){
                                        textArea.append("funcion: " + ((NodoFuncion)raiz).getIdentificador());
                                    }
                                    else{
                                        if (raiz instanceof NodoNumero){
                                            textArea.append("" + ((NodoNumero)raiz).getNumero());
                                        }
                                        else{
                                            if(raiz instanceof NodoIdentificador ){
                                                textArea.append(((NodoIdentificador)raiz).getIdentificador());
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
            
            textArea.append("\n");
            
            if (raiz instanceof  NodoPrograma){
              imprimirSangria(textArea);
              textArea.append("--Programa_Segmento--\n");
              imprimir(((NodoPrograma)raiz).getSegmento(), textArea);
            }
            else{
                if (raiz instanceof  NodoSi){
                    imprimirSangria(textArea);
                    textArea.append("--Si_Condicion--\n");
                    imprimir(((NodoSi)raiz).getCondicion(), textArea);

                    imprimirSangria(textArea);
                    textArea.append("--Si_Segmento--\n");
                    imprimir(((NodoSi)raiz).getSegmento(), textArea);

                    if(((NodoSi)raiz).getSino() != null){
                            imprimirSangria(textArea);
                            textArea.append("--Si_Sino--\n");
                            imprimir(((NodoSi)raiz).getSino(), textArea);
                    }
                  }
                  else{ 
                      if (raiz instanceof  NodoPara){
                          imprimirSangria(textArea);
                          textArea.append("--Para_Inicializador--\n");
                          imprimir(((NodoPara)raiz).getInicializador(), textArea);

                          imprimirSangria(textArea);
                          textArea.append("--Para_Paso--\n");
                          imprimir(((NodoPara)raiz).getPaso(), textArea);

                          imprimirSangria(textArea);
                          textArea.append("--Para_Verificacion--\n");
                          imprimir(((NodoPara)raiz).getVerificacion(), textArea);

                          imprimirSangria(textArea);
                          textArea.append("--Para_Segmento--\n");
                          imprimir(((NodoPara)raiz).getSegmento(), textArea);
                      }
                      else{ 
                          if (raiz instanceof  NodoRepita){
                              imprimirSangria(textArea);
                              textArea.append("--Repita_Segmento--\n");
                              imprimir(((NodoRepita)raiz).getSegmento(), textArea);

                              imprimirSangria(textArea);
                              textArea.append("--Repita_Condicion--\n");
                              imprimir(((NodoRepita)raiz).getCondicion(), textArea);
                          }
                          else{ 
                              if (raiz instanceof  NodoDefinicion){
                                if(((NodoDefinicion)raiz).getIndiceVector() != null){
                                   imprimirSangria(textArea);
                                   textArea.append("--Indice_Vector--\n");
                                   imprimir(((NodoDefinicion)raiz).getIndiceVector(), textArea);
                                }  
                              }
                              else{
                                if (raiz instanceof  NodoAsignacion){
                                  imprimirSangria(textArea);
                                  textArea.append("--Asignacion--\n");
                                  imprimir(((NodoAsignacion)raiz).getAsignacion(), textArea);
                                  if(((NodoAsignacion)raiz).getIndiceVector() != null){
                                   imprimirSangria(textArea);
                                   textArea.append("--Indice_Vector--\n");
                                   imprimir(((NodoAsignacion)raiz).getIndiceVector(), textArea);
                                  } 
                                }
                                else{ 
                                    if (raiz instanceof  NodoOperacion){
                                        if(((NodoOperacion)raiz).getOpI() != null){
                                            imprimirSangria(textArea);
                                            textArea.append("--Operacion_Izquierda--\n");
                                            imprimir(((NodoOperacion)raiz).getOpI(), textArea);
                                        }

                                        imprimirSangria(textArea);
                                        textArea.append("--Operacion_Derecha--\n");
                                        imprimir(((NodoOperacion)raiz).getOpD(), textArea);
                                    }
                                    else{
                                        if (raiz instanceof  NodoIdentificador){
                                            if(((NodoIdentificador)raiz).getIndiceVector() != null){
                                             imprimirSangria(textArea);
                                             textArea.append("--Indice_Vector--\n");
                                             imprimir(((NodoIdentificador)raiz).getIndiceVector(), textArea);
                                            } 
                                        }
                                        else{
                                            if (raiz instanceof  NodoFuncion){
                                                if(((NodoFuncion)raiz).getParametro() != null){
                                                 imprimirSangria(textArea);
                                                 textArea.append("--Parametro_Funcion--\n");
                                                 imprimir(((NodoFuncion)raiz).getParametro(), textArea);
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
        sangria-=2;
    }
    
    static void imprimirSangria(JTextArea textArea) { 
      for (int i = 0; i < sangria; i++){
        textArea.append(" ");  
      }
    }
}
