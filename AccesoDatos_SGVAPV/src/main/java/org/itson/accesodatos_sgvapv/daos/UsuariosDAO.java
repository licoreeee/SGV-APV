/*
 * UsuariosDAO.java
 */
package org.itson.accesodatos_sgvapv.daos;

import entidades.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
     * @throws PersistenciaException Si llegase a ocurrir un error durante la
     * búsqueda.
     */
    @Override
    public Usuario obtenerUsuario(String nombreUsuario) throws PersistenciaException {
        // Creamos un entity manager.
        EntityManager em = conexion.crearConexion();
        try {

            // Mandamos a buscar el usuario.
            String jpqlSelect = "SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario";
            TypedQuery<Usuario> querySelect = em.createQuery(jpqlSelect, Usuario.class);
            querySelect.setParameter("nombreUsuario", nombreUsuario);
            Usuario usuario = querySelect.getSingleResult();

            // Imprimimos un mensaje de que se obtuvo un usuario.
            logger.log(Level.INFO, "Se ha obtenido 1 usuario correctamente.");

            // Retornamos el usuario encontrado.
            return usuario;
        } catch (Exception e) {
            throw new PersistenciaException("Ocurrió algún error durante la búsqueda. Error " + e.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * Permite obtener todos los usuarios de la base de datos.
     *
     * @return Una lista contodos los usuarios, null en caso contrario.
     * @throws PersistenciaException Si llegase a ocurrir un error durante la
     * búsqueda.
     */
    @Override
    public List<Usuario> obtenerTodosUsuarios() throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
            Root<Usuario> root = criteria.from(Usuario.class);

            criteria.select(root);

            TypedQuery<Usuario> query = em.createQuery(criteria);
            List<Usuario> usuarios = query.getResultList();

            return usuarios;
        } catch (NoResultException e) {
            logger.log(Level.INFO, "No se encontró ningún usuario.");
            return null;
        } catch (Exception e) {
            throw new PersistenciaException("Ocurrió algún error durante la búsqueda. Error " + e.getMessage());
        } finally {
            em.close();
        }
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
        // Creamos un entity manager.
        EntityManager em = conexion.crearConexion();
        try {

            // Iniciamos la transacción.
            em.getTransaction().begin();

            // Actualizamos el usuario.
            em.merge(usuario);

            // Hacemos el commit y cerramos el entity manager.
            em.getTransaction().commit();

            // Imprimimos un mensaje de que se actualizó un usuario.
            logger.log(Level.INFO, "Se ha actualizado 1 usuario correctamente.");
        } catch (Exception e) {
            throw new PersistenciaException("Ocurrió algún error durante la actualización. Error " + e.getMessage());
        } finally {
            em.close();
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
        // Creamos un entity manager.
        EntityManager em = conexion.crearConexion();
        try {

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
            throw new PersistenciaException("Ocurrió algún error durante la búsqueda. Error " + e.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * Permite eliminar un usuario de la base de datos.
     *
     * @param usuario Usuario a eliminar.
     * @throws PersistenciaException Si llegase a ocurrir un problema durante la
     * eliminación.
     */
    @Override
    public void eliminarUsuario(Usuario usuario) throws PersistenciaException {
        // Creamos un entity manager.
        EntityManager em = conexion.crearConexion();
        try {

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
            throw new PersistenciaException("Ocurrió algún error durante la búsqueda. Error " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
