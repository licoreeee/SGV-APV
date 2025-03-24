/*
 * IAccesoDatosFacade.java
 */
package org.itson.accesodatos_sgvapv.daos;

import entidades.Producto;
import entidades.Usuario;
import entidades.Venta;
import java.util.Calendar;
import java.util.List;
import org.itson.accesodatos_svgapv.excepciones.PersistenciaException;

/**
 * Interfaz que declara los métodos necesarios para realizar el acceso a datos.
 *
 * @author Equipo1
 */
public interface IAccesoDatosFacade {

    /**
     * Permite obtener un producto a partir de su código.
     *
     * @param codigo El código del producto buscado
     * @return El producto cuyo código coincide con el solicitado
     */
    public Producto obtenerProducto(String codigo);

    /**
     * Permite agregar un producto nuevo a la base de datos.
     *
     * @param producto El producto nuevo a agregar
     * @throws PersistenciaException Cuando ocurre un error al agregar un
     * producto
     */
    public void agregarProducto(Producto producto) throws PersistenciaException;

    /**
     * Permite actualizar un producto existente en la base de datos a partir de
     * los datos enviados.
     *
     * @param producto El producto del cual se obtendrán los datos para realizar
     * la actualización
     * @throws PersistenciaException Cuando ocurre un error al actualizar el
     * producto
     */
    public void actualizarProducto(Producto producto) throws PersistenciaException;

    /**
     * Permite eliminar un producto de la base de datos.
     *
     * @param codigo El código del producto que se desea eliminar
     * @throws PersistenciaException Cuando ocurre un error al eliminar el
     * producto
     */
    public void eliminarProducto(String codigo) throws PersistenciaException;

    /**
     * Permite obtener un listado de los productos cuyo tipo coincida con los
     * solicitado.
     *
     * @param tipos Los tipo de productos solicitado
     * @return Una lista de productos
     */
    public List<Producto> obtenerProductosPorTipo(List<Class> tipos);

    /**
     * Permite obtener un listado de los productos cuyo nombre coincida con el
     * solicitado.
     *
     * @param nombre El nombre de los productos solicitados
     * @return Una lista de productos
     */
    public List<Producto> obtenerProductosPorNombre(String nombre);

    /**
     * Permite obtener un usuario en específico dado su nombre de usuario.
     *
     * @param nombreUsuario Nombre del usuario a buscar,
     * @return El usuario que se haya encontrado, null en caso contrario.
     */
    public Usuario obtenerUsuario(String nombreUsuario) throws PersistenciaException;

    /**
     * Permite actualizar un usuario dado el nombre de usuario y una entidad con
     * los datos ya modificados.
     *
     * @param usuario Usuario a actualizar.
     * @throws PersistenciaException Si llegase a ocurrir un error durante la
     * actualización.
     */
    public void actualizarUsuario(Usuario usuario) throws PersistenciaException;

    /**
     * Permite agregar un usuario a la base de datos.
     *
     * @param usuario Usuario a agregar.
     * @throws PersistenciaException Si llegase a ocurrir un error al momento de
     * agregar el usuario.
     */
    public void agregarUsuario(Usuario usuario) throws PersistenciaException;

    /**
     * Permite eliminar un usuario de la base de datos.
     *
     * @param usuario Usuario a eliminar.
     * @throws PersistenciaException Si llegase a ocurrir un problema durante la
     * eliminación.
     */
    public void eliminarUsuario(Usuario usuario) throws PersistenciaException;

    /**
     * Permite obtener una venta dado código.
     *
     * @param codigo El código de la venta buscada.
     * @return La venta si se encuentra, null en caso contrario.
     * @throws PersistenciaException Si llegase a ocurrir un problema durante la
     * búsqueda.
     */
    public Venta obtenerVenta(Long codigo) throws PersistenciaException;

    /**
     * Permite registrar una venta en la base de datos.
     *
     * @param venta Venta que se quiere agregar.
     * @throws PersistenciaException Si llegase a ocurrir un error al tratar de
     * guardar una venta.
     */
    public void agregarVenta(Venta venta) throws PersistenciaException;

    /**
     * Permite modificar una venta en la base de datos dado un código y la
     * entidad ya con sus datos modificados.
     *
     * @param venta Venta que se quiere modificar.
     * @throws PersistenciaException Si llegase a ocurrir un error al tratar de
     * actualizar una venta.
     */
    public void actualizarVenta(Venta venta) throws PersistenciaException;

    /**
     * Permite obtener un listado de todas las ventas que se hayan realizado
     * dentro del periodo que engloba la fecha de inicio y la fecha de fin.
     *
     * @param fechaInicio Fecha de inicio del periodo a tomar en cuenta.
     * @param fechaFin Fecha fin del periodo a tomar en cuenta.
     * @return Devuelve un listado con todas las ventas que se hayan encontrado.
     * @throws PersistenciaException Si llegase a ocurrir un problema durante la
     * eliminación.
     */
    public List<Venta> obtenerVentasPeriodo(Calendar fechaInicio, Calendar fechaFin) throws PersistenciaException;

}
