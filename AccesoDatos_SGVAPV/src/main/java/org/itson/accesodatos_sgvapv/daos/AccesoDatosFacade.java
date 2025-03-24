/*
 * AccesoDatosFacade.java
 */
package org.itson.accesodatos_sgvapv.daos;

import entidades.Producto;
import entidades.Usuario;
import entidades.Venta;
import java.util.Calendar;
import java.util.List;
import org.itson.accesodatos_sgvapv.conexion.Conexion;
import org.itson.accesodatos_sgvapv.conexion.IConexion;
import org.itson.accesodatos_svgapv.excepciones.PersistenciaException;

/**
 * Clase que permite realizar el acceso a datos.
 *
 * @author Equipo1
 */
public class AccesoDatosFacade implements IAccesoDatosFacade {

    private IProductosDAO productosDAO;
    private IUsuariosDAO usuariosDAO;
    private IVentasDAO ventasDAO;
    private IStockProductosDAO stockProductosDAO;

    /**
     * Constructor.
     */
    public AccesoDatosFacade() {
        IConexion conexion = new Conexion();
        productosDAO = new ProductosDAO(conexion);
        usuariosDAO = new UsuariosDAO(conexion);
        ventasDAO = new VentasDAO(conexion);
        stockProductosDAO = new StockProductosDAO(conexion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Producto obtenerProducto(String codigo) {
        return productosDAO.obtenerProducto(codigo);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void agregarProducto(Producto producto) throws PersistenciaException {
        productosDAO.agregarProducto(producto);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void actualizarProducto(Producto producto) throws PersistenciaException {
        productosDAO.actualizarProducto(producto);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eliminarProducto(String codigo) throws PersistenciaException {
        productosDAO.eliminarProducto(codigo);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Producto> obtenerProductosPorTipo(List<Class> tipos) {
        return productosDAO.obtenerProductosPorTipo(tipos);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Producto> obtenerProductosPorNombre(String nombre) {
        return productosDAO.obtenerProductosPorNombre(nombre);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Usuario obtenerUsuario(String nombreUsuario) throws PersistenciaException {
        return usuariosDAO.obtenerUsuario(nombreUsuario);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void actualizarUsuario(Usuario usuario) throws PersistenciaException {
        usuariosDAO.actualizarUsuario(usuario);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void agregarUsuario(Usuario usuario) throws PersistenciaException {
        usuariosDAO.agregarUsuario(usuario);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eliminarUsuario(Usuario usuario) throws PersistenciaException {
        usuariosDAO.eliminarUsuario(usuario);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Venta obtenerVenta(Long codigo) throws PersistenciaException {
        return ventasDAO.obtenerVenta(codigo);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void agregarVenta(Venta venta) throws PersistenciaException {
        ventasDAO.agregarVenta(venta);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void actualizarVenta(Venta venta) throws PersistenciaException {
        ventasDAO.actualizarVenta(venta);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Venta> obtenerVentasPeriodo(Calendar fechaInicio, Calendar fechaFin) throws PersistenciaException {
        return ventasDAO.obtenerVentasPeriodo(fechaInicio, fechaFin);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer obtenerStockProducto(Producto producto) {
        return stockProductosDAO.obtenerStockProducto(producto);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void aumentarStock(Producto producto, int cantidad) throws PersistenciaException {
        stockProductosDAO.aumentarStock(producto, cantidad);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void disminuirStock(Producto producto, int cantidad) throws PersistenciaException {
        stockProductosDAO.disminuirStock(producto, cantidad);
    }

}
