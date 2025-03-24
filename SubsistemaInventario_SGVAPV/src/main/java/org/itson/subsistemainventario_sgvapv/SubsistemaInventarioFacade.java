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

    public SubsistemaInventarioFacade() {
        this.control = new SubsistemaInventarioControl();
    }
    
    @Override
    public ProductoDTO obtenerProducto(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarProducto(ProductoDTO producto) throws SubsistemaInventarioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizarProducto(ProductoDTO producto) throws SubsistemaInventarioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarProducto(String codigo) throws SubsistemaInventarioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ProductoDTO> obtenerProductosPorTipo(List<String> tipos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ProductoDTO> obtenerProductosPorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
