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
public class Categoría {
    private int idCategoria;
    private String descripcion;

    /**
     * Constructor de la clase Categoría sin parámetros
     */
    public Categoría() {
    }

    /***
     * Constructor de la Categoría con parámetros:
     * @param idCategoria del tipo int
     * @param descripcion del tipo String
     */
    public Categoría(int idCategoria, String descripcion) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
    }

    /**
     * Función de la clase Categoría.
     * @return un valor del tipo int que corresponde al idCategoria.
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * Procedimiento para asignar un valor a la variable idCategoria.
     * @param idCategoria debe ser del tipo int.
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * Función de la clase Categoría.
     * @return un valor del tipo String que representa la descripcion de la
     * categoría.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Procedimiento para asignar una cadena de texto a la variable descripcion
     * @param descripcion es del tipo String que va a contener la cadena de
     * texto que se le pasa a este procedimiento.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Categor\u00eda{" + "idCategoria=" + idCategoria + 
                ", descripcion=" + descripcion + '}';
    }    
}
