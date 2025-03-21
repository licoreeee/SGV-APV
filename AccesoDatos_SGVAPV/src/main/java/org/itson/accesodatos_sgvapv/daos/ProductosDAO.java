/**
 * ProductosDAO.java
 */
package org.itson.accesodatos_sgvapv.daos;

import java.util.logging.Level;
import java.util.logging.Logger;
import entidades.Producto;
import entidades.Variado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
public class ProductosDAO implements IProductosDAO {

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

    /**
     * {@inheritDoc}
     */
    @Override
    public Producto obtenerProducto(String codigo) {
        EntityManager em = conexion.crearConexion();

        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Variado> criteria = builder.createQuery(Variado.class);
            Root<Variado> root = criteria.from(Variado.class);

            criteria.select(root).where(
                    builder.equal(root.get("numeroPlaca"), codigo)
            );

            TypedQuery<Variado> query = em.createQuery(criteria);
            Variado variado = query.getSingleResult();
            return variado;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void actualizarProducto(Producto producto) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eliminarProducto(String codigo) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Producto> obtenerProductosPorTipo(String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Producto> obtenerProductosPorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
