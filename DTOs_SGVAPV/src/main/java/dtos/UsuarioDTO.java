/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author ricar
 */
public class UsuarioDTO {

    protected String nombre;

    protected String nombreUsuario;

    protected String contrasenia;

    public UsuarioDTO(String nombre, String nombreUsuario, String contrasenia) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

}
