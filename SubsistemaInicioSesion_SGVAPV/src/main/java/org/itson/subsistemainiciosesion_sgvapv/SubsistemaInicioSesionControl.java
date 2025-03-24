/*
 * SubsistemaInicioSesionControl.java
 */
package org.itson.subsistemainiciosesion_sgvapv;

import dtos.EmpleadoDTO;
import dtos.EncargadoDTO;
import dtos.UsuarioDTO;
import entidades.Empleado;
import entidades.Encargado;
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
     * @return El usuario que inició sesión
     * @throws SubsistemaInicioSesionException Si ocurrió un problema al iniciar
     * la sesión
     */
    public UsuarioDTO iniciarSesion(String nombreUsuario, String contrasenia) throws SubsistemaInicioSesionException {
        try {
            Usuario usuarioObtenido = accesoDatos.obtenerUsuario(nombreUsuario);
            
            if (usuarioObtenido == null) {
                return null;
            }
            
            if (!usuarioObtenido.getContrasenia().equals(contrasenia)) {
                return null;
            }
            
            UsuarioDTO usuario = null;
            if (usuarioObtenido instanceof Empleado) {
                usuario = new EmpleadoDTO(usuarioObtenido.getNombre(), usuarioObtenido.getNombreUsuario(), usuarioObtenido.getContrasenia());
            } else if (usuarioObtenido instanceof Encargado) {
                usuario = new EncargadoDTO(usuarioObtenido.getNombre(), usuarioObtenido.getNombreUsuario(), usuarioObtenido.getContrasenia());
            }
            
            return usuario;
        } catch (PersistenciaException ex) {
            throw new SubsistemaInicioSesionException(ex.getMessage());
        }
    }
    
}
