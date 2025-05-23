package pruebas;

import auxiliares.FiltroReportes;
import entidades.ProductoVenta;
import entidades.Variado;
import org.itson.accesodatos_sgvapv.daos.IAccesoDatosFacade;
import entidades.Venta;
import java.util.List;
import org.itson.accesodatos_sgvapv.conexion.Conexion;
import org.itson.accesodatos_sgvapv.conexion.IConexion;
import org.itson.accesodatos_sgvapv.daos.AccesoDatosFacade;
import org.itson.accesodatos_svgapv.excepciones.PersistenciaException;

public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PersistenciaException {
//        IAccesoDatosFacade accesoDatos = new AccesoDatosFacade();
//        List<Variado> productos = new ArrayList<>();
//
//        IAccesoDatosFacade accesoDatos = new AccesoDatosFacade();
        IConexion conexion = new Conexion();
        conexion.crearConexion();
//        List<Producto> productos = new LinkedList<>();

//        productos.add(new Variado("VAR-001", "Trapeador", 140f));
//        productos.add(new Variado("VAR-002", "Escoba", 120f));
//        productos.add(new Variado("VAR-003", "Balde", 90f));
//        productos.add(new Variado("VAR-004", "Esponja", 30f));
//        productos.add(new Variado("VAR-005", "Detergente", 75f));
//        productos.add(new Variado("VAR-006", "Jabón líquido", 110f));
//        productos.add(new Variado("VAR-007", "Paño de microfibra", 50f));
//        productos.add(new Variado("VAR-008", "Guantes de limpieza", 60f));
//        productos.add(new Variado("VAR-009", "Cepillo para pisos", 130f));
//        productos.add(new Variado("VAR-010", "Bolsas de basura", 45f));
        // Persistir los productos
//        for (Producto producto : productos) {
//            accesoDatos.agregarProducto(producto);
//        }
//        for (int i = 0; i < productos.size(); i++) {
//            accesoDatos.aumentarStock(productos.get(i), (i+1)*2);
//        }
//        Contenedor contenedor = new Contenedor("CON-001", "Garrafón Nuevo 19L", 85f, 19);
//        Llenado llenado = new Llenado("LEN-001", "Llenado Garrafon", 19, contenedor, 14f);
//        List<Producto> lista = accesoDatos.obtenerProductosPorTipo(List.of(Variado.class));
//
//        try {
//            accesoDatos.agregarProducto(variado);
//            accesoDatos.agregarProducto(contenedor);
//            accesoDatos.agregarProducto(llenado);
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        IConexion conexion = new Conexion();
//        conexion.crearConexion();
//        Variado variado = new Variado("VAR-001", "Trapeador", 140f);
//        Contenedor contenedor = new Contenedor("CON-001", "Garrafón Nuevo 19L", 85f, 19);
//        Llenado llenado = new Llenado("LEN-001", "Llenado Garrafon", 19, contenedor, 14f);
//        List<Producto> lista = accesoDatos.obtenerProductosPorTipo(List.of(Variado.class));
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
//        List<Producto> productos = accesoDatos.obtenerProductosPorTipo(List.of(Variado.class, Contenedor.class));
//        
//        if (productos != null) {
//            for (Producto producto : productos) {
//                System.out.println(producto);
//            }
//        }


//        FiltroReportes fr = new FiltroReportes();
//        Variado variado = new Variado("VAR-001", "Trapeador", 140.0f);
//        variado.setId(1L);
//        fr.setProductos(List.of(variado));
//        
//        IAccesoDatosFacade accesoDatos = new AccesoDatosFacade();
//        
//        List<Venta> ventas = accesoDatos.obtenerVentas(fr);
//        
//        if (ventas.isEmpty()) {
//            System.out.println("No se obtuvo ninguna venta.");
//        } else {
//            for (Venta venta : ventas) {
//                System.out.println(venta.getFechaHora());
//                for (ProductoVenta producto : venta.getProductos()) {
//                    System.out.println(producto);
//                }
//            }
//        }
    }

}
