/*
 * ISubsistemaInventarioFacade.java
 */
package org.itson.subsistemainventario_sgvapv;

import dtos.ProductoDTO;
import java.util.List;
import org.itson.subsistemainventario_sgvapv.excepciones.SubsistemaInventarioException;

/**
 *
 * @author Equipo1
 */
public interface ISubsistemaInventarioFacade {
    
    List<ProductoDTO> obtenerTodosLosProductos() throws SubsistemaInventarioException;

    /**
     * Obtiene un ProductoDTO detallado, listo para ser editado, buscando por su ID.
     *
     * @param productoId El ID del producto a obtener.
     * @return El ProductoDTO con todos sus detalles (incluyendo id y, para Llenado, el contenedor asociado).
     * @throws SubsistemaInventarioException Si ocurre un error o el producto no se encuentra.
     */
    ProductoDTO obtenerProductoParaEdicion(Long productoId) throws SubsistemaInventarioException;

    /**
     * Guarda los cambios realizados a un producto existente.
     *
     * @param productoEditado El ProductoDTO con los datos actualizados (debe incluir el ID original).
     * @throws SubsistemaInventarioException Si ocurre un error al guardar los cambios.
     */
    void guardarCambiosProducto(ProductoDTO productoEditado) throws SubsistemaInventarioException;
    
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
     * @throws SubsistemaInventarioException Cuando ocurre un error al agregar un
     * producto
     */
    public void agregarProducto(ProductoDTO producto) throws SubsistemaInventarioException;

    /**
     * Permite actualizar un producto existente en la base de datos a partir de
     * los datos enviados.
     *
     * @param producto El producto del cual se obtendrán los datos para realizar
     * la actualización
     * @throws SubsistemaInventarioException Cuando ocurre un error al actualizar el
     * producto
     */
    public void actualizarProducto(ProductoDTO producto) throws SubsistemaInventarioException;

    /**
     * Permite eliminar un producto de la base de datos.
     *
     * @param codigo El código del producto que se desea eliminar
     * @throws SubsistemaInventarioException Cuando ocurre un error al eliminar el
     * producto
     */
    public void eliminarProducto(String codigo) throws SubsistemaInventarioException;

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
    
    /**
     * Permite obtener el stock de un producto.
     *
     * @param producto El producto del cual se desea obtener el stock
     * @return El stock
     */
    public Integer obtenerStockProducto(ProductoDTO producto);

    /**
     * Permite aumentar el stock de un producto.
     *
     * @param producto El producto al que se le desea aumentar el stock
     * @param cantidad La cantidad de stock a aumentar
     * @throws SubsistemaInventarioException Si ocurre un error al modificar el stock
     */
    public void aumentarStock(ProductoDTO producto, int cantidad) throws SubsistemaInventarioException;

    /**
     * Permite disminuir el stock de un producto.
     *
     * @param producto El producto al que se le desea disminuir el stock
     * @param cantidad La cantidad de stock a disminuir
     * @throws SubsistemaInventarioException Si ocurre un error al modificar el stock
     */
    public void disminuirStock(ProductoDTO producto, int cantidad) throws SubsistemaInventarioException;

}
