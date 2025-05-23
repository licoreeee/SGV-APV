package vistas;

import dtos.EncargadoDTO;
import dtos.UsuarioDTO;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.itson.subsistemainventario_sgvapv.ISubsistemaInventarioFacade;
import org.itson.subsistemainventario_sgvapv.SubsistemaInventarioFacade;

/**
 *
 * @author Dell
 */
public class PantallaMenu extends javax.swing.JFrame {

    private UsuarioDTO usuario;
    private JFrame parent;

    /**
     * Creates new form PantallaInicioSesion
     *
     * @param usuario
     * @param parent
     */
    public PantallaMenu(JFrame parent, UsuarioDTO usuario) {
        initComponents();
        setEnabled(true);
        this.setVisible(true);
        this.setTitle("Sistema General de Ventas de Agua Purificada del Valle — Menú");
        this.parent = parent;
        this.usuario = usuario;

        inventario = new SubsistemaInventarioFacade();

        String[] partesNombre = usuario.getNombre().split(" ");

        lblNombreUsuario.setText("¡Hola, " + partesNombre[0] + "!");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        lblNombreUsuario1 = new javax.swing.JLabel();
        btnReporteVentas = new javax.swing.JButton();
        btnVentaProductoVariado = new javax.swing.JButton();
        btnVentaAgua = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnGestionarInventario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(196, 216, 255));
        setEnabled(false);
        setPreferredSize(new java.awt.Dimension(720, 480));
        setResizable(false);
        setSize(new java.awt.Dimension(720, 480));

        jPanel2.setBackground(new java.awt.Color(196, 216, 255));

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

        lblNombreUsuario.setFont(new java.awt.Font("Afacad", 1, 30)); // NOI18N
        lblNombreUsuario.setText("Hola, Diego");

        lblNombreUsuario1.setFont(new java.awt.Font("Afacad", 1, 20)); // NOI18N
        lblNombreUsuario1.setText("¿QUÉ DESEAS HACER?");

        btnReporteVentas.setBackground(new java.awt.Color(41, 136, 194));
        btnReporteVentas.setFont(new java.awt.Font("Afacad", 1, 23)); // NOI18N
        btnReporteVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Financial Dynamic Presentation.png"))); // NOI18N
        btnReporteVentas.setText("GENERAR REPORTE DE VENTAS");
        btnReporteVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteVentasActionPerformed(evt);
            }
        });

        btnVentaProductoVariado.setBackground(new java.awt.Color(41, 136, 194));
        btnVentaProductoVariado.setFont(new java.awt.Font("Afacad", 1, 23)); // NOI18N
        btnVentaProductoVariado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Product.png"))); // NOI18N
        btnVentaProductoVariado.setText("VENTA DE PRODUCTO VARIADO");
        btnVentaProductoVariado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaProductoVariadoActionPerformed(evt);
            }
        });

        btnVentaAgua.setBackground(new java.awt.Color(41, 136, 194));
        btnVentaAgua.setFont(new java.awt.Font("Afacad", 1, 23)); // NOI18N
        btnVentaAgua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Water drop.png"))); // NOI18N
        btnVentaAgua.setText("VENTA DE AGUA");
        btnVentaAgua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaAguaActionPerformed(evt);
            }
        });

        btnLogOut.setBackground(new java.awt.Color(41, 136, 194));
        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logout.png"))); // NOI18N
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        btnGestionarInventario.setBackground(new java.awt.Color(41, 136, 194));
        btnGestionarInventario.setFont(new java.awt.Font("Afacad", 1, 23)); // NOI18N
        btnGestionarInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Warehouse.png"))); // NOI18N
        btnGestionarInventario.setText("GESTIONAR INVENTARIO");
        btnGestionarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarInventarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblNombreUsuario)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVentaAgua, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReporteVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGestionarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVentaProductoVariado, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLogOut, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(lblNombreUsuario1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(110, 110, 110)
                    .addComponent(jLabel3)
                    .addContainerGap(610, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogOut)
                    .addComponent(lblNombreUsuario))
                .addGap(14, 14, 14)
                .addComponent(lblNombreUsuario1)
                .addGap(18, 18, 18)
                .addComponent(btnVentaAgua)
                .addGap(18, 18, 18)
                .addComponent(btnVentaProductoVariado)
                .addGap(18, 18, 18)
                .addComponent(btnGestionarInventario)
                .addGap(18, 18, 18)
                .addComponent(btnReporteVentas)
                .addContainerGap(83, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(67, 67, 67)
                    .addComponent(jLabel3)
                    .addContainerGap(433, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        PantallaInicioSesion pantallaInicio = new PantallaInicioSesion();
        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnReporteVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteVentasActionPerformed
        if (usuario instanceof EncargadoDTO) {
            this.dispose();
            PantallaGenerarReporte pantallaReporte = new PantallaGenerarReporte(this, (EncargadoDTO) usuario);
            pantallaReporte.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No cuentas con los permisos necesarios para acceder.",
                "Error de permisos.", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnReporteVentasActionPerformed

    private void btnGestionarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarInventarioActionPerformed
        this.dispose();
        PantallaGestionarInventario pantallaInventario = new PantallaGestionarInventario(this, usuario);
    }//GEN-LAST:event_btnGestionarInventarioActionPerformed

    private void btnVentaProductoVariadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaProductoVariadoActionPerformed
        if (!inventario.obtenerProductosPorTipo(List.of("Variado")).isEmpty()) {
            this.dispose();
            PantallaVenta pantallaVenta = new PantallaVenta(this, usuario);
            pantallaVenta.setTipoVenta("PRODUCTO VARIADO");
        } else {
            JOptionPane.showMessageDialog(this, "No hay productos para hacer la venta.",
                "Error.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVentaProductoVariadoActionPerformed

    private void btnVentaAguaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaAguaActionPerformed
        if (!inventario.obtenerProductosPorTipo(List.of("Contenedor", "Llenado")).isEmpty()) {
            this.dispose();
            PantallaVenta pantallaVenta = new PantallaVenta(this, usuario);
            pantallaVenta.setTipoVenta("AGUA PURIFICADA");
        } else {
            JOptionPane.showMessageDialog(this, "No hay productos para hacer la venta.",
                "Error.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVentaAguaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGestionarInventario;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnReporteVentas;
    private javax.swing.JButton btnVentaAgua;
    private javax.swing.JButton btnVentaProductoVariado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblNombreUsuario1;
    // End of variables declaration//GEN-END:variables
    private ISubsistemaInventarioFacade inventario;
}
