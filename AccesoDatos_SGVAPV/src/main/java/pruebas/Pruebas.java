/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import entidades.Contenedor;
import entidades.Llenado;
import entidades.Producto;
import entidades.Variado;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.accesodatos_sgvapv.conexion.Conexion;
import org.itson.accesodatos_sgvapv.conexion.IConexion;
import org.itson.accesodatos_sgvapv.daos.IProductosDAO;
import org.itson.accesodatos_sgvapv.daos.ProductosDAO;
import org.itson.accesodatos_svgapv.excepciones.PersistenciaException;

/**
 *
 * @author ricar
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IConexion conexion = new Conexion();
        IProductosDAO productosDAO = new ProductosDAO(conexion);
        
//        Variado variado = new Variado("VAR-001", "Trapeador", 140f);
//        Contenedor contenedor = new Contenedor("CON-001", "Garrafón Nuevo 19L", 85f, 19);
//        Llenado llenado = new Llenado("LEN-001", "Llenado Garrafon", 19, contenedor, 14f);
//        
//        try {
//            productosDAO.agregarProducto(variado);
//            productosDAO.agregarProducto(contenedor);
//            productosDAO.agregarProducto(llenado);
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        Producto productoObtenido = productosDAO.obtenerProducto("VAR-001");
//        Producto productoObtenido2 = productosDAO.obtenerProducto("CON-001");
//        Producto productoObtenido3 = productosDAO.obtenerProducto("LEN-001");
//        
//        System.out.println(productoObtenido);
//        System.out.println(productoObtenido2);
//        System.out.println(productoObtenido3);
//        Variado variadoActualizado = new Variado("VAR-001", "Trapeador", 150f);
//        
//        try {
//            productosDAO.actualizarProducto(variadoActualizado);
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Llenado llenadoActualizado = new Llenado("LEN-001", "Llenado garrafon 19L", 19, contenedor, 95);
//        
//        try {
//            productosDAO.actualizarProducto(llenadoActualizado);
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Contenedor contenedorActualizado = new Contenedor("CON-001", "Garrafon nuevo 19L", 85f, 19);
//        
//        try {
//            productosDAO.actualizarProducto(contenedorActualizado);
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            productosDAO.eliminarProducto("VAR-001");
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        try {
//            productosDAO.eliminarProducto("LEN-001");
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        try {
//            productosDAO.eliminarProducto("CON-001");
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }

        List<Producto> productos = productosDAO.obtenerProductosPorTipo(List.of(Variado.class, Contenedor.class));
        
        if (productos != null) {
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }

//        List<Producto> productos2 = productosDAO.obtenerProductosPorNombre("Trapeador");
//        
//        if (productos2 != null) {
//            for (Producto producto : productos2) {
//                System.out.println(producto);
//            }
//        }

    }

}
