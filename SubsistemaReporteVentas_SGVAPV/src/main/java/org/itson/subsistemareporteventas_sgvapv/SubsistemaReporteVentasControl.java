/*
 * SubsistemaReporteVentasControl.java
 */
package org.itson.subsistemareporteventas_sgvapv;

import auxiliares.FiltroReportes;
import dtos.ProductoDTO;
import dtos.ProductoVentaDTO;
import dtos.VentaReporteDTO;
import dtos.VendedorDTO;
import dtos.VentaDTO;
import entidades.ProductoVenta;
import entidades.Venta;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import org.itson.accesodatos_sgvapv.daos.AccesoDatosFacade;
import org.itson.accesodatos_sgvapv.daos.IAccesoDatosFacade;
import dtos.FiltroReportesDTO;
import entidades.Producto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 * @author Equipo1
 */
class SubsistemaReporteVentasControl {

    private IAccesoDatosFacade accesoDatos;

    public SubsistemaReporteVentasControl() {
        this.accesoDatos = new AccesoDatosFacade();
    }

    public List<VentaDTO> obtenerVentas(FiltroReportesDTO filtro) {
        FiltroReportes filtroReportes = new FiltroReportes();

        if (filtro.getFechaInicio() != null && filtro.getFechaFin() != null) {
            filtroReportes.setFechaInicio(filtro.getFechaInicio());
            filtroReportes.setFechaFin(filtro.getFechaFin());
        }

        if (filtro.getProductos() != null && !filtro.getProductos().isEmpty()) {
            List<Producto> productosFiltro = new LinkedList<>();

            for (ProductoDTO producto : filtro.getProductos()) {
                Producto producto2 = new Producto(producto.getCodigo(), producto.getNombre(), producto.getPrecio());
                producto2.setId(producto.getId());
                productosFiltro.add(producto2);
            }

            filtroReportes.setProductos(productosFiltro);
        }

        List<Venta> ventasObtenidas = accesoDatos.obtenerVentas(filtroReportes);

        if (ventasObtenidas != null && !ventasObtenidas.isEmpty()) {
            List<VentaDTO> ventas = new LinkedList<>();

            for (Venta venta : ventasObtenidas) {
                VendedorDTO vendedor = new VendedorDTO(venta.getVendedor().getNombre(), venta.getVendedor().getNombreUsuario(), venta.getVendedor().getContrasenia());
                List<ProductoVentaDTO> productosVenta = new LinkedList<>();

                for (ProductoVenta producto : venta.getProductos()) {
                    ProductoDTO productoVenta = new ProductoDTO(producto.getId(), producto.getProducto().getCodigo(), producto.getProducto().getNombre(), producto.getProducto().getPrecio(), producto.getCantidad());

                    productosVenta.add(new ProductoVentaDTO(producto.getPrecio(), producto.getCantidad(), productoVenta));
                }

                ventas.add(new VentaDTO(venta.getTotal(), venta.getFechaHora(), vendedor, productosVenta));
            }

            return ventas;
        } else {
            return null;
        }
    }

    public void generarReporte(List<VentaReporteDTO> ventas) {
        // Crear un JRBeanCollectionDataSource con la lista de VentaReporteDTO
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(ventas, false);
        // Parámetros para el reporte
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CollectionBeanParam", dataSource);

        // Configuración del JFileChooser para seleccionar la ubicación y nombre del archivo
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar Reporte");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF", "pdf"));

        // Mostrar el diálogo para guardar el archivo
        int userSelection = fileChooser.showSaveDialog(null);

        // Si el usuario selecciona guardar
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();

            // Asegurar que la extensión del archivo sea .pdf
            if (!filePath.endsWith(".pdf")) {
                filePath += ".pdf";
            }

            // Cargar el diseño del reporte desde el archivo "plantilla-reporte.jrxml"
            try (InputStream input = new FileInputStream(
    "C:\\Users\\ricar\\OneDrive\\Documentos\\Proyecto de Software Integrador\\SGV-APV\\SubsistemaReporteVentas_SGVAPV\\plantilla-reportes.jrxml")) {
                JasperDesign jasperDesign = JRXmlLoader.load(input);
                // Compilar el reporte
                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                // Llenar el reporte con los datos y parámetros proporcionados
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

                // Exportar el reporte a un archivo PDF
                try (
                        OutputStream outputStream = new FileOutputStream(new File(filePath))) {
                    JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
                }

                // Log y mensaje de éxito
                Logger.getLogger(SubsistemaReporteVentasControl.class.getName()).log(Level.INFO, "Reporte generado.");
                System.out.println("Ruta del archivo guardado: " + filePath);
                JOptionPane.showMessageDialog(null, "Archivo guardado", "Info", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                // Log y excepción en caso de error
                JOptionPane.showMessageDialog(null, "Error.", 
                        "Hubo un error al generar el reporte", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
                Logger.getLogger(SubsistemaReporteVentasControl.class.getName()).log(Level.SEVERE, "Error al generar el reporte");
            }
        } else if (userSelection == JFileChooser.CANCEL_OPTION) {
            // Si el usuario cancela la operación
            Logger.getLogger(SubsistemaReporteVentasControl.class.getName()).log(Level.INFO, "El usuario canceló la operación.");
        }
    }

}
