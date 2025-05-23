package vistas;

import dtos.ContenedorDTO;
import dtos.LlenadoDTO;
import dtos.ProductoDTO;
import dtos.UsuarioDTO;
import dtos.VariadoDTO;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.itson.subsistemainventario_sgvapv.ISubsistemaInventarioFacade;
import org.itson.subsistemainventario_sgvapv.SubsistemaInventarioFacade;
import org.itson.subsistemainventario_sgvapv.excepciones.SubsistemaInventarioException;

/**
 *
 * @author Dell
 */
public class PantallaEditarProductoInventario extends javax.swing.JFrame {

    private UsuarioDTO usuario;
    private JFrame parentFrame;
    private ISubsistemaInventarioFacade subsistemaInventarioFacade;
    private final String PLACEHOLDER_TIPO = "-- Seleccionar Tipo --";
    private final String PLACEHOLDER_CONTENEDOR = "-- Seleccionar Contenedor --";
    private final String PLACEHOLDER_PRODUCTO_EDITAR = "-- Seleccione Producto a Editar --";
    private ProductoDTO productoSeleccionadoParaEditar;

    /**
     * Creates new form PantallaAgregarProductoInventario
     */
    public PantallaEditarProductoInventario(JFrame parentFrame, UsuarioDTO usuario) {
        initComponents();
        setVisible(true);
        this.parentFrame = parentFrame;
        this.usuario = usuario;
        this.subsistemaInventarioFacade = new SubsistemaInventarioFacade();
        inicializarComponentesAdicionales();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbxProductos = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        txtStock = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblContenedor = new javax.swing.JLabel();
        cmbxProductos2 = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        lblLitros = new javax.swing.JLabel();
        txtLitros = new javax.swing.JTextField();
        lblVolumen = new javax.swing.JLabel();
        txtVolumen = new javax.swing.JTextField();
        cmbxContenedor = new javax.swing.JComboBox();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        cmbxProductos.setFont(new java.awt.Font("Afacad", 1, 20)); // NOI18N
        cmbxProductos.setSelectedItem("--Seleccionar");
        cmbxProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbxProductosActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(196, 216, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEditar.setBackground(new java.awt.Color(41, 136, 194));
        btnEditar.setFont(new java.awt.Font("Afacad", 1, 23)); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 417, 135, -1));

        txtStock.setFont(new java.awt.Font("Afacad", 1, 20)); // NOI18N
        jPanel2.add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 295, 200, -1));

        jLabel3.setFont(new java.awt.Font("Afacad", 1, 30)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("EDITAR PRODUCTO");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 88, 305, -1));

        jLabel6.setFont(new java.awt.Font("Afacad", 1, 23)); // NOI18N
        jLabel6.setText("PRECIO");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 295, -1, -1));

        txtPrecio.setFont(new java.awt.Font("Afacad", 1, 20)); // NOI18N
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });
        jPanel2.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 295, 200, -1));

        btnCancelar.setFont(new java.awt.Font("Afacad", 1, 23)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 417, 172, -1));

        jLabel7.setFont(new java.awt.Font("Afacad", 1, 23)); // NOI18N
        jLabel7.setText("NOMBRE");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 245, 103, -1));

        jLabel8.setFont(new java.awt.Font("Afacad", 1, 23)); // NOI18N
        jLabel8.setText("STOCK");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 295, 82, -1));

        txtNombre.setFont(new java.awt.Font("Afacad", 1, 20)); // NOI18N
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 245, 200, -1));

        lblContenedor.setFont(new java.awt.Font("Afacad", 1, 23)); // NOI18N
        lblContenedor.setText("CONTENEDOR");
        jPanel2.add(lblContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 345, 166, -1));

        cmbxProductos2.setFont(new java.awt.Font("Afacad", 1, 20)); // NOI18N
        cmbxProductos2.setSelectedItem("--Seleccionar");
        cmbxProductos2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbxProductos2ItemStateChanged(evt);
            }
        });
        jPanel2.add(cmbxProductos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 145, 360, -1));

        jLabel10.setFont(new java.awt.Font("Afacad", 1, 23)); // NOI18N
        jLabel10.setText("PRODUCTO");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 145, 134, -1));

        lblLitros.setFont(new java.awt.Font("Afacad", 1, 23)); // NOI18N
        lblLitros.setText("LITROS");
        jPanel2.add(lblLitros, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 195, 84, -1));

        txtLitros.setFont(new java.awt.Font("Afacad", 1, 20)); // NOI18N
        jPanel2.add(txtLitros, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 195, 200, -1));

        lblVolumen.setFont(new java.awt.Font("Afacad", 1, 23)); // NOI18N
        lblVolumen.setText("VOLUMEN");
        jPanel2.add(lblVolumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 245, -1, -1));

        txtVolumen.setFont(new java.awt.Font("Afacad", 1, 20)); // NOI18N
        jPanel2.add(txtVolumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 243, 200, -1));

        cmbxContenedor.setFont(new java.awt.Font("Afacad", 1, 20)); // NOI18N
        cmbxContenedor.setSelectedItem("--Seleccionar");
        jPanel2.add(cmbxContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 345, 360, -1));

        lblCodigo.setFont(new java.awt.Font("Afacad", 1, 23)); // NOI18N
        lblCodigo.setText("CÓDIGO");
        jPanel2.add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 195, 93, -1));

        txtCodigo.setFont(new java.awt.Font("Afacad", 1, 20)); // NOI18N
        txtCodigo.setEnabled(false);
        jPanel2.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 195, 200, -1));

        jPanel1.setBackground(new java.awt.Color(41, 136, 194));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Afacad", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SISTEMA GENERAL DE VENTAS");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo Agua Purificada del Valle.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(14, 14, 14))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 70));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (this.productoSeleccionadoParaEditar == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto de la lista para editar.", "Campo Vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (this.productoSeleccionadoParaEditar.getId() == null) {
            JOptionPane.showMessageDialog(this, "Error al obtener el producto, inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombre = txtNombre.getText().trim();
        String codigoOriginal = this.productoSeleccionadoParaEditar.getCodigo();
        String tipoOriginalDetectado = "";
        if (this.productoSeleccionadoParaEditar instanceof ContenedorDTO) {
            tipoOriginalDetectado = "CONTENEDOR";
        } else if (this.productoSeleccionadoParaEditar instanceof LlenadoDTO) {
            tipoOriginalDetectado = "LLENADO";
        } else if (this.productoSeleccionadoParaEditar instanceof VariadoDTO) {
            tipoOriginalDetectado = "VARIADO";
        } else {
            tipoOriginalDetectado = "PRODUCTO_BASE";
        }

        String precioStr = txtPrecio.getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo 'Nombre' es obligatorio.", "Campo Vacío", JOptionPane.WARNING_MESSAGE);
            txtNombre.requestFocus();
            return;
        }
        if (precioStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo 'Precio' es obligatorio.", "Campo Vacío", JOptionPane.WARNING_MESSAGE);
            txtPrecio.requestFocus();
            return;
        }

        Float precio;
        try {
            precio = Float.parseFloat(precioStr);
            if (precio < 0) {
                throw new NumberFormatException("Precio negativo");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido.", "Dato Inválido", JOptionPane.WARNING_MESSAGE);
            txtPrecio.requestFocus();
            return;
        }

        Integer stockParaDTO = null;
        if (("CONTENEDOR".equals(tipoOriginalDetectado) || "VARIADO".equals(tipoOriginalDetectado) || "PRODUCTO_BASE".equals(tipoOriginalDetectado)) && txtStock.isVisible()) {
            String stockStr = txtStock.getText().trim();
            if (stockStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El campo 'Stock' es obligatorio.", "Campo Vacío", JOptionPane.WARNING_MESSAGE);
                txtStock.requestFocus();
                return;
            }
            try {
                stockParaDTO = Integer.parseInt(stockStr);
                if (stockParaDTO < 0) {
                    throw new NumberFormatException("Stock negativo");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido.", "Dato Inválido", JOptionPane.WARNING_MESSAGE);
                txtStock.requestFocus();
                return;
            }
        }

        ProductoDTO productoEditadoConNuevosDatos = null;
        Long idDelProductoAEditar = this.productoSeleccionadoParaEditar.getId();

        if ("CONTENEDOR".equals(tipoOriginalDetectado)) {
            String volumenStr = txtVolumen.getText().trim();
            if (volumenStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El campo 'Volumen' es obligatorio.", "Campo Vacío", JOptionPane.WARNING_MESSAGE);
                txtVolumen.requestFocus();
                return;
            }
            try {
                Integer volumen = Integer.parseInt(volumenStr);
                if (volumen <= 0) {
                    throw new NumberFormatException("Volumen no positivo");
                }
                productoEditadoConNuevosDatos = new ContenedorDTO(volumen, idDelProductoAEditar, codigoOriginal, nombre, precio, stockParaDTO);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido.", "Dato Inválido", JOptionPane.WARNING_MESSAGE);
                txtVolumen.requestFocus();
                return;
            }
        } else if ("LLENADO".equals(tipoOriginalDetectado)) {
            String litrosStr = txtLitros.getText().trim();
            if (litrosStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El campo 'Litros' es obligatorio.", "Campo Vacío", JOptionPane.WARNING_MESSAGE);
                txtLitros.requestFocus();
                return;
            }
            String codigoContAsociadoForm = null;
            Object contSelObj = cmbxContenedor.getSelectedItem();
            if (contSelObj != null && !contSelObj.toString().equals(PLACEHOLDER_CONTENEDOR)) {
                if (contSelObj instanceof ProductoDTO) {
                    codigoContAsociadoForm = ((ProductoDTO) contSelObj).getCodigo();
                } else {
                    codigoContAsociadoForm = contSelObj.toString();
                }
            }
            try {
                Integer litros = Integer.parseInt(litrosStr);
                if (litros <= 0) {
                    throw new NumberFormatException("Litros no positivos");
                }
                productoEditadoConNuevosDatos = new LlenadoDTO(litros, codigoContAsociadoForm, idDelProductoAEditar, codigoOriginal, nombre, precio);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido.", "Dato Inválido", JOptionPane.WARNING_MESSAGE);
                txtLitros.requestFocus();
                return;
            }
        } else if ("VARIADO".equals(tipoOriginalDetectado) || "PRODUCTO_BASE".equals(tipoOriginalDetectado)) {
            productoEditadoConNuevosDatos = new VariadoDTO(idDelProductoAEditar, codigoOriginal, nombre, precio, stockParaDTO);
        }

        if (productoEditadoConNuevosDatos == null) {
            JOptionPane.showMessageDialog(this, "Error al actualizar, inténtelo de nuevo.", "Error Interno", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            subsistemaInventarioFacade.guardarCambiosProducto(productoEditadoConNuevosDatos);
            JOptionPane.showMessageDialog(this, "El producto se ha actualizado exitosamente.", "Actualización Exitosa", JOptionPane.INFORMATION_MESSAGE);

            cargarListaDeProductosEn_cmbxProductos2();
            limpiarYDeshabilitarFormularioDetalles();
            if (cmbxProductos.getItemCount() > 0) {
                cmbxProductos.setSelectedIndex(0);
            }

        } catch (SubsistemaInventarioException e) {
            JOptionPane.showMessageDialog(this, "No se pudo guardar los cambios del producto, inténtelo de nuevo.","Error al Guardar", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar, inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        char c = evt.getKeyChar();
        String currentText = txtPrecio.getText();

        if (Character.isDigit(c)) {
            return;
        }

        if (c == '.' && !currentText.contains(".")) {
            return;
        }

        if (c == KeyEvent.VK_BACK_SPACE) {
            return;
        }

        evt.consume();
    }

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();

        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
        PantallaGestionarInventario pantallaInventario = new PantallaGestionarInventario(this, usuario);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cmbxProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbxProductosActionPerformed

    }//GEN-LAST:event_cmbxProductosActionPerformed

    private void cmbxProductos2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbxProductos2ItemStateChanged

    }//GEN-LAST:event_cmbxProductos2ItemStateChanged

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void inicializarComponentesAdicionales() {
        this.setTitle("SGVAPV - Editar Producto"); // Título
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        cargarListaDeProductosEn_cmbxProductos2();
        cargarContenedoresExistentes();

        cmbxProductos2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbxProductos2_ItemStateChanged(evt);
            }
        });

        // Key Listeners (sin cambios)
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validarInputNumericoDecimal(evt, txtPrecio);
            }
        });
        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validarInputNumericoEntero(evt);
            }
        });
        txtLitros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validarInputNumericoEntero(evt);
            }
        });
        txtVolumen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validarInputNumericoEntero(evt);
            }
        });

        limpiarYDeshabilitarFormularioDetalles();
    }

    private void cargarListaDeProductosEn_cmbxProductos2() {
        System.out.println("[UI] PantallaEditar: Intentando cargar productos en cmbxProductos2...");
        try {
            List<ProductoDTO> listaProductos = subsistemaInventarioFacade.obtenerTodosLosProductos();

            System.out.println("[UI] PantallaEditar: Fachada devolvió listaProductos. Es null? " + (listaProductos == null));
            if (listaProductos != null) {
                System.out.println("[UI] PantallaEditar: Número de productos DTO recibidos: " + listaProductos.size()); 
                if (!listaProductos.isEmpty()) {
                    for (int i = 0; i < Math.min(3, listaProductos.size()); i++) {
                        ProductoDTO p = listaProductos.get(i);
                        System.out.println("[UI] PantallaEditar: DTO[" + i + "]: " + p.toString() + " (ID: " + p.getId() + ")");
                    }
                }
            }

            DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>();
            model.addElement(PLACEHOLDER_PRODUCTO_EDITAR);

            if (listaProductos != null && !listaProductos.isEmpty()) {
                for (ProductoDTO producto : listaProductos) {
                    model.addElement(producto);
                }
            }
            cmbxProductos2.setModel(model);
            System.out.println("[UI] PantallaEditar: Modelo asignado a cmbxProductos2.");

        } catch (SubsistemaInventarioException e) {
            System.err.println("[UI ERROR] PantallaEditar: SubsistemaInventarioException al cargar lista: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar la lista de productos: " + e.getMessage(), "Error de Carga", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            System.err.println("[UI ERROR] PantallaEditar: Exception general al cargar lista: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error inesperado al cargar productos.", "Error Crítico", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cmbxProductos2_ItemStateChanged(java.awt.event.ItemEvent evt) {
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Object itemSeleccionado = cmbxProductos2.getSelectedItem();

            if (itemSeleccionado instanceof ProductoDTO) {
                ProductoDTO productoResumen = (ProductoDTO) itemSeleccionado;
                if (productoResumen.getId() == null) {
                    JOptionPane.showMessageDialog(this, "Error: Producto seleccionado sin ID.", "Error de Datos", JOptionPane.ERROR_MESSAGE);
                    limpiarYDeshabilitarFormularioDetalles();
                    return;
                }
                try {
                    this.productoSeleccionadoParaEditar = subsistemaInventarioFacade.obtenerProductoParaEdicion(productoResumen.getId());
                    if (this.productoSeleccionadoParaEditar != null) {
                        cargarDatosProductoEnFormulario(this.productoSeleccionadoParaEditar);
                        habilitarFormularioDetalles(true);
                        txtCodigo.setEditable(false);
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudieron cargar detalles del producto.", "Error", JOptionPane.ERROR_MESSAGE);
                        limpiarYDeshabilitarFormularioDetalles();
                    }
                } catch (SubsistemaInventarioException e) {
                    JOptionPane.showMessageDialog(this, "Error al cargar detalles del producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    limpiarYDeshabilitarFormularioDetalles();
                }
            } else { // Placeholder seleccionado en cmbxProductos2
                this.productoSeleccionadoParaEditar = null;
                limpiarYDeshabilitarFormularioDetalles();
            }
        }
    }

    private void cargarDatosProductoEnFormulario(ProductoDTO producto) {
        if (producto == null) {
            return;
        }
        System.out.println("[UI DEBUG] cargarDatosProductoEnFormulario para: " + producto.getCodigo() + ", Tipo DTO: " + producto.getClass().getSimpleName());

        txtNombre.setText(producto.getNombre());
        txtCodigo.setText(producto.getCodigo());
        txtPrecio.setText(String.valueOf(producto.getPrecio()));
        txtStock.setText("");
        txtLitros.setText("");
        txtVolumen.setText("");
        if (cmbxContenedor.getItemCount() > 0) {
            cmbxContenedor.setSelectedIndex(0);
        }
        String tipoDetectado = "";

        if (producto instanceof ContenedorDTO) {
            tipoDetectado = "CONTENEDOR";
            ContenedorDTO cDto = (ContenedorDTO) producto;
            txtStock.setText(cDto.getCantidad() != null ? String.valueOf(cDto.getCantidad()) : "0");
            txtVolumen.setText(String.valueOf(cDto.getVolumen()));
        } else if (producto instanceof LlenadoDTO) {
            tipoDetectado = "LLENADO";
            LlenadoDTO lDto = (LlenadoDTO) producto;
            txtLitros.setText(String.valueOf(lDto.getLitros()));

            if (lDto.getCodigoContenedorAsociado() != null && !lDto.getCodigoContenedorAsociado().isEmpty()) {
                boolean encontrado = false;
                for (int i = 0; i < cmbxContenedor.getModel().getSize(); i++) {
                    Object item = cmbxContenedor.getModel().getElementAt(i);
                    if (item instanceof ProductoDTO) {
                        if (((ProductoDTO) item).getCodigo().equals(lDto.getCodigoContenedorAsociado())) {
                            cmbxContenedor.setSelectedIndex(i);
                            encontrado = true;
                            break;
                        }
                    }
                }
                if (!encontrado) {
                    cmbxContenedor.setSelectedItem(PLACEHOLDER_CONTENEDOR);
                }
            } else {
                cmbxContenedor.setSelectedItem(PLACEHOLDER_CONTENEDOR);
            }
        } else if (producto instanceof VariadoDTO) {
            tipoDetectado = "VARIADO";
            VariadoDTO vDto = (VariadoDTO) producto;
            txtStock.setText(vDto.getCantidad() != null ? String.valueOf(vDto.getCantidad()) : "0");
        } else {
            tipoDetectado = "PRODUCTO_BASE";
            if (producto.getCantidad() != null) {
                txtStock.setText(String.valueOf(producto.getCantidad()));
            }
        }
        configurarVisibilidadCamposTipo(tipoDetectado);
    }

    private void limpiarYDeshabilitarFormularioDetalles() {
        System.out.println("[UI DEBUG] Limpiando y deshabilitando formulario.");
        txtNombre.setText("");
        txtCodigo.setText("");
        txtStock.setText("");
        txtPrecio.setText("");
        txtLitros.setText("");
        txtVolumen.setText("");

        if (cmbxProductos2.getItemCount() > 0) {
            cmbxProductos2.setSelectedIndex(0);
        }

        configurarVisibilidadCamposTipo(PLACEHOLDER_PRODUCTO_EDITAR);

        if (cmbxContenedor.getItemCount() > 0) {
            cmbxContenedor.setSelectedIndex(0);
        }
        habilitarFormularioDetalles(false);
        btnEditar.setEnabled(false);
    }

    private void habilitarFormularioDetalles(boolean habilitar) {
        txtNombre.setEditable(habilitar);
        txtCodigo.setEditable(false);
        txtPrecio.setEditable(habilitar);
        cmbxProductos2.setEnabled(true);

        txtStock.setEditable(habilitar && txtStock.isVisible());
        txtLitros.setEditable(habilitar && txtLitros.isVisible());
        txtVolumen.setEditable(habilitar && txtVolumen.isVisible());
        cmbxContenedor.setEnabled(habilitar && cmbxContenedor.isVisible());
        btnEditar.setEnabled(habilitar);
    }

    private void cargarContenedoresExistentes() {
        try {
            List<ProductoDTO> contenedores = subsistemaInventarioFacade.obtenerProductosPorTipo(Arrays.asList("CONTENEDOR"));
            DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>();
            model.addElement(PLACEHOLDER_CONTENEDOR);

            if (contenedores != null && !contenedores.isEmpty()) {
                for (ProductoDTO prod : contenedores) {
                    model.addElement(prod);
                }
            }
            cmbxContenedor.setModel(model);
        } catch (Exception e) {
            System.err.println("Error inesperado al cargar contenedores existentes: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error inesperado al cargar lista de contenedores.", "Error Crítico", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void cargarTiposDeProducto() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement(PLACEHOLDER_TIPO);
        model.addElement("CONTENEDOR");
        model.addElement("LLENADO");
        model.addElement("VARIADO");
        cmbxProductos2.setModel(model);
    }

    private void configurarVisibilidadCamposTipo(String tipoProductoDeterminado) {
        System.out.println("[UI DEBUG] configurarVisibilidadCamposTipo para tipo: '" + tipoProductoDeterminado + "'");

        boolean esLlenado = "LLENADO".equals(tipoProductoDeterminado);
        boolean esContenedor = "CONTENEDOR".equals(tipoProductoDeterminado);
        boolean esVariado = "VARIADO".equals(tipoProductoDeterminado) || "PRODUCTO_BASE".equals(tipoProductoDeterminado);

        boolean esFormularioActivoParaEdicion = (this.productoSeleccionadoParaEditar != null && btnEditar.isEnabled());

        boolean mostrarStock = esContenedor || esVariado;
        jLabel8.setVisible(mostrarStock);
        txtStock.setVisible(mostrarStock);
        txtStock.setEditable(mostrarStock && esFormularioActivoParaEdicion);
        if (!mostrarStock) {
            txtStock.setText("");
        }

        lblLitros.setVisible(esLlenado);
        txtLitros.setVisible(esLlenado);
        txtLitros.setEditable(esLlenado && esFormularioActivoParaEdicion);
        if (!esLlenado) {
            txtLitros.setText("");
        }

        lblContenedor.setVisible(esLlenado);
        cmbxContenedor.setVisible(esLlenado);
        cmbxContenedor.setEnabled(esLlenado && esFormularioActivoParaEdicion);
        if (!esLlenado && cmbxContenedor.getItemCount() > 0) {
            cmbxContenedor.setSelectedItem(PLACEHOLDER_CONTENEDOR);
        }

        lblVolumen.setVisible(esContenedor);
        txtVolumen.setVisible(esContenedor);
        txtVolumen.setEditable(esContenedor && esFormularioActivoParaEdicion);
        if (!esContenedor) {
            txtVolumen.setText("");
        }
    }

    private void validarInputNumericoDecimal(java.awt.event.KeyEvent evt, javax.swing.JTextField campo) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != '.' && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
            evt.consume();
        }
        if (c == '.' && campo.getText().contains(".")) {
            evt.consume();
        }
    }

    private void validarInputNumericoEntero(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
            evt.consume();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JComboBox cmbxContenedor;
    private javax.swing.JComboBox<Object> cmbxProductos;
    private javax.swing.JComboBox cmbxProductos2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblContenedor;
    private javax.swing.JLabel lblLitros;
    private javax.swing.JLabel lblVolumen;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtLitros;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtVolumen;
    // End of variables declaration//GEN-END:variables
}
