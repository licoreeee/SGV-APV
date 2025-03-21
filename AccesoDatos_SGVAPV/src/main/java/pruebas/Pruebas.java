/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import entidades.Producto;
import entidades.Variado;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.accesodatos_sgvapv.conexion.Conexion;
import org.itson.accesodatos_sgvapv.conexion.IConexion;
import org.itson.accesodatos_sgvapv.daos.IProductosDAO;
import org.itson.accesodatos_sgvapv.daos.ProductosDAO;
import org.itson.accesodatos_svgapv.excepciones.PersistenciaException;

/**
 *
 * @author ricar
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IConexion conexion = new Conexion();
        IProductosDAO productosDAO = new ProductosDAO(conexion);
    }
    
}
