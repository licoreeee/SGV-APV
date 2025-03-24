/*
 * SubsistemaInventarioFacade.java
 */
package org.itson.subsistemainventario_sgvapv;

import dtos.ProductoDTO;
import java.util.List;
import org.itson.subsistemainventario_sgvapv.excepciones.SubsistemaInventarioException;

/**
 *
 * @author Equipo1
 */
public class SubsistemaInventarioFacade implements ISubsistemaInventarioFacade {

    private SubsistemaInventarioControl control;

    /**
     * Constructor.
     */
    public SubsistemaInventarioFacade() {
        this.control = new SubsistemaInventarioControl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductoDTO obtenerProducto(String codigo) {
        return control.obtenerProducto(codigo);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void agregarProducto(ProductoDTO producto) throws SubsistemaInventarioException {
        control.agregarProducto(producto);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void actualizarProducto(ProductoDTO producto) throws SubsistemaInventarioException {
        control.actualizarProducto(producto);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eliminarProducto(String codigo) throws SubsistemaInventarioException {
        control.eliminarProducto(codigo);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ProductoDTO> obtenerProductosPorTipo(List<String> tipos) {
        return control.obtenerProductosPorTipo(tipos);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ProductoDTO> obtenerProductosPorNombre(String nombre) {
        return control.obtenerProductosPorNombre(nombre);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer obtenerStockProducto(ProductoDTO producto) {
        return control.obtenerStockProducto(producto);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void aumentarStock(ProductoDTO producto, int cantidad) throws SubsistemaInventarioException {
        control.aumentarStock(producto, cantidad);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void disminuirStock(ProductoDTO producto, int cantidad) throws SubsistemaInventarioException {
        control.disminuirStock(producto, cantidad);
    }

}
