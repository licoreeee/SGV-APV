/*
 * StockProductosDAO.java
 */
package org.itson.accesodatos_sgvapv.daos;

import entidades.Producto;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void aumentarStock(Producto producto, int stock) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();

        try {
            em.getTransaction().begin();

            String jpqlUpdate = "UPDATE stockproductos sp SET sp.cantidad = sp.cantidad + :stock WHERE sp.id_producto = :idProducto";
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
