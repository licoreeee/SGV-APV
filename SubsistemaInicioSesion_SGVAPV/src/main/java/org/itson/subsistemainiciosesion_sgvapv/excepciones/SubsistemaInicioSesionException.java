/*
 * SubsistemaInventarioException.java
 */
package org.itson.subsistemainiciosesion_sgvapv.excepciones;

/**
 * Clase que permite el manejo de errores provocados por alguna de las clases
 * del subsistema de inicio de sesión.
 *
 * @author Equipo1
 */
public class SubsistemaInicioSesionException extends Exception {

    /**
     * Constructor.
     */
    public SubsistemaInicioSesionException() {
    }

    /**
     * Constructor que recibe el mensaje de la excepción.
     *
     * @param message El mensaje de la excepción
     */
    public SubsistemaInicioSesionException(String message) {
        super(message);
    }

}
