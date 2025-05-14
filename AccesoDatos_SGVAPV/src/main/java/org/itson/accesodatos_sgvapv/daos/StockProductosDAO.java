/*
 * StockProductosDAO.java
 */
package org.itson.accesodatos_sgvapv.daos;

import entidades.Producto;
import entidades.StockProducto;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * Clase que permite realizar la actualización del stock de productos en la base
 * de datos.
 *
 * @author Equipo1
 */
class StockProductosDAO implements IStockProductosDAO {

    private IConexion conexion;
    private static final Logger logger = Logger.getLogger(StockProductosDAO.class.getName());

    /**
     * Constructor que recibe la conexión a la base de datos.
     *
     * @param conexion La conexión a la base de datos
     */
    public StockProductosDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public void eliminarStockPorProductoId(Long productoId) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            if (productoId == null) {
                throw new PersistenciaException("El ID del producto no puede ser nulo para eliminar su stock.");
            }
            em.getTransaction().begin();

            String jpqlDelete = "DELETE FROM StockProducto sp WHERE sp.producto.id = :pid";
            Query query = em.createQuery(jpqlDelete);
            query.setParameter("pid", productoId);

            int deletedCount = query.executeUpdate();
            em.getTransaction().commit();

            if (deletedCount > 0) {
                logger.log(Level.INFO, "Se eliminaron " + deletedCount + " registros de stock para el producto ID: " + productoId);
            } else {
                logger.log(Level.INFO, "No se encontraron registros de stock para eliminar para el producto ID: " + productoId + " (puede que ya no existiera).");
            }

        } catch (Exception e) {
            if (em.getTransaction() != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            logger.log(Level.SEVERE, "Error al eliminar stock por producto ID: " + productoId, e);
            throw new PersistenciaException(e.getMessage());
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public void setStockCantidad(Long productoId, Integer nuevaCantidad) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            if (productoId == null) {
                throw new PersistenciaException("El ID del producto no puede ser nulo para setear el stock.");
            }
            em.getTransaction().begin();

            String jpqlFindStock = "SELECT sp FROM StockProducto sp WHERE sp.producto.id = :productoId";
            TypedQuery<StockProducto> queryFind = em.createQuery(jpqlFindStock, StockProducto.class);
            queryFind.setParameter("productoId", productoId);

            StockProducto stockProducto;
            try {
                stockProducto = queryFind.getSingleResult();
                stockProducto.setCantidad(nuevaCantidad);
                em.merge(stockProducto);
            } catch (NoResultException e) {
                logger.log(Level.WARNING, "No se encontró StockProducto para el producto ID: " + productoId + " al intentar setear cantidad. Se intentará crear uno si es necesario para la lógica de negocio.");
                throw new PersistenciaException("No se encontró StockProducto para el producto ID: " + productoId + ". No se puede setear cantidad.");
            }

            em.getTransaction().commit();
            logger.log(Level.INFO, "Stock actualizado directamente para producto ID: " + productoId + " a cantidad: " + nuevaCantidad);
        } catch (Exception e) {
            if (em.getTransaction() != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            logger.log(Level.SEVERE, "Error al setear stock para producto ID: " + productoId, e);
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
    public Integer obtenerStockProducto(Producto producto) {
        EntityManager em = conexion.crearConexion();
        try {
            if (producto == null || producto.getId() == null) {
                logger.log(Level.WARNING, "Se intentó obtener stock para un producto nulo o sin ID.");
                return null;
            }

            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<StockProducto> criteria = builder.createQuery(StockProducto.class);
            Root<StockProducto> root = criteria.from(StockProducto.class);

            criteria.select(root).where(
                    builder.equal(root.get("producto").get("id"), producto.getId())
            );

            TypedQuery<StockProducto> query = em.createQuery(criteria);
            StockProducto stockProducto = query.getSingleResult();

            return stockProducto.getCantidad();

        } catch (NoResultException e) {
            logger.log(Level.INFO, "No se encontró StockProducto para el producto: " + producto.getNombre() + " (ID: " + producto.getId() + ")");
            return null;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al obtener stock para el producto: " + (producto != null ? producto.getNombre() : "PRODUCTO NULO"), e);
            return null;
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
    public void aumentarStock(Producto producto, int stock) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();

        try {
            em.getTransaction().begin();

            String jpqlUpdate = "UPDATE StockProducto sp SET sp.cantidad = sp.cantidad + :stock WHERE sp.id = :idProducto";
            Query queryUpdate = em.createQuery(jpqlUpdate);
            queryUpdate.setParameter("stock", stock);
            queryUpdate.setParameter("idProducto", producto.getId());

            int updatedCount = queryUpdate.executeUpdate();

            if (updatedCount > 0) {
                em.getTransaction().commit();
                logger.log(Level.INFO, "Se actualizó el stock correctamente.");
            } else {
                logger.log(Level.INFO, "No se actualizó ningún stock.");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Ocurrio un error actualizar el stock.");
        } finally {
            em.close();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void disminuirStock(Producto producto, int stock) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();

        try {
            em.getTransaction().begin();

            String jpqlUpdate = "UPDATE stockproductos sp SET sp.cantidad = sp.cantidad - :stock WHERE sp.id_producto = :idProducto AND sp.cantidad > 0";
            Query queryUpdate = em.createQuery(jpqlUpdate);
            queryUpdate.setParameter("stock", stock);
            queryUpdate.setParameter("idProducto", producto.getId());

            int updatedCount = queryUpdate.executeUpdate();

            if (updatedCount > 0) {
                em.getTransaction().commit();
                logger.log(Level.INFO, "Se actualizó el stock correctamente.");
            } else {
                logger.log(Level.INFO, "No se actualizó ningún stock.");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Ocurrio un error al actualizar el stock.");
        } finally {
            em.close();
        }
    }

}
