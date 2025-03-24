/*
 * IStockProductosDAO.java
 */
package org.itson.accesodatos_sgvapv.daos;

import entidades.Producto;
import org.itson.accesodatos_svgapv.excepciones.PersistenciaException;

/**
 * Interfaz que define los métodos necesarios para realizar la actualización del
 * stock de productos en la base de datos.
 *
 * @author Equipo1
 */
interface IStockProductosDAO {

    /**
     * Permite aumentar el stock de un producto.
     *
     * @param producto El producto al que se le desea aumentar el stock
     * @param cantidad La cantidad de stock a aumentar
     * @throws PersistenciaException Si ocurre un error al modificar el stock
     */
    public void aumentarStock(Producto producto, int cantidad) throws PersistenciaException;

    /**
     * Permite disminuir el stock de un producto.
     *
     * @param producto El producto al que se le desea disminuir el stock
     * @param cantidad La cantidad de stock a disminuir
     * @throws PersistenciaException Si ocurre un error al modificar el stock
     */
    public void disminuirStock(Producto producto, int cantidad) throws PersistenciaException;

}
