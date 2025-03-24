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

    /**
     * Constructor.
     */
    public AccesoDatosFacade() {
        IConexion conexion = new Conexion();
        productosDAO = new ProductosDAO(conexion);
        usuariosDAO = new UsuariosDAO(conexion);
        ventasDAO = new VentasDAO(conexion);
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
    public Usuario obtenerUsuario(String nombreUsuario) {
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
    public void eliminarUsuario(Long codigo) throws PersistenciaException {
        usuariosDAO.eliminarUsuario(codigo);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Venta obtenerVenta(String codigo) {
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
    public List<Venta> obtenerVentasPeriodo(Calendar fechaInicio, Calendar fechaFin) {
        return ventasDAO.obtenerVentasPeriodo(fechaInicio, fechaFin);
    }

}
