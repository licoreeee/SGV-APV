/**
 * ProductosDAO.java
 */
package org.itson.accesodatos_sgvapv.daos;

import entidades.Producto;
import java.util.List;
import org.itson.accesodatos_svgapv.excepciones.PersistenciaException;

/**
 * Clase que permite realizar el acceso a datos de la tabla productos en la base
 * de datos.
 *
 * @author Equipo1
 */
public class ProductosDAO implements IProductosDAO {

    //private IConexion conexion;
    
    /**
     * Constructor.
     */
    public ProductosDAO(/*IConexion conexion*/) {
//        this.conexion = conexion;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Producto obtenerProducto(String codigo) {
        Producto productoObtenido = null;
        
        
        
        return null;
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
