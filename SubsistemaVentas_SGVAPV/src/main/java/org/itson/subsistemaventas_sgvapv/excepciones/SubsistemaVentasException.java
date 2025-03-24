/*
 * SubsistemaVentasException.java
 */
package org.itson.subsistemaventas_sgvapv.excepciones;

/**
 * Clase que permite el manejo de errores provocados por alguna de las clases
 * del subsistema de ventas.
 *
 * @author Equipo1
 */
public class SubsistemaVentasException extends Exception {

    /**
     * Constructor.
     */
    public SubsistemaVentasException() {
    }

    /**
     * Constructor que recibe el mensaje de la excepción.
     *
     * @param message El mensaje de la excepción
     */
    public SubsistemaVentasException(String message) {
        super(message);
    }

}
