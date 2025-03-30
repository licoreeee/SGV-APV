package vistas;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import dtos.ProductoDTO;
import dtos.ProductoVentaDTO;
import dtos.VendedorDTO;
import dtos.VentaDTO;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import utilidades.FormatoDinero;

/**
 *
 * @author Dell
 */
public class PantallaVenta extends javax.swing.JFrame {

    private String tipoVenta;
    private VentaDTO venta;
    private FormatoDinero fd = new FormatoDinero();
    private JFrame parent;
    private VendedorDTO vendedor = new VendedorDTO("Diego Valenzuela", "pipucate", "123456");

    /**
     * Creates new form PantallaInicioSesion
     */
    public PantallaVenta(JFrame parent) {
        initComponents();
        setEnabled(true);
        setVisible(true);
        this.setTitle("SGVAPV - Venta");
        this.parent = parent;
        JTableHeader header = tblProductosVenta.getTableHeader();
        Font headerFont = new Font("Afacad", Font.BOLD, 23);
        header.setFont(headerFont);
        // Mandamos a formatear la tabla y a cargar los datos.
        formatearTabla();
        lblTotal.setText("");
        this.venta = new VentaDTO();
        this.venta.setVendedor(vendedor);
    }

    /**
     * Método para darle formato a la tabla.
     */
    private void formatearTabla() {
        /**
         * +-----------------------------------------+ | | | CAMBIAR COLORES | |
         * | +-----------------------------------------+
         */
        // Cambiamos el color del fondo.
        tblProductosVenta.getTableHeader().setBackground(new Color(41, 136, 194));
        // Cambiamos la fuente y el tamaño.
        tblProductosVenta.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
        // Cambiamos el color de la letra.
        tblProductosVenta.getTableHeader().setForeground(new Color(255, 255, 255));
    }

    /**
     * Método para llenar la tabla.
     *
     * @param productoVenta Producto a agregar a la tabla.
     */
    public void cargarProducto(ProductoVentaDTO productoVenta) {
        ProductoDTO producto = productoVenta.getProducto();

        DefaultTableModel modeloTabla = (DefaultTableModel) tblProductosVenta.getModel();

        // Buscar si el producto ya está en la tabla
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            String codigoNombre = (String) modeloTabla.getValueAt(i, 0); // Código y nombre del producto en la tabla

            // Comparar con el producto que queremos agregar
            if (codigoNombre.equals(producto.getCodigo() + " - " + producto.getNombre())) {
                // Obtener la cantidad actual y sumarle la nueva cantidad
                int cantidadActual = (int) modeloTabla.getValueAt(i, 1);
                modeloTabla.setValueAt(cantidadActual + productoVenta.getCantidad(), i, 1);
                return; // Salir del método, ya que solo necesitamos actualizar la cantidad
            }
        }

        // Si no existe en la tabla, agregar una nueva fila
        Object[] fila = new Object[4];
        fila[0] = producto.getCodigo() + " - " + producto.getNombre();
        fila[1] = productoVenta.getCantidad();
        fila[2] = fd.formatear(producto.getPrecio());

        modeloTabla.addRow(fila);

        actualizarVenta(productoVenta);
    }

    private void actualizarVenta(ProductoVentaDTO productoVenta) {
        lblTotal.setText(fd.formatear(venta.getTotal()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        lblTipoVenta = new javax.swing.JLabel();
        btnTerminar = new javax.swing.JButton();
        btnBuscarProducto = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductosVenta = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(196, 216, 255));
        setEnabled(false);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                .addContainerGap(30, Short.MAX_VALUE))
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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 70));

        jPanel2.setBackground(new java.awt.Color(196, 216, 255));

        jLabel3.setFont(new java.awt.Font("Afacad", 1, 30)); // NOI18N
        jLabel3.setText("REGISTRAR VENTA");

        btnCancelar.setFont(new java.awt.Font("Afacad", 1, 23)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblTipoVenta.setFont(new java.awt.Font("Afacad", 1, 20)); // NOI18N
        lblTipoVenta.setText("AGUA PURIFICADA");

        btnTerminar.setBackground(new java.awt.Color(41, 136, 194));
        btnTerminar.setFont(new java.awt.Font("Afacad", 1, 23)); // NOI18N
        btnTerminar.setText("TERMINAR");
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });

        btnBuscarProducto.setFont(new java.awt.Font("Afacad", 1, 23)); // NOI18N
        btnBuscarProducto.setText("BUSCAR PRODUCTO");
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblProductosVenta.setFont(new java.awt.Font("Afacad", 1, 23)); // NOI18N
        tblProductosVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCTO", "CANTIDAD", "PRECIO"
            }
        ));
        tblProductosVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblProductosVentaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductosVenta);

        jLabel4.setFont(new java.awt.Font("Afacad", 1, 23)); // NOI18N
        jLabel4.setText("TOTAL");

        lblTotal.setFont(new java.awt.Font("Afacad", 1, 23)); // NOI18N
        lblTotal.setText("0.0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotal)
                .addGap(16, 16, 16))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblTotal))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnBuscarProducto)
                        .addGap(91, 91, 91)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnTerminar)))
                .addGap(15, 15, 15))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(lblTipoVenta)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTipoVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnTerminar)
                    .addComponent(btnBuscarProducto))
                .addGap(14, 14, 14))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 720, 420));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        parent.setVisible(true);
        venta = null;
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
        if (tblProductosVenta.getRowCount() != 0) {
            this.dispose();
            PantallaPago pantallaPago = new PantallaPago(venta, this);
            pantallaPago.setTipoVenta(this.getTipoVenta());
        } else {
            JOptionPane.showConfirmDialog(this, "Agregue productos para poder realizar la venta.", "Venta inválida", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnTerminarActionPerformed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        PantallaAgregarProducto pantallaAgregarProducto = new PantallaAgregarProducto(this, venta);
        pantallaAgregarProducto.setTipoVenta(this.getTipoVenta());
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void tblProductosVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProductosVentaKeyPressed
        int selectedRow = tblProductosVenta.getSelectedRow();
        if (selectedRow != -1) { // Verifica que haya una fila seleccionada
            int cantidad = (int) tblProductosVenta.getValueAt(selectedRow, 1);

            String codigoNombre = (String) tblProductosVenta.getValueAt(selectedRow, 0);
            String codigo;
            if (evt.getKeyChar() == '+') { // Si presiona "+"
                int index = codigoNombre.indexOf(" -");
                if (index != -1) {
                    codigo = codigoNombre.substring(0, index); // Extrae todo antes de " -"
                }

                tblProductosVenta.setValueAt(cantidad + 1, selectedRow, 2);
            } else if (evt.getKeyChar() == '-') { // Si presiona "-"
                if (cantidad > 0) { // Evita valores negativos
                    tblProductosVenta.setValueAt(cantidad - 1, selectedRow, 2);
                }
            }
        }
    }//GEN-LAST:event_tblProductosVentaKeyPressed

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
        lblTipoVenta.setText(tipoVenta);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnTerminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTipoVenta;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblProductosVenta;
    // End of variables declaration//GEN-END:variables

}
