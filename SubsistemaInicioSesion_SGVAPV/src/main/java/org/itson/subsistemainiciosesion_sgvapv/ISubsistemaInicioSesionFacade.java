/*
 * ISubsistemaInicioSesionFacade.java
 */
package org.itson.subsistemainiciosesion_sgvapv;

import org.itson.subsistemainiciosesion_sgvapv.excepciones.SubsistemaInicioSesionException;

/**
 *
 * @author Equipo1
 */
public interface ISubsistemaInicioSesionFacade {

    /**
     * Permite iniciar sesión a un usuario.
     *
     * @param nombreUsuario El nombre de usuario
     * @param contrasenia La contraseña del usuario
     * @return true si se inició sesión correctamente, false en caso contrario
     * @throws SubsistemaInicioSesionException Si ocurrió un problema al iniciar
     * la sesión
     */
    public boolean iniciarSesion(String nombreUsuario, String contrasenia) throws SubsistemaInicioSesionException;

}
