/*
 * IConexion.java
 */
package org.itson.accesodatos_sgvapv.conexion;

/**
 * Interfaz que define los métodos necesarios para establecer la conexión con la
 * base de datos.
 *
 * @author Equipo1
 */
public interface IConexion {

    public EntityManager crearConexion(); 
}
