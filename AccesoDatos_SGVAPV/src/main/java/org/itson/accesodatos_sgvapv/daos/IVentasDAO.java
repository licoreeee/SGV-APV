/*
 * IVentasDAO.java
 */
package org.itson.accesodatos_sgvapv.daos;

import entidades.Venta;
import java.util.Calendar;
import java.util.List;
import org.itson.accesodatos_svgapv.excepciones.PersistenciaException;

/**
 * Interfaz que proporciona los métodos para acceder y manipular datos
 * relacionados con las ventas en la base de datos.
 *
 * @author Equipo 1
 */
interface IVentasDAO {

    /**
     * Permite obtener una venta dado código.
     *
     * @param codigo El código de la venta buscada.
     * @return La venta si se encuentra, null en caso contrario.
     */
    public Venta obtenerVenta(Long codigo);

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
     */
    public List<Venta> obtenerVentasPeriodo(Calendar fechaInicio, Calendar fechaFin);

    /**
     * Permite eliminar una venta en la base de datos dado un código.
     *
     * @param venta Venta que se quiere eliminar.
     * @throws PersistenciaException Si llegase a ocurrir un error al tratar de
     * eliminar una venta.
     */
    public void cancelarVenta(Venta venta) throws PersistenciaException;
}
