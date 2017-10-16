/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.par.entities;

/**
 *
 * @author ari
 */
public class Producto {
    private int idProducto;
    private String descripcion;
    private int idCategoria;
    private int precioUnitario;
    private int cantidad;

    /**
     * Constructor de la clase Producto sin parámetros.
     */
    public Producto() {
    }

    /**
     * Constructor de la clase Producto con parámetros.
     * @param idProducto parámetro del tipo int.
     * @param descripcion parámetro del tipo String.
     * @param idCategoria parámetro del tipo int.
     * @param precioUnitario parámetro del tipo int.
     * @param cantidad parámetro del tipo int.
     */
    public Producto(int idProducto, String descripcion, int idCategoria, 
                    int precioUnitario, int cantidad) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.idCategoria = idCategoria;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    /**
     * Función que retorna un valor int.
     * @return el idProducto.
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * Procedimiento para asignar una id producto a la propiedad idProducto.
     * @param idProducto del tipo int que se va a asignar a la propiedad.
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * Función que retorna un valor String.
     * @return la descripcion.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Procedimiento para asignar una descripcion a la propiedad descripcion.
     * @param descripcion del tipo string que contiene el texto por asignar.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Función que retorna un valor del tipo int.
     * @return el idCategoria.
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * Procedimiento para asignar el id categoria a la propiedad idCategoria.
     * @param idCategoria del tipo que contendrá el valor por asignar.
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * Procedimiento que retorna un valor del tipo int.
     * @return el precio unitario.
     */
    public int getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Procedimiento para asignar un precio unitario a la propiedad
     * precioUnitario.
     * @param precioUnitario del tipo int que se espera recibir.
     */
    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    /**
     * Función para recuperar la cantidad.
     * @return un valor del tipo int que representa la cantidad.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Procedimiento para asignar una cantidad a la propiedad de la cantidad de
     * la clase Producto.
     * @param cantidad del tipo int que contendrá un valor que se le pasa.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", descripcion=" + 
                descripcion + ", idCategoria=" + idCategoria + 
                ", precioUnitario=" + precioUnitario + ", cantidad=" + cantidad
                + '}';
    }
    
    
}
