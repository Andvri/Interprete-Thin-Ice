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
public class Imprimir {
    static int sangria = 0;
	
    public static void imprimir(NodoBase raiz){
        sangria += 2;
        while (raiz != null) {
          imprimirSangria();
          
            if (raiz instanceof  NodoSi){
                System.out.println("si");
            }
            else{
              if (raiz instanceof  NodoPara){
                 System.out.println("para");
              }
              else{
                  if (raiz instanceof  NodoRepita){
                      System.out.println("repita");
                  }
                  else{
                      if (raiz instanceof  NodoAsignacion){
                          System.out.println(((NodoAsignacion)raiz).getIdentificador() + ":=");
                      }
                      else{
                          if (raiz instanceof NodoOperacion){
                              Tokens operacion = ((NodoOperacion) raiz).getOperacion();

                              if(operacion == Tokens.Menor){
                                  System.out.println("<"); 
                              }

                              if(operacion == Tokens.Mayor){
                                  System.out.println(">");
                              }

                              if(operacion == Tokens.Menor_igual){
                                  System.out.println("<="); 
                              }

                              if(operacion == Tokens.Mayor_igual){
                                  System.out.println(">="); 
                              }

                              if(operacion == Tokens.Igual){
                                  System.out.println("=");
                              }

                              if(operacion == Tokens.Y_logico){
                                  System.out.println("Y");
                              }

                              if(operacion == Tokens.O_logico){
                                  System.out.println("O");
                              }

                              if(operacion == Tokens.Negacion_logica){
                                  System.out.println("!");
                              }

                              if(operacion == Tokens.Diferencia){
                                  System.out.println("<>");
                              }

                              if(operacion == Tokens.Suma){
                                  System.out.println("+");
                              }

                              if(operacion == Tokens.Resta){
                                  System.out.println("-");
                              }

                              if(operacion == Tokens.Multiplicacion){
                                  System.out.println("*");
                              }        

                              if(operacion == Tokens.Division){
                                  System.out.println("/");
                              }

                          }
                          else{
                              if (raiz instanceof NodoNumero){
                                  System.out.println(((NodoNumero)raiz).getNumero());
                              }
                              else{
                                  if(raiz instanceof NodoIdentificador ){
                                      System.out.println(((NodoIdentificador)raiz).getIdentificador());
                                  }
                              }
                          }
                      }
                  }
              }
            }

            if (raiz instanceof  NodoSi){
              imprimirSangria();
              System.out.println("**Si_Condicion**");
              imprimir(((NodoSi)raiz).getCondicion());
              
              imprimirSangria();
              System.out.println("**Si_Segmento**");
              imprimir(((NodoSi)raiz).getSegmento());
              
              if(((NodoSi)raiz).getSino() != null){
                      imprimirSangria();
                      System.out.println("**Si_Sino**");
                      imprimir(((NodoSi)raiz).getSino());
              }
            }
            else{ 
                if (raiz instanceof  NodoPara){
                    imprimirSangria();
                    System.out.println("**Para_Inicializador**");
                    imprimir(((NodoPara)raiz).getInicializador());

                    imprimirSangria();
                    System.out.println("**Para_Paso**");
                    imprimir(((NodoPara)raiz).getPaso());

                    imprimirSangria();
                    System.out.println("**Para_Verificacion**");
                    imprimir(((NodoPara)raiz).getVerificacion());

                    imprimirSangria();
                    System.out.println("**Para_Segmento**");
                    imprimir(((NodoPara)raiz).getSegmento());
                }
                else{ 
                    if (raiz instanceof  NodoRepita){
		    	imprimirSangria();
		    	System.out.println("**Repita_Segmento**");
		    	imprimir(((NodoRepita)raiz).getSegmento());
                        
		    	imprimirSangria();
		    	System.out.println("**Repita_Condicion**");
		    	imprimir(((NodoRepita)raiz).getCondicion());
		    }
                    else{ 
                        if (raiz instanceof  NodoAsignacion){
                            imprimirSangria();
                            System.out.println("**Asignacion**");
                            imprimir(((NodoAsignacion)raiz).getAsignacion());
                        }
                        else{ 
                            if (raiz instanceof  NodoOperacion){
                                imprimirSangria();
                                System.out.println("**Operacion_Izquierda**");
                                imprimir(((NodoOperacion)raiz).getOpI());
                                
                                imprimirSangria();
                                System.out.println("**Operacion_Derecha**");
                                imprimir(((NodoOperacion)raiz).getOpD());
                            }
                        }
                    }
                }
            }
            
            raiz = raiz.getHermanoD();
        }
        sangria-=2;
    }
    
    static void imprimirSangria() { 
      for (int i = 0; i < sangria; i++){
        System.out.print(" ");  
      }
    }
}
