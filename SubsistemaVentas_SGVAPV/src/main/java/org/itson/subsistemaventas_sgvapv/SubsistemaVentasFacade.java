/*
 * SubsistemaInventarioFacade.java
 */
package org.itson.subsistemaventas_sgvapv;

import dtos.ProductoDTO;
import dtos.VentaDTO;
import java.util.List;
import org.itson.subsistemaventas_sgvapv.excepciones.SubsistemaVentasException;

/**
 *
 * @author Equipo1
 */
public class SubsistemaVentasFacade implements ISubsistemaVentasFacade {

    private SubsistemaVentasControl control;

    public SubsistemaVentasFacade() {
        this.control = new SubsistemaVentasControl();
    }

    @Override
    public ProductoDTO obtenerProducto(String codigo) {
        return null;
    }

    @Override
    public void agregarProducto(ProductoDTO producto) throws SubsistemaVentasException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizarProducto(ProductoDTO producto) throws SubsistemaVentasException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarProducto(String codigo) throws SubsistemaVentasException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ProductoDTO> obtenerProductosPorTipo(List<String> tipos) {
        return control.obtenerProductosPorTipo(tipos);
    }

    @Override
    public List<ProductoDTO> obtenerProductosPorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void realizarVenta(VentaDTO venta) {
        control.realizarVenta(venta);
    }

}
