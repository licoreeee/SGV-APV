/*
 * SubsistemaInventarioControl.java
 */
package org.itson.subsistemainventario_sgvapv;

import dtos.ProductoDTO;
import dtos.VariadoDTO;
import entidades.Contenedor;
import entidades.Llenado;
import entidades.Producto;
import entidades.Variado;
import java.util.List;
import org.itson.accesodatos_sgvapv.daos.IAccesoDatosFacade;
import org.itson.accesodatos_sgvapv.daos.AccesoDatosFacade;
import org.itson.subsistemainventario_sgvapv.excepciones.SubsistemaInventarioException;

/**
 *
 * @author Equipo1
 */
class SubsistemaInventarioControl {

    private IAccesoDatosFacade accesoDatos;

    public SubsistemaInventarioControl() {
        accesoDatos = new AccesoDatosFacade();
    }

    public ProductoDTO obtenerProducto(String codigo) {
        Producto productoObtenido = accesoDatos.obtenerProducto(codigo);
       
        if (productoObtenido instanceof Variado) {
            VariadoDTO variado = new VariadoDTO(codigo, codigo, Float.NaN, Integer.SIZE);
        } else if (productoObtenido instanceof Contenedor) {
            
        } else if (productoObtenido instanceof Llenado) {
            
        }
    }

    public void agregarProducto(ProductoDTO producto) throws SubsistemaInventarioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void actualizarProducto(ProductoDTO producto) throws SubsistemaInventarioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void eliminarProducto(String codigo) throws SubsistemaInventarioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<ProductoDTO> obtenerProductosPorTipo(List<String> tipos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<ProductoDTO> obtenerProductosPorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
