package vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SelectorProductos extends JFrame {

    private JComboBox<String> comboBox;
    private JPanel panelSeleccionados;
    private Set<String> productosSeleccionados = new LinkedHashSet<>();

    public SelectorProductos() {
        setTitle("Selector de Productos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Lista de productos (puedes cargarla desde tu backend)
        String[] productos = {"Producto A", "Producto B", "Producto C", "Producto D"};

        // ComboBox
        comboBox = new JComboBox<>(productos);
        comboBox.setSelectedIndex(-1); // No seleccionado por defecto
        comboBox.addActionListener(e -> agregarProductoSeleccionado());

        add(comboBox, BorderLayout.NORTH);

        // Panel para mostrar productos seleccionados
        panelSeleccionados = new JPanel();
        panelSeleccionados.setLayout(new FlowLayout(FlowLayout.LEFT));
        JScrollPane scroll = new JScrollPane(panelSeleccionados);
        scroll.setPreferredSize(new Dimension(380, 200));
        add(scroll, BorderLayout.CENTER);
    }

    private void agregarProductoSeleccionado() {
        String producto = (String) comboBox.getSelectedItem();
        if (producto != null && productosSeleccionados.add(producto)) {
            JLabel etiqueta = new JLabel(producto);
            etiqueta.setOpaque(true);
            etiqueta.setBackground(new Color(200, 230, 255));
            etiqueta.setBorder(BorderFactory.createLineBorder(Color.BLUE));
            etiqueta.setToolTipText("Haz clic para eliminar");
            etiqueta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            etiqueta.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    panelSeleccionados.remove(etiqueta);
                    productosSeleccionados.remove(producto);
                    panelSeleccionados.revalidate();
                    panelSeleccionados.repaint();
                }
            });

            panelSeleccionados.add(etiqueta);
            panelSeleccionados.revalidate();
            panelSeleccionados.repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SelectorProductos().setVisible(true));
    }
}
