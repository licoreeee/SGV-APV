/*
 * SubsistemaInventarioException.java
 */
package org.itson.subsistemainventario_sgvapv.excepciones;

/**
 * Clase que permite el manejo de errores provocados por alguna de las clases
 * del subsistema de inventario.
 *
 * @author Equipo1
 */
public class SubsistemaInventarioException extends Exception {

    /**
     * Constructor.
     */
    public SubsistemaInventarioException() {
    }

    /**
     * Constructor que recibe el mensaje de la excepción.
     *
     * @param message El mensaje de la excepción
     */
    public SubsistemaInventarioException(String message) {
        super(message);
    }

}
