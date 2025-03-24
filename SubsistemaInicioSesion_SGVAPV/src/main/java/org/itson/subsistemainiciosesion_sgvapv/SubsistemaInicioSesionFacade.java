/*
 * SubsistemaInicioSesionFacade.java
 */
package org.itson.subsistemainiciosesion_sgvapv;

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
    public boolean iniciarSesion(String nombreUsuario, String contrasenia) throws SubsistemaInicioSesionException {
        return control.iniciarSesion(nombreUsuario, contrasenia);
    }

}
