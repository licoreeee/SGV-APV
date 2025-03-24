/*
 * SubsistemaInicioSesionControl.java
 */
package org.itson.subsistemainiciosesion_sgvapv;

import entidades.Usuario;
import org.itson.accesodatos_sgvapv.daos.AccesoDatosFacade;
import org.itson.accesodatos_sgvapv.daos.IAccesoDatosFacade;
import org.itson.accesodatos_svgapv.excepciones.PersistenciaException;
import org.itson.subsistemainiciosesion_sgvapv.excepciones.SubsistemaInicioSesionException;

/**
 *
 * @author Equipo1
 */
class SubsistemaInicioSesionControl {
    
    private IAccesoDatosFacade accesoDatos;

    /**
     * Constructor
     */
    public SubsistemaInicioSesionControl() {
        accesoDatos = new AccesoDatosFacade();
    }
    
    /**
     * Permite iniciar sesión a un usuario.
     *
     * @param nombreUsuario El nombre de usuario
     * @param contrasenia La contraseña del usuario
     * @return true si se inició sesión correctamente, false en caso contrario
     * @throws SubsistemaInicioSesionException Si ocurrió un problema al iniciar
     * la sesión
     */
    public boolean iniciarSesion(String nombreUsuario, String contrasenia) throws SubsistemaInicioSesionException {
        try {
            Usuario usuarioObtenido = accesoDatos.obtenerUsuario(nombreUsuario);
            
            if (usuarioObtenido == null) {
                return false;
            }
            
            return usuarioObtenido.getContrasenia().equals(contrasenia);
        } catch (PersistenciaException ex) {
            throw new SubsistemaInicioSesionException(ex.getMessage());
        }
    }
    
}
