/*
 * Conexion.java
 */
package org.itson.accesodatos_sgvapv.conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase que permite establecer la conexión con la base de datos.
 *
 * @author Equipo1
 */
public class Conexion implements IConexion {

    /**
     * {@inheritDoc} 
     */
    @Override
    public EntityManager crearConexion() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaSGVAPV");
        
        EntityManager em = emf.createEntityManager();
        
        return em;
    }

}
