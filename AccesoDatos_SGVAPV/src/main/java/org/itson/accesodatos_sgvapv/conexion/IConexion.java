/*
 * IConexion.java
 */
package org.itson.accesodatos_sgvapv.conexion;

import javax.persistence.EntityManager;

/**
 * Interfaz que define los métodos necesarios para establecer la conexión con la
 * base de datos.
 *
 * @author Equipo1
 */
public interface IConexion {

    /**
     * Permite obtener el EntityManager para acceder a la base de datos.
     *
     * @return El EntityManager para acceder a la base de datos
     */
    public EntityManager crearConexion();

}
