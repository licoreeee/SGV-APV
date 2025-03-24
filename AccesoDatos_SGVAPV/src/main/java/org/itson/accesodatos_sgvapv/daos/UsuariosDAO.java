/*
 * UsuariosDAO.java
 */
package org.itson.accesodatos_sgvapv.daos;

import entidades.Producto;
import entidades.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.itson.accesodatos_sgvapv.conexion.Conexion;
import org.itson.accesodatos_sgvapv.conexion.IConexion;
import org.itson.accesodatos_svgapv.excepciones.PersistenciaException;

/**
 * Clase que implementa la interfaz IUsuariosDAO y define los métodos para
 * realizar operaciones relacionadas con la entidad Usuario en la base de datos.
 *
 * @author Equipo 1
 */
class UsuariosDAO implements IUsuariosDAO {

    private final IConexion conexion;
    private static final Logger logger = Logger.getLogger(UsuariosDAO.class.getName());

    /**
     * Constructor que recibe la conexión a la base de datos.
     *
     * @param conexion La conexión a la base de datos
     */
    public UsuariosDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Permite obtener un usuario en específico dado su nombre de usuario.
     *
     * @param nombreUsuario Código del usuario a buscar.
     * @return El usuario que se haya encontrado, null en caso contrario.
     */
    @Override
    public Usuario obtenerUsuario(String nombreUsuario) {
        // Creamos un entity manager.
        EntityManager em = conexion.crearConexion();

        // Mandamos a buscar el usuario.
        String jpqlSelect = "SELECT p FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario";
        TypedQuery<Usuario> querySelect = em.createQuery(jpqlSelect, Usuario.class);
        querySelect.setParameter("nombreUsuario", nombreUsuario);
        Usuario usuario = querySelect.getSingleResult();
        // Cerramos el entity manager.
        em.close();

        // Imprimimos un mensaje de que se obtuvo un usuario.
        logger.log(Level.INFO, "Se ha obtenido 1 usuario correctamente.");

        // Retornamos el usuario encontrado.
        return usuario;
    }

    /**
     * Permite actualizar un usuario dado el nombre de usuario y una entidad con
     * los datos ya modificados.
     *
     * @param usuario Usuario a actualizar.
     * @throws PersistenciaException Si llegase a ocurrir un error durante la
     * actualización.
     */
    @Override
    public void actualizarUsuario(Usuario usuario) throws PersistenciaException {
        try {
            // Creamos un entity manager.
            EntityManager em = conexion.crearConexion();

            // Iniciamos la transacción.
            em.getTransaction().begin();

            // Actualizamos el usuario.
            em.merge(usuario);

            // Hacemos el commit y cerramos el entity manager.
            em.getTransaction().commit();
            em.close();

            // Imprimimos un mensaje de que se actualizó un usuario.
            logger.log(Level.INFO, "Se ha actualizado 1 usuario correctamente.");
        } catch (Exception e) {
            throw new PersistenciaException("Ocurrió algún error durante la actualización. Error " + e.getMessage());
        }
    }

    /**
     * Permite agregar un usuario a la base de datos.
     *
     * @param usuario Usuario a agregar.
     * @throws PersistenciaException Si llegase a ocurrir un error al momento de
     * agregar el usuario.
     */
    @Override
    public void agregarUsuario(Usuario usuario) throws PersistenciaException {
        try {
            // Creamos un entity manager.
            EntityManager em = conexion.crearConexion();

            // Iniciamos la transacción.
            em.getTransaction().begin();

            // Mandamos a persistir el usuario.
            em.persist(usuario);

            // Hacemos el commit y cerramos el entity manager.
            em.getTransaction().commit();
            em.close();

            // Imprimimos un mensaje de que se insertó un usuario.
            logger.log(Level.INFO, "Se ha insertando 1 usuario correctamente.");
        } catch (Exception e) {
            throw new PersistenciaException("Ocurrió algún error durante la inserción. Error " + e.getMessage());
        }
    }

    /**
     * Permite eliminar un usuario de la base de datos dado su código.
     *
     * @param codigo Código del usuario a eliminar.
     * @throws PersistenciaException Si llegase a ocurrir un problema durante la
     * eliminación.
     */
    @Override
    public void eliminarUsuario(Long codigo) throws PersistenciaException {
        try {
            // Creamos un entity manager.
            EntityManager em = conexion.crearConexion();

            // Obtenemos el usuario con base al nombre de usuario.
            Usuario usuario = em.find(Usuario.class, codigo);

            // Iniciamos la transacción.
            em.getTransaction().begin();

            // Eliminamos el usuario.
            em.remove(usuario);

            // Mandamos el commit y cerramos el entity manager.
            em.getTransaction().commit();
            em.close();

            // Imprimimos un mensaje de que se actualizó un usuario.
            logger.log(Level.INFO, "Se ha actualizado 1 usuario correctamente.");
        } catch (Exception e) {
            throw new PersistenciaException("Ocurrió algún error durante el borrado. Error " + e.getMessage());
        }
    }
}
