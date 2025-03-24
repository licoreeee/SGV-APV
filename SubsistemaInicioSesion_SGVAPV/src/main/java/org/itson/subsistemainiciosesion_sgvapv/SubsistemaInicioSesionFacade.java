/*
 * SubsistemaInicioSesionFacade.java
 */
package org.itson.subsistemainiciosesion_sgvapv;

import dtos.UsuarioDTO;
import org.itson.subsistemainiciosesion_sgvapv.excepciones.SubsistemaInicioSesionException;

/**
 *
 * @author Equipo1
 */
public class SubsistemaInicioSesionFacade implements ISubsistemaInicioSesionFacade {

    private SubsistemaInicioSesionControl control;

    /**
     * Constructor.
     */
    public SubsistemaInicioSesionFacade() {
        control = new SubsistemaInicioSesionControl();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public UsuarioDTO iniciarSesion(String nombreUsuario, String contrasenia) throws SubsistemaInicioSesionException {
        return control.iniciarSesion(nombreUsuario, contrasenia);
    }

}
