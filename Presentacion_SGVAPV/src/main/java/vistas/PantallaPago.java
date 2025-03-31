package vistas;

import dtos.UsuarioDTO;
import dtos.VentaDTO;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import org.itson.subsistemaventas_sgvapv.ISubsistemaVentasFacade;
import org.itson.subsistemaventas_sgvapv.SubsistemaVentasFacade;
import utilidades.FormatoDinero;

/**
 *
 * @author Dell
 */
public class PantallaPago extends javax.swing.JFrame {

    private UsuarioDTO usuario;
    private String tipoVenta;
    private Float totalVenta;
    private VentaDTO venta;
    private JFrame parent;
    private FormatoDinero fd = new FormatoDinero();
    private ISubsistemaVentasFacade subsistemaVentasFacade = new SubsistemaVentasFacade();

    /**
     * Creates new form PantallaInicioSesion
     */
    public PantallaPago(VentaDTO venta, JFrame parent, UsuarioDTO usuario) {
        initComponents();
        this.venta = venta;
        this.parent = parent;
        setEnabled(true);
        setVisible(true);
        this.setTitle("SGVAPV - Pago");
        txtTotal.setEditable(false);
        txtCambio.setEditable(false);
        totalVenta = venta.getTotal();
        this.usuario = usuario;

        txtTotal.setText(fd.formatear(totalVenta));
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnTerminar = new javax.swing.JButton();
        txtPago = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblTipoVenta = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtCambio = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(196, 216, 255));
        setEnabled(false);
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

        jLabel4.setFont(new java.awt.Font("Afacad", 1, 23)); // NOI18N
        jLabel4.setText("TOTAL");

        jLabel5.setFont(new java.awt.Font("Afacad", 1, 23)); // NOI18N
        jLabel5.setText("PAGO");

        btnTerminar.setBackground(new java.awt.Color(41, 136, 194));
        btnTerminar.setFont(new java.awt.Font("Afacad", 1, 23)); // NOI18N
        btnTerminar.setText("TERMINAR");
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });

        txtPago.setFont(new java.awt.Font("Afacad", 1, 20)); // NOI18N
        txtPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPagoKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Afacad", 1, 30)); // NOI18N
        jLabel3.setText("REALIZAR PAGO");

        lblTipoVenta.setFont(new java.awt.Font("Afacad", 1, 20)); // NOI18N
        lblTipoVenta.setText("AGUA PURIFICADA");

        jLabel6.setFont(new java.awt.Font("Afacad", 1, 23)); // NOI18N
        jLabel6.setText("CAMBIO");

        txtTotal.setFont(new java.awt.Font("Afacad", 1, 20)); // NOI18N
        txtTotal.setFocusable(false);

        txtCambio.setFont(new java.awt.Font("Afacad", 1, 20)); // NOI18N
        txtCambio.setFocusable(false);

        btnCancelar.setFont(new java.awt.Font("Afacad", 1, 23)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(lblTipoVenta))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTotal)
                            .addComponent(txtCambio)
                            .addComponent(txtPago, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(148, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(84, 84, 84)
                .addComponent(btnTerminar)
                .addGap(164, 164, 164))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTipoVenta)
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTerminar)
                    .addComponent(btnCancelar))
                .addGap(48, 48, 48))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 720, 420));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
        if (!txtCambio.getText().isBlank()) {
            venta.setFechaHora(new GregorianCalendar());
            subsistemaVentasFacade.realizarVenta(venta);
            this.dispose();
            parent.dispose();
            JOptionPane.showMessageDialog(this, "Se ha completado la venta exitosamente.",
                    "Venta Completada", JOptionPane.INFORMATION_MESSAGE);
            PantallaMenu pantallaMenu = new PantallaMenu(parent, usuario);
        } else {
            JOptionPane.showMessageDialog(this, "Asegúrese de ingresar una cantidad de pago válida.",
                    "Pago no Válido.", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnTerminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int seleccion = JOptionPane.showConfirmDialog(this, "¿Desea cancelar la operación?",
                "Cancelar Operación", JOptionPane.YES_NO_OPTION);
        if (seleccion == JOptionPane.YES_OPTION) {
            parent.setVisible(true);
            this.dispose();
            parent.setEnabled(true);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtPagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoKeyTyped
        int key = evt.getKeyChar();
        //Solo permitirá caracteres de números y de '/'.
        boolean nums = key >= 48 && key <= 57;
        if (!nums) {
            evt.consume();
        }
        if (txtPago.getText().trim().length() == 8) {
            evt.consume();
        }

        txtPago.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                calcularCambio();
            }

            public void removeUpdate(DocumentEvent e) {
                calcularCambio();
            }

            public void changedUpdate(DocumentEvent e) {
                calcularCambio();
            }

            private void calcularCambio() {
                try {
                    String pagoStr = txtPago.getText().trim();

                    if (pagoStr.isEmpty()) {
                        txtCambio.setText("");
                        return;
                    }

                    float pago = Float.parseFloat(pagoStr);

                    if (pago >= totalVenta) {
                        float cambio = pago - totalVenta;
                        txtCambio.setText(fd.formatear(cambio));
                    } else {
                        txtCambio.setText("");
                    }
                } catch (NumberFormatException ex) {
                    txtCambio.setText("");
                }
            }
        });
    }//GEN-LAST:event_txtPagoKeyTyped

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
        lblTipoVenta.setText(tipoVenta);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnTerminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblTipoVenta;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JTextField txtPago;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
