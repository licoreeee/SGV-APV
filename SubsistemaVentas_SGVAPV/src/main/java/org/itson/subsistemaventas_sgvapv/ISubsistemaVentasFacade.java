/*
 * ISubsistemaInventarioFacade.java
 */
package org.itson.subsistemaventas_sgvapv;

import dtos.ProductoDTO;
import java.util.List;
import org.itson.accesodatos_svgapv.excepciones.PersistenciaException;
import org.itson.subsistemaventas_sgvapv.excepciones.SubsistemaVentasException;

/**
 *
 * @author Equipo1
 */
public interface ISubsistemaVentasFacade {
    
    /**
     * Permite obtener un producto a partir de su código.
     *
     * @param codigo El código del producto buscado
     * @return El producto cuyo código coincide con el solicitado
     */
    public ProductoDTO obtenerProducto(String codigo);

    /**
     * Permite agregar un producto nuevo a la base de datos.
     *
     * @param producto El producto nuevo a agregar
     * @throws PersistenciaException Cuando ocurre un error al agregar un
     * producto
     */
    public void agregarProducto(ProductoDTO producto) throws SubsistemaVentasException;

    /**
     * Permite actualizar un producto existente en la base de datos a partir de
     * los datos enviados.
     *
     * @param producto El producto del cual se obtendrán los datos para realizar
     * la actualización
     * @throws PersistenciaException Cuando ocurre un error al actualizar el
     * producto
     */
    public void actualizarProducto(ProductoDTO producto) throws SubsistemaVentasException;

    /**
     * Permite eliminar un producto de la base de datos.
     *
     * @param codigo El código del producto que se desea eliminar
     * @throws PersistenciaException Cuando ocurre un error al eliminar el
     * producto
     */
    public void eliminarProducto(String codigo) throws SubsistemaVentasException;

    /**
     * Permite obtener un listado de los productos cuyo tipo coincida con los
     * solicitado.
     *
     * @param tipos Los tipo de productos solicitado
     * @return Una lista de productos
     */
    public List<ProductoDTO> obtenerProductosPorTipo(List<String> tipos);

    /**
     * Permite obtener un listado de los productos cuyo nombre coincida con el
     * solicitado.
     *
     * @param nombre El nombre de los productos solicitados
     * @return Una lista de productos
     */
    public List<ProductoDTO> obtenerProductosPorNombre(String nombre);
}
