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
public enum Tokens {
    /* Programa Principal */
    Programa,
    /* Bloques */
    Corchete_a,
    Corchete_c,
    Parentesis_a,
    Parentesis_c,
    Llave_a,
    Llave_c,
    /* Tipo de Datos */
    Entero,
    Logico,
    /* Instrucciones Condicionales */
    Si,
    Sino,
    /* Instrucciones de Control */
    Para,
    Repita,
    Hasta,
    /* Operación de Asignación */
    Asignacion,
    /* Operaciónes Aritmeticas */
    Suma,
    Resta,
    Multiplicacion,
    Division,
    Modulo,
    /* Operaciónes Relacionales */
    Menor,
    Menor_igual,
    Mayor,
    Mayor_igual,
    Igual,
    Diferencia,
    /* Operaciónes Logicas */
    Y_logico,
    O_logico,
    Negacion_logica,
    /* Otros */
    Linea,
    Identificador,
    Numero,
    ERROR
}
