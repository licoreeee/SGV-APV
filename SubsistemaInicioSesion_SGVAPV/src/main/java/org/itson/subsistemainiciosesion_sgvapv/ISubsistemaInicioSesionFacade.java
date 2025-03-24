/*
 * ISubsistemaInicioSesionFacade.java
 */
package org.itson.subsistemainiciosesion_sgvapv;

import dtos.UsuarioDTO;
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
     * @return El usuario que inició sesión
     * @throws SubsistemaInicioSesionException Si ocurrió un problema al iniciar
     * la sesión
     */
    public UsuarioDTO iniciarSesion(String nombreUsuario, String contrasenia) throws SubsistemaInicioSesionException;

}
