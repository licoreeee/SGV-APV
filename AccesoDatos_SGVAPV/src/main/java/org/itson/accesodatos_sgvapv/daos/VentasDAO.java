/*
 * VentasDAO.java
 */
package org.itson.accesodatos_sgvapv.daos;

import entidades.Producto;
import entidades.Venta;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import auxiliares.FiltroReportes;
import org.itson.accesodatos_sgvapv.conexion.IConexion;
import org.itson.accesodatos_svgapv.excepciones.PersistenciaException;

/**
 * Clase que implementa la interfaz IVentasDAO y define los métodos para
 * realizar operaciones relacionadas con la entidad Venta en la base de datos.
 *
 * @author Equipo 1
 */
class VentasDAO implements IVentasDAO {

    private final IConexion conexion;
    private static final Logger logger = Logger.getLogger(VentasDAO.class.getName());

    /**
     * Constructor que recibe la conexión a la base de datos.
     *
     * @param conexion La conexión a la base de datos
     */
    public VentasDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Permite obtener una venta dado código.
     *
     * @param codigo El código de la venta buscada.
     * @return La venta si se encuentra, null en caso contrario.
     */
    @Override
    public Venta obtenerVenta(Long codigo) {
        // Creamos un entity manager.
        EntityManager em = conexion.crearConexion();

        // Mandamos a buscar la venta.
        Venta venta = em.find(Venta.class, codigo);

        // Cerramos el entity manager.
        em.close();

        // Imprimimos un mensaje de que se obtuvo una venta.
        logger.log(Level.INFO, "Se ha obtenido 1 venta correctamente.");

        // Retornamos la venta encontrada.
        return venta;
    }

    /**
     * Permite registrar una venta en la base de datos.
     *
     * @param venta Venta que se quiere agregar.
     * @throws PersistenciaException Si llegase a ocurrir un error al tratar de
     *                               guardar una venta.
     */
    @Override
    public void agregarVenta(Venta venta) throws PersistenciaException {
        try {
            // Creamos un entity manager.
            EntityManager em = conexion.crearConexion();

            // Iniciamos la transacción.
            em.getTransaction().begin();

            // Mandamos a persistir la venta.
            em.persist(venta);

            // Hacemos el commit y cerramos el entity manager.
            em.getTransaction().commit();
            em.close();

            // Imprimimos un mensaje de que se insertó una venta.
            logger.log(Level.INFO, "Se ha insertando 1 venta correctamente.");
        } catch (Exception e) {
            throw new PersistenciaException("Ocurrió algún error durante la inserción. Error " + e.getMessage());
        }
    }

    /**
     * Permite modificar una venta en la base de datos dado un código y la
     * entidad ya con sus datos modificados.
     *
     * @param venta Venta que se quiere modificar.
     * @throws PersistenciaException Si llegase a ocurrir un error al tratar de
     *                               actualizar una venta.
     */
    @Override
    public void actualizarVenta(Venta venta) throws PersistenciaException {
        try {
            // Creamos un entity manager.
            EntityManager em = conexion.crearConexion();

            // Iniciamos la transacción.
            em.getTransaction().begin();

            // Actualizamos la venta.
            em.merge(venta);

            // Hacemos el commit y cerramos el entity manager.
            em.getTransaction().commit();
            em.close();

            // Imprimimos un mensaje de que se actualizó una venta.
            logger.log(Level.INFO, "Se ha actualizado 1 venta correctamente.");
        } catch (Exception e) {
            throw new PersistenciaException("Ocurrió algún error durante la actualización. Error " + e.getMessage());
        }
    }

    /**
     * Permite obtener un listado de todas las ventas que se hayan realizado
     * dentro del periodo que engloba la fecha de inicio y la fecha de fin.
     *
     * @param fechaInicio Fecha de inicio del periodo a tomar en cuenta.
     * @param fechaFin    Fecha fin del periodo a tomar en cuenta.
     * @return Devuelve un listado con todas las ventas que se hayan encontrado.
     */
    @Override
    public List<Venta> obtenerVentas(FiltroReportes filtro) {
        EntityManager em = conexion.crearConexion();

        String jpql = "SELECT DISTINCT v FROM Venta v " +
                "JOIN v.productos pv " +
                "JOIN pv.producto p " +
                "WHERE 1=1";

        if (filtro.getFechaInicio() != null && filtro.getFechaFin() != null) {
            jpql += " AND v.fechaHora BETWEEN :fechaInicio AND :fechaFin";
        }

        if (filtro.getProductos() != null && !filtro.getProductos().isEmpty()) {
            jpql += " AND p IN :productos";
        }

        jpql += " ORDER BY v.fechaHora DESC";

        TypedQuery<Venta> query = em.createQuery(jpql, Venta.class);

        // Parámetros
        if (filtro.getFechaInicio() != null && filtro.getFechaFin() != null) {
            query.setParameter("fechaInicio", filtro.getFechaInicio());
            query.setParameter("fechaFin", filtro.getFechaFin());
        }

        if (filtro.getProductos() != null && !filtro.getProductos().isEmpty()) {
            query.setParameter("productos", filtro.getProductos()); // Deben ser entidades completas
        }

        return query.getResultList();
    }

    /**
     * Permite eliminar una venta en la base de datos dado un código.
     *
     * @param venta Venta que se quiere eliminar.
     * @throws PersistenciaException Si llegase a ocurrir un error al tratar de
     *                               eliminar una venta.
     */
    @Override
    public void cancelarVenta(Venta venta) throws PersistenciaException {
        try {
            // Creamos un entity manager.
            EntityManager em = conexion.crearConexion();

            // Iniciamos la transacción.
            em.getTransaction().begin();

            // Actualizamos la venta.
            em.remove(venta);

            // Hacemos el commit y cerramos el entity manager.
            em.getTransaction().commit();
            em.close();

            // Imprimimos un mensaje de que se eliminó una venta.
            logger.log(Level.INFO, "Se ha eliminado 1 venta correctamente.");
        } catch (Exception e) {
            throw new PersistenciaException("Ocurrió algún error durante la eliminación. Error " + e.getMessage());
        }
    }
}
