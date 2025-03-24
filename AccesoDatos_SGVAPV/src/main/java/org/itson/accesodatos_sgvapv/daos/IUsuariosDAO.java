/*
 * IUsuariosDAO.java
 */
package org.itson.accesodatos_sgvapv.daos;

import entidades.Usuario;
import org.itson.accesodatos_svgapv.excepciones.PersistenciaException;

/**
 * Interfaz que proporciona los métodos para acceder y manipular datos
 * relacionados con los usuarios en la base de datos.
 *
 * @author Equipo 1
 */
interface IUsuariosDAO {

    /**
     * Permite obtener un usuario en específico dado su nombre de usuario.
     *
     * @param nombreUsuario Código del usuario a buscar.
     * @return El usuario que se haya encontrado, null en caso contrario.
     */
    public Usuario obtenerUsuario(String nombreUsuario);

    /**
     * Permite actualizar un usuario dado el nombre de usuario y una entidad con
     * los datos ya modificados.
     *
     * @param usuario Usuario a actualizar.
     * @throws PersistenciaException Si llegase a ocurrir un error durante la
     * actualización.
     */
    public void actualizarUsuario(Usuario usuario) throws PersistenciaException;

    /**
     * Permite agregar un usuario a la base de datos.
     *
     * @param usuario Usuario a agregar.
     * @throws PersistenciaException Si llegase a ocurrir un error al momento de
     * agregar el usuario.
     */
    public void agregarUsuario(Usuario usuario) throws PersistenciaException;

    /**
     * Permite eliminar un usuario de la base de datos dado su código.
     *
     * @param codigo Código del usuario a eliminar.
     * @throws PersistenciaException Si llegase a ocurrir un problema durante la
     * eliminación.
     */
    public void eliminarUsuario(Long codigo) throws PersistenciaException;
}
