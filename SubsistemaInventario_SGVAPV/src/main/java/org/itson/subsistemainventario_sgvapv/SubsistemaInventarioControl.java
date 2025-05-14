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
import entidades.StockProducto;
import entidades.Variado;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private static final Logger logger = Logger.getLogger(SubsistemaInventarioControl.class.getName());
    private IAccesoDatosFacade accesoDatos;

    /**
     * Constructor.
     */
    public SubsistemaInventarioControl() {
        accesoDatos = new AccesoDatosFacade();
    }

    public ProductoDTO obtenerProductoParaEdicion(Long productoId) throws SubsistemaInventarioException {
        try {
            if (productoId == null) {
                throw new SubsistemaInventarioException("El ID del producto no puede ser nulo para obtener detalles de edición.");
            }
            Producto productoObtenido = accesoDatos.obtenerProductoPorId(productoId);

            if (productoObtenido == null) {
                return null;
            }

            Integer cantidad = accesoDatos.obtenerStockProducto(productoObtenido);
            ProductoDTO productoDto = null;

            if (productoObtenido instanceof Variado) {
                productoDto = new VariadoDTO(
                        productoObtenido.getId(),
                        productoObtenido.getCodigo(),
                        productoObtenido.getNombre(),
                        productoObtenido.getPrecio(),
                        cantidad
                );
            } else if (productoObtenido instanceof Contenedor) {
                productoDto = new ContenedorDTO(
                        ((Contenedor) productoObtenido).getVolumen(),
                        productoObtenido.getId(),
                        productoObtenido.getCodigo(),
                        productoObtenido.getNombre(),
                        productoObtenido.getPrecio(),
                        cantidad
                );
            } else if (productoObtenido instanceof Llenado) {
                Llenado llenadoEntidad = (Llenado) productoObtenido;
                String codigoContenedorAsociado = null;
                if (llenadoEntidad.getContenedor() != null) {
                    codigoContenedorAsociado = llenadoEntidad.getContenedor().getCodigo();
                }
                productoDto = new LlenadoDTO(
                        llenadoEntidad.getLitros(),
                        codigoContenedorAsociado,
                        llenadoEntidad.getId(),
                        llenadoEntidad.getCodigo(),
                        llenadoEntidad.getNombre(),
                        llenadoEntidad.getPrecio()
                );
            } else if (productoObtenido != null) {
                productoDto = new ProductoDTO(
                        productoObtenido.getId(),
                        productoObtenido.getCodigo(),
                        productoObtenido.getNombre(),
                        productoObtenido.getPrecio(),
                        cantidad
                );
            }
            return productoDto;
        } catch (PersistenciaException ex) {
            throw new SubsistemaInventarioException(ex.getMessage());
        } catch (Exception e) {
            throw new SubsistemaInventarioException(e.getMessage());
        }
    }

    public void guardarCambiosProducto(ProductoDTO dtoEditado) throws SubsistemaInventarioException {
        try {
            if (dtoEditado.getId() == null) {
                throw new SubsistemaInventarioException("El ID del producto es necesario para guardar los cambios.");
            }

            Producto entidadExistente = accesoDatos.obtenerProductoPorId(dtoEditado.getId());
            if (entidadExistente == null) {
                throw new SubsistemaInventarioException("Producto con ID " + dtoEditado.getId() + " no encontrado, no se pueden guardar cambios.");
            }

            entidadExistente.setNombre(dtoEditado.getNombre());
            entidadExistente.setPrecio(dtoEditado.getPrecio());

            if (dtoEditado instanceof ContenedorDTO && entidadExistente instanceof Contenedor) {
                ContenedorDTO cDto = (ContenedorDTO) dtoEditado;
                Contenedor contenedorEntidad = (Contenedor) entidadExistente;
                contenedorEntidad.setVolumen(cDto.getVolumen());
            } else if (dtoEditado instanceof LlenadoDTO && entidadExistente instanceof Llenado) {
                LlenadoDTO lDto = (LlenadoDTO) dtoEditado;
                Llenado llenadoEntidad = (Llenado) entidadExistente;
                llenadoEntidad.setLitros(lDto.getLitros());

                if (lDto.getCodigoContenedorAsociado() != null && !lDto.getCodigoContenedorAsociado().isEmpty()) {
                    Producto productoContenedor = accesoDatos.obtenerProducto(lDto.getCodigoContenedorAsociado());
                    if (productoContenedor instanceof Contenedor) {
                        llenadoEntidad.setContenedor((Contenedor) productoContenedor);
                    } else {
                        throw new SubsistemaInventarioException("El Contenedor asociado con código '" + lDto.getCodigoContenedorAsociado() + "' no es válido o no existe.");
                    }
                } else {
                    llenadoEntidad.setContenedor(null);
                }
            } else if (dtoEditado instanceof VariadoDTO && entidadExistente instanceof Variado) {
            } else if (entidadExistente.getClass().getSimpleName().equalsIgnoreCase(dtoEditado.getClass().getSimpleName().replace("DTO", ""))) {
            } else {
                throw new SubsistemaInventarioException("Incompatibilidad de tipos entre el DTO y la entidad existente al guardar cambios. DTO: " + dtoEditado.getClass().getName() + ", Entidad: " + entidadExistente.getClass().getName());
            }

            accesoDatos.actualizarProducto(entidadExistente);

            Integer nuevoStockCantidadUi = dtoEditado.getCantidad();

            if (entidadExistente instanceof Llenado) {
                accesoDatos.setStockCantidad(entidadExistente.getId(), null);
            } else {
                if (nuevoStockCantidadUi != null) {
                    accesoDatos.setStockCantidad(entidadExistente.getId(), nuevoStockCantidadUi);
                }
            }

        } catch (PersistenciaException ex) {
            throw new SubsistemaInventarioException(ex.getMessage());
        } catch (SubsistemaInventarioException sie) {
            throw sie;
        } catch (Exception e) {
            throw new SubsistemaInventarioException(e.getMessage());
        }
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
            producto = new LlenadoDTO(((Llenado) productoObtenido).getLitros(), productoObtenido.getCodigo(), productoObtenido.getNombre(), productoObtenido.getPrecio());
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
    public void agregarProducto(ProductoDTO dto) throws SubsistemaInventarioException {
        Producto entidadJPA;

        if (dto instanceof ContenedorDTO) {
            ContenedorDTO cDto = (ContenedorDTO) dto;
            Contenedor contenedorEntidad = new Contenedor();
            contenedorEntidad.setCodigo(cDto.getCodigo());
            contenedorEntidad.setNombre(cDto.getNombre());
            contenedorEntidad.setPrecio(cDto.getPrecio());
            contenedorEntidad.setVolumen(cDto.getVolumen());
            entidadJPA = contenedorEntidad;
        } else if (dto instanceof LlenadoDTO) {
            LlenadoDTO lDto = (LlenadoDTO) dto;
            Llenado llenadoEntidad = new Llenado();
            llenadoEntidad.setCodigo(lDto.getCodigo());
            llenadoEntidad.setNombre(lDto.getNombre());
            llenadoEntidad.setPrecio(lDto.getPrecio());
            llenadoEntidad.setLitros(lDto.getLitros());

            if (lDto.getCodigoContenedorAsociado() != null && !lDto.getCodigoContenedorAsociado().isEmpty()) {
                Producto productoContenedor = accesoDatos.obtenerProducto(lDto.getCodigoContenedorAsociado());
                if (productoContenedor instanceof Contenedor) {
                    llenadoEntidad.setContenedor((Contenedor) productoContenedor);
                } else {
                    throw new SubsistemaInventarioException("El Contenedor asociado '" + lDto.getCodigoContenedorAsociado() + "' no es válido o no existe.");
                }
            }
            entidadJPA = llenadoEntidad;
        } else if (dto instanceof VariadoDTO) {
            VariadoDTO vDto = (VariadoDTO) dto;
            Variado variadoEntidad = new Variado();
            variadoEntidad.setCodigo(vDto.getCodigo());
            variadoEntidad.setNombre(vDto.getNombre());
            variadoEntidad.setPrecio(vDto.getPrecio());
            entidadJPA = variadoEntidad;
        } else {
            throw new SubsistemaInventarioException("Tipo de ProductoDTO no es específico para agregar: " + dto.getClass().getName());
        }

        StockProducto stockEntidad = new StockProducto();

        if (dto instanceof LlenadoDTO) {
            stockEntidad.setCantidad(null);
            System.out.println("INFO: Creando StockProducto con cantidad NULL para Llenado: " + entidadJPA.getNombre());
        } else {
            if (dto.getCantidad() != null) {
                stockEntidad.setCantidad(dto.getCantidad());
            } else {
                System.err.println("ADVERTENCIA: Cantidad (stock) es null en DTO para " + dto.getClass().getName()
                        + " que no es Llenado. Se asignará 0 por defecto al stock.");
                stockEntidad.setCantidad(0);
            }
        }

        stockEntidad.setProducto(entidadJPA);
        entidadJPA.setStock(stockEntidad);

        try {
            accesoDatos.agregarProducto(entidadJPA);
        } catch (PersistenciaException ex) {
            throw new SubsistemaInventarioException(ex.getMessage());
        } catch (Exception e) {
            throw new SubsistemaInventarioException(e.getMessage());
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

    public void eliminarProducto(String codigo) throws SubsistemaInventarioException {
        try {
            Producto productoParaObtenerId = accesoDatos.obtenerProducto(codigo);

            if (productoParaObtenerId == null) {
                logger.log(Level.WARNING, "Intento de eliminar un producto no existente con código: " + codigo);
                throw new SubsistemaInventarioException("El producto con código '" + codigo + "' no fue encontrado y no puede ser eliminado.");
            }
            if (productoParaObtenerId.getId() == null) {
                logger.log(Level.SEVERE, "El producto con código '" + codigo + "' fue encontrado pero no tiene ID. Revisar la carga de entidades.");
                throw new SubsistemaInventarioException("Error interno: El producto recuperado no tiene un ID válido.");
            }

            Long productoId = productoParaObtenerId.getId();
            logger.log(Level.INFO, "Preparando para eliminar producto con código: " + codigo + ", ID: " + productoId);

            logger.log(Level.INFO, "Intentando eliminar stock para producto ID: " + productoId);
            accesoDatos.eliminarStockPorProductoId(productoId);
            logger.log(Level.INFO, "Stock para producto ID: " + productoId + " procesado para eliminación (o no encontrado).");

            logger.log(Level.INFO, "Intentando eliminar producto con código: " + codigo);
            accesoDatos.eliminarProducto(codigo);
            logger.log(Level.INFO, "Producto con código: " + codigo + " procesado para eliminación.");

        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error de persistencia al intentar eliminar el producto con código '" + codigo + "' o su stock.", ex);
            throw new SubsistemaInventarioException(ex.getMessage());
        } catch (SubsistemaInventarioException sie) {
            throw sie;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error inesperado al eliminar el producto con código '" + codigo + "'.", e);
            throw new SubsistemaInventarioException(e.getMessage());
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
        System.out.println("[CONTROL] SubsistemaInventarioControl: En obtenerProductosPorTipo para tipos String: " + tipos);
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
        System.out.println("[CONTROL] SubsistemaInventarioControl: Tipos Class a buscar en DAO: " + tiposBuscados);

        List<Producto> productosObtenidos = accesoDatos.obtenerProductosPorTipo(tiposBuscados);
        System.out.println("[CONTROL] SubsistemaInventarioControl: DAO devolvió productosObtenidos. Es null? " + (productosObtenidos == null));
        if (productosObtenidos != null) {
            System.out.println("[CONTROL] SubsistemaInventarioControl: Número de entidades Producto obtenidas del DAO: " + productosObtenidos.size());
        }

        List<ProductoDTO> listaProductosDto = new LinkedList<>();
        if (productosObtenidos != null && !productosObtenidos.isEmpty()) {
            for (Producto productoObtenido : productosObtenidos) {
                if (productoObtenido == null) {
                    System.out.println("[CONTROL WARN] SubsistemaInventarioControl: Encontrada entidad Producto nula en la lista del DAO.");
                    continue;
                }
                System.out.println("[CONTROL] SubsistemaInventarioControl: Procesando entidad con código: " + productoObtenido.getCodigo() + ", ID: " + productoObtenido.getId());

                Integer cantidad = accesoDatos.obtenerStockProducto(productoObtenido);

                ProductoDTO dtoConvertido = null;
                if (productoObtenido instanceof Variado) {
                    dtoConvertido = new VariadoDTO(
                            productoObtenido.getId(), 
                            productoObtenido.getCodigo(),
                            productoObtenido.getNombre(),
                            productoObtenido.getPrecio(),
                            cantidad);
                } else if (productoObtenido instanceof Contenedor) {
                    dtoConvertido = new ContenedorDTO(
                            ((Contenedor) productoObtenido).getVolumen(),
                            productoObtenido.getId(),
                            productoObtenido.getCodigo(),
                            productoObtenido.getNombre(),
                            productoObtenido.getPrecio(),
                            cantidad);
                } else if (productoObtenido instanceof Llenado) {
                    Llenado llenadoEnt = (Llenado) productoObtenido;
                    String codCont = null;
                    if (llenadoEnt.getContenedor() != null) {
                        codCont = llenadoEnt.getContenedor().getCodigo();
                    }
                    dtoConvertido = new LlenadoDTO(
                            llenadoEnt.getLitros(),
                            codCont,
                            llenadoEnt.getId(),
                            llenadoEnt.getCodigo(),
                            llenadoEnt.getNombre(),
                            llenadoEnt.getPrecio()
                    );
                }

                if (dtoConvertido != null) {
                    listaProductosDto.add(dtoConvertido);
                } else {
                    System.out.println("[CONTROL WARN] No se pudo convertir la entidad a DTO para código: " + productoObtenido.getCodigo());
                }
            }
        }
        System.out.println("[CONTROL] SubsistemaInventarioControl: Total DTOs a devolver: " + listaProductosDto.size());
        return listaProductosDto;
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
                    productos.add(new LlenadoDTO(
                            ((Llenado) productoObtenido).getLitros(),
                            productoObtenido.getCodigo(),
                            productoObtenido.getNombre(),
                            productoObtenido.getPrecio()
                    ));

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
     * @throws SubsistemaInventarioException Si ocurre un error al modificar el
     * stock
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
     * @throws SubsistemaInventarioException Si ocurre un error al modificar el
     * stock
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
