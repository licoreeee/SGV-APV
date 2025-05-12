/*
 * SubsistemaInventarioControl.java
 */
package org.itson.subsistemainventario_sgvapv;

import dtos.ContenedorDTO;
import dtos.LlenadoDTO;
import dtos.ProductoDTO;
import dtos.VariadoDTO;
import entidades.Contenedor;
import entidades.Llenado;
import entidades.Producto;
import entidades.Variado;
import java.util.LinkedList;
import java.util.List;
import org.itson.accesodatos_sgvapv.daos.IAccesoDatosFacade;
import org.itson.accesodatos_sgvapv.daos.AccesoDatosFacade;
import org.itson.accesodatos_svgapv.excepciones.PersistenciaException;
import org.itson.subsistemainventario_sgvapv.excepciones.SubsistemaInventarioException;

/**
 *
 * @author Equipo1
 */
class SubsistemaInventarioControl {

    private IAccesoDatosFacade accesoDatos;

    /**
     * Constructor.
     */
    public SubsistemaInventarioControl() {
        accesoDatos = new AccesoDatosFacade();
    }

    /**
     * Permite obtener un producto a partir de su código.
     *
     * @param codigo El código del producto buscado
     * @return El producto cuyo código coincide con el solicitado
     */
    public ProductoDTO obtenerProducto(String codigo) {
        Producto productoObtenido = accesoDatos.obtenerProducto(codigo);
        Integer cantidad = accesoDatos.obtenerStockProducto(productoObtenido);

        ProductoDTO producto = null;

        if (productoObtenido instanceof Variado) {
            producto = new VariadoDTO(productoObtenido.getId(), productoObtenido.getCodigo(), productoObtenido.getNombre(), productoObtenido.getPrecio(), cantidad);
        } else if (productoObtenido instanceof Contenedor) {
            producto = new ContenedorDTO(productoObtenido.getId(), ((Contenedor) productoObtenido).getVolumen(), productoObtenido.getCodigo(), productoObtenido.getNombre(), productoObtenido.getPrecio(), cantidad);
        } else if (productoObtenido instanceof Llenado) {
            producto = new LlenadoDTO(productoObtenido.getId(), productoObtenido.getCodigo(), productoObtenido.getNombre(), productoObtenido.getPrecio(), ((Llenado) productoObtenido).getLitros());
        }

        return producto;
    }

    /**
     * Permite agregar un producto nuevo a la base de datos.
     *
     * @param producto El producto nuevo a agregar
     * @throws SubsistemaInventarioException Cuando ocurre un error al agregar
     * un producto
     */
    public void agregarProducto(ProductoDTO producto) throws SubsistemaInventarioException {
        Producto productoNuevo = new Producto(producto.getCodigo(), producto.getNombre(), producto.getPrecio());

        try {
            accesoDatos.agregarProducto(productoNuevo);
        } catch (PersistenciaException ex) {
            throw new SubsistemaInventarioException(ex.getMessage());
        }
    }

    /**
     * Permite actualizar un producto existente en la base de datos a partir de
     * los datos enviados.
     *
     * @param producto El producto del cual se obtendrán los datos para realizar
     * la actualización
     * @throws SubsistemaInventarioException Cuando ocurre un error al
     * actualizar el producto
     */
    public void actualizarProducto(ProductoDTO producto) throws SubsistemaInventarioException {
        Producto productoActualizado = new Producto(producto.getCodigo(), producto.getNombre(), producto.getPrecio());

        try {
            accesoDatos.actualizarProducto(productoActualizado);
        } catch (PersistenciaException ex) {
            throw new SubsistemaInventarioException(ex.getMessage());
        }
    }

    /**
     * Permite eliminar un producto de la base de datos.
     *
     * @param codigo El código del producto que se desea eliminar
     * @throws SubsistemaInventarioException Cuando ocurre un error al eliminar
     * el producto
     */
    public void eliminarProducto(String codigo) throws SubsistemaInventarioException {
        try {
            accesoDatos.eliminarProducto(codigo);
        } catch (PersistenciaException ex) {
            throw new SubsistemaInventarioException(ex.getMessage());
        }
    }

    /**
     * Permite obtener un listado de los productos cuyo tipo coincida con los
     * solicitado.
     *
     * @param tipos Los tipo de productos solicitado
     * @return Una lista de productos
     */
    public List<ProductoDTO> obtenerProductosPorTipo(List<String> tipos) {
        List<Class> tiposBuscados = new LinkedList<>();

        for (String tipo : tipos) {
            if (tipo.equalsIgnoreCase("Variado")) {
                tiposBuscados.add(Variado.class);
            } else if (tipo.equalsIgnoreCase("Llenado")) {
                tiposBuscados.add(Llenado.class);
            } else if (tipo.equalsIgnoreCase("Contenedor")) {
                tiposBuscados.add(Contenedor.class);
            }
        }

        List<Producto> productosObtenidos = accesoDatos.obtenerProductosPorTipo(tiposBuscados);
        List<ProductoDTO> productos = new LinkedList<>();

        if (productosObtenidos != null && !productosObtenidos.isEmpty()) {
            for (Producto productoObtenido : productosObtenidos) {
                Integer cantidad = accesoDatos.obtenerStockProducto(productoObtenido);

                if (productoObtenido instanceof Variado) {
                    productos.add(new VariadoDTO(productoObtenido.getId(), productoObtenido.getCodigo(), productoObtenido.getNombre(), productoObtenido.getPrecio(), cantidad));
                } else if (productoObtenido instanceof Contenedor) {
                    productos.add(new ContenedorDTO(productoObtenido.getId(), ((Contenedor) productoObtenido).getVolumen(), productoObtenido.getCodigo(), productoObtenido.getNombre(), productoObtenido.getPrecio(), cantidad));
                } else if (productoObtenido instanceof Llenado) {
                    productos.add(new LlenadoDTO(productoObtenido.getId(), productoObtenido.getCodigo(), productoObtenido.getNombre(), productoObtenido.getPrecio(), ((Llenado) productoObtenido).getLitros()));
                }
            }
        }

        return productos;
    }

    /**
     * Permite obtener un listado de los productos cuyo nombre coincida con el
     * solicitado.
     *
     * @param nombre El nombre de los productos solicitados
     * @return Una lista de productos
     */
    public List<ProductoDTO> obtenerProductosPorNombre(String nombre) {
        List<Producto> productosObtenidos = accesoDatos.obtenerProductosPorNombre(nombre);
        List<ProductoDTO> productos = new LinkedList<>();

        if (productosObtenidos != null && !productosObtenidos.isEmpty()) {
            for (Producto productoObtenido : productosObtenidos) {
                Integer cantidad = accesoDatos.obtenerStockProducto(productoObtenido);

                if (productoObtenido instanceof Variado) {
                    productos.add(new VariadoDTO(productoObtenido.getId(), productoObtenido.getCodigo(), productoObtenido.getNombre(), productoObtenido.getPrecio(), cantidad));
                } else if (productoObtenido instanceof Contenedor) {
                    productos.add(new ContenedorDTO(productoObtenido.getId(), ((Contenedor) productoObtenido).getVolumen(), productoObtenido.getCodigo(), productoObtenido.getNombre(), productoObtenido.getPrecio(), cantidad));
                } else if (productoObtenido instanceof Llenado) {
                    productos.add(new LlenadoDTO(productoObtenido.getId(), productoObtenido.getCodigo(), productoObtenido.getNombre(), productoObtenido.getPrecio(), ((Llenado) productoObtenido).getLitros()));
                }
            }
        }

        return productos;
    }

    /**
     * Permite obtener el stock de un producto.
     *
     * @param producto El producto del cual se desea obtener el stock
     * @return El stock
     */
    public Integer obtenerStockProducto(ProductoDTO producto) {
        Producto productoBuscado = accesoDatos.obtenerProducto(producto.getCodigo());

        return accesoDatos.obtenerStockProducto(productoBuscado);
    }

    /**
     * Permite aumentar el stock de un producto.
     *
     * @param producto El producto al que se le desea aumentar el stock
     * @param cantidad La cantidad de stock a aumentar
     * @throws SubsistemaInventarioException Si ocurre un error al modificar el stock
     */
    public void aumentarStock(ProductoDTO producto, int cantidad) throws SubsistemaInventarioException {
        Producto productoBuscado = accesoDatos.obtenerProducto(producto.getCodigo());

        try {
            accesoDatos.aumentarStock(productoBuscado, cantidad);
        } catch (PersistenciaException ex) {
            throw new SubsistemaInventarioException(ex.getMessage());
        }
    }

    /**
     * Permite disminuir el stock de un producto.
     *
     * @param producto El producto al que se le desea disminuir el stock
     * @param cantidad La cantidad de stock a disminuir
     * @throws SubsistemaInventarioException Si ocurre un error al modificar el stock
     */
    public void disminuirStock(ProductoDTO producto, int cantidad) throws SubsistemaInventarioException {
        Producto productoBuscado = accesoDatos.obtenerProducto(producto.getCodigo());

        try {
            accesoDatos.disminuirStock(productoBuscado, cantidad);
        } catch (PersistenciaException ex) {
            throw new SubsistemaInventarioException(ex.getMessage());
        }
    }

}
