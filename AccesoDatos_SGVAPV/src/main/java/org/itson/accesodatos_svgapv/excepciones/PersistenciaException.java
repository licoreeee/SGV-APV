/*
 * PersistenciaException.java
 */
package org.itson.accesodatos_svgapv.excepciones;

/**
 * Clase que permite el manejo de errores provocados por alguna de las clases
 * DAO.
 *
 * @author Equipo1
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor.
     */
    public PersistenciaException() {
    }

    /**
     * Constructor que recibe el mensaje de la excepción.
     *
     * @param message El mensaje de la excepción
     */
    public PersistenciaException(String message) {
        super(message);
    }

}
