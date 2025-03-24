package pruebas;

import entidades.Contenedor;
import entidades.Producto;
import entidades.Variado;
import java.util.List;
import org.itson.accesodatos_sgvapv.daos.AccesoDatosFacade;
import org.itson.accesodatos_sgvapv.daos.IAccesoDatosFacade;

public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IAccesoDatosFacade accesoDatos = new AccesoDatosFacade();
        
//        Variado variado = new Variado("VAR-001", "Trapeador", 140f);
//        Contenedor contenedor = new Contenedor("CON-001", "Garrafón Nuevo 19L", 85f, 19);
//        Llenado llenado = new Llenado("LEN-001", "Llenado Garrafon", 19, contenedor, 14f);
//        
//        try {
//            accesoDatos.agregarProducto(variado);
//            accesoDatos.agregarProducto(contenedor);
//            accesoDatos.agregarProducto(llenado);
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        Producto productoObtenido = accesoDatos.obtenerProducto("VAR-001");
//        Producto productoObtenido2 = accesoDatos.obtenerProducto("CON-001");
//        Producto productoObtenido3 = accesoDatos.obtenerProducto("LEN-001");
//        
//        System.out.println(productoObtenido);
//        System.out.println(productoObtenido2);
//        System.out.println(productoObtenido3);
//        Variado variadoActualizado = new Variado("VAR-001", "Trapeador", 150f);
//        
//        try {
//            accesoDatos.actualizarProducto(variadoActualizado);
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Llenado llenadoActualizado = new Llenado("LEN-001", "Llenado garrafon 19L", 19, contenedor, 95);
//        
//        try {
//            accesoDatos.actualizarProducto(llenadoActualizado);
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Contenedor contenedorActualizado = new Contenedor("CON-001", "Garrafon nuevo 19L", 85f, 19);
//        
//        try {
//            accesoDatos.actualizarProducto(contenedorActualizado);
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        try {
//            accesoDatos.eliminarProducto("VAR-001");
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        try {
//            accesoDatos.eliminarProducto("LEN-001");
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        try {
//            accesoDatos.eliminarProducto("CON-001");
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }

        List<Producto> productos = accesoDatos.obtenerProductosPorTipo(List.of(Variado.class, Contenedor.class));
        
        if (productos != null) {
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }

//        List<Producto> productos2 = accesoDatos.obtenerProductosPorNombre("Trapeador");
//        
//        if (productos2 != null) {
//            for (Producto producto : productos2) {
//                System.out.println(producto);
//            }
//        }

    }

}
