/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author ricar
 */
public class ProductoVentaDTO {
    
    private Float precio;
    
    private Integer cantidad;
    
    private ProductoDTO producto;

    public ProductoVentaDTO(Float precio, Integer cantidad, ProductoDTO producto) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public void aumentarCantidad() {
        if (cantidad < producto.getCantidad()) {
            cantidad++;
        }
    } 

    public void disminuirCantidad() {
        if (cantidad > 0) {
            cantidad--;
        }
    }
}
