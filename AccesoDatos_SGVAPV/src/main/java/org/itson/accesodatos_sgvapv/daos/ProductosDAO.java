/**
 * ProductosDAO.java
 */
package org.itson.accesodatos_sgvapv.daos;

import entidades.Contenedor;
import entidades.Llenado;
import java.util.logging.Level;
import java.util.logging.Logger;
import entidades.Producto;
import entidades.Variado;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.itson.accesodatos_sgvapv.conexion.IConexion;
import org.itson.accesodatos_svgapv.excepciones.PersistenciaException;

/**
 * Clase que permite realizar el acceso a datos de la tabla productos en la base
 * de datos.
 *
 * @author Equipo1
 */
class ProductosDAO implements IProductosDAO {

    private IConexion conexion;
    private static final Logger logger = Logger.getLogger(ProductosDAO.class.getName());

    /**
     * Constructor que recibe la conexión a la base de datos.
     *
     * @param conexion La conexión a la base de datos
     */
    public ProductosDAO(IConexion conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public Producto obtenerProductoPorId(Long id) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            if (id == null) {
                logger.log(Level.WARNING, "Se intentó obtener un producto con ID nulo.");
                throw new PersistenciaException("El ID del producto no puede ser nulo para la búsqueda.");
            }
            Producto producto = em.find(Producto.class, id);
            if (producto == null) {
                logger.log(Level.INFO, "No se encontró un producto con el ID: " + id);
            }
            return producto;
        } catch (IllegalArgumentException iae) { // em.find puede lanzar esto si el ID no es del tipo correcto
            logger.log(Level.SEVERE, "Argumento ilegal al buscar producto por ID: " + id, iae);
            throw new PersistenciaException(iae.getMessage());
        } catch (Exception e) { // Captura más general para otros errores de persistencia
            logger.log(Level.SEVERE, "Error de persistencia al obtener producto por ID: " + id, e);
            throw new PersistenciaException(e.getMessage());
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Producto obtenerProducto(String codigo) {
        EntityManager em = conexion.crearConexion();

        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Producto> criteria = builder.createQuery(Producto.class);
            Root<Producto> root = criteria.from(Producto.class);

            criteria.select(root).where(
                    builder.equal(root.get("codigo"), codigo)
            );

            TypedQuery<Producto> query = em.createQuery(criteria);
            Producto producto = query.getSingleResult();
            return producto;
        } catch (NoResultException e) {
            logger.log(Level.INFO, "No se encontró un producto con el código: " + codigo);
            return null;
        } finally {
            em.close();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void agregarProducto(Producto producto) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();

        try {
            em.getTransaction().begin();

            em.persist(producto);

            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PersistenciaException("Ocurrio un error al agregar el producto.");
        } finally {
            em.close();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void actualizarProducto(Producto producto) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();

        try {
            String jpqlUpdate = null;
            Query queryUpdate = null;
            em.getTransaction().begin();

            if (producto instanceof Variado) {
                jpqlUpdate = "UPDATE Variado v SET v.nombre = :nombre, v.precio = :precio WHERE v.codigo = :codigo";
                queryUpdate = em.createQuery(jpqlUpdate);
                queryUpdate.setParameter("nombre", producto.getNombre());
                queryUpdate.setParameter("precio", producto.getPrecio());
                queryUpdate.setParameter("codigo", producto.getCodigo());
            } else if (producto instanceof Llenado) {
                jpqlUpdate = "UPDATE Llenado l SET l.nombre = :nombre, l.precio = :precio, l.contenedor = :contenedor, l.litros = :litros WHERE l.codigo = :codigo";
                queryUpdate = em.createQuery(jpqlUpdate);
                queryUpdate.setParameter("nombre", producto.getNombre());
                queryUpdate.setParameter("precio", producto.getPrecio());
                queryUpdate.setParameter("codigo", producto.getCodigo());
                queryUpdate.setParameter("contenedor", ((Llenado) producto).getContenedor());
                queryUpdate.setParameter("litros", ((Llenado) producto).getLitros());
            } else if (producto instanceof Contenedor) {
                jpqlUpdate = "UPDATE Contenedor c SET c.nombre = :nombre, c.precio = :precio, c.volumen = :volumen WHERE c.codigo = :codigo";
                queryUpdate = em.createQuery(jpqlUpdate);
                queryUpdate.setParameter("nombre", producto.getNombre());
                queryUpdate.setParameter("precio", producto.getPrecio());
                queryUpdate.setParameter("codigo", producto.getCodigo());
                queryUpdate.setParameter("volumen", ((Contenedor) producto).getVolumen());
            }

            int updatedCount = queryUpdate.executeUpdate();

            if (updatedCount > 0) {
                em.getTransaction().commit();
                logger.log(Level.INFO, "Se actualizó el producto correctamente.");
            } else {
                logger.log(Level.INFO, "No se actualizó ningún producto.");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Ocurrio un error al actualizar el producto." + e.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eliminarProducto(String codigo) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();

        try {
            em.getTransaction().begin();

            String jpqlDelete = "DELETE FROM Producto p WHERE p.codigo = :codigo";
            Query queryDelete = em.createQuery(jpqlDelete);
            queryDelete.setParameter("codigo", codigo);

            int deletedCount = queryDelete.executeUpdate();

            if (deletedCount > 0) {
                em.getTransaction().commit();
                logger.log(Level.INFO, "Se eliminó el producto correctamente.");
            } else {
                logger.log(Level.INFO, "No se eliminó ningún producto.");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Ocurrió algún error al eliminar el producto." + e.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Producto> obtenerProductosPorTipo(List<Class> tipos) {
    EntityManager em = conexion.crearConexion();
    System.out.println("[DAO] ProductosDAO: Buscando productos por tipos Class: " + tipos); // DEBUG
    try {
        String jpqlSelect = "SELECT p FROM Producto p WHERE TYPE(p) IN :tipos";
        TypedQuery<Producto> querySelect = em.createQuery(jpqlSelect, Producto.class);
        querySelect.setParameter("tipos", tipos);

        List<Producto> productos = querySelect.getResultList();
        System.out.println("[DAO] ProductosDAO: Productos encontrados en BD (antes de refresh de stock): " + (productos != null ? productos.size() : "null")); // DEBUG

        if (productos != null) {
            for (Producto producto : productos) {
                if (producto != null && producto.getStock() != null) {
                    try {
                        // System.out.println("[DAO] ProductosDAO: Refrescando stock para producto: " + producto.getCodigo()); // DEBUG
                        em.refresh(producto.getStock());
                    } catch (Exception e_refresh) {
                        logger.log(Level.WARNING, "DAO: No se pudo hacer refresh del stock para producto: " + producto.getCodigo() + ". Causa: " + e_refresh.getMessage());
                    }
                }
            }
        }
        return productos;
    } catch (Exception e) { // Cambiado a Exception general para ver cualquier error
        logger.log(Level.SEVERE, "Error al obtener productos por tipo: " + tipos, e);
        // Devolver lista vacía en caso de error para no romper el flujo, pero loguear severamente.
        return Collections.emptyList();
    } finally {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Producto> obtenerProductosPorNombre(String nombre) {
        EntityManager em = conexion.crearConexion();

        try {
            em.getTransaction().begin();

            String jpqlSelect = "SELECT p FROM Producto p WHERE p.nombre = :nombre";
            Query querySelect = em.createQuery(jpqlSelect);
            querySelect.setParameter("nombre", nombre);

            List<Producto> productos = querySelect.getResultList();

            return productos;
        } catch (Exception e) {
            logger.log(Level.INFO, "No se encontraron productos con el nombre: " + nombre);
            return null;
        } finally {
            em.close();
        }
    }

}
