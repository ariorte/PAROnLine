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
public class Usuario {
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String loginName;
    private String contrasenha;
    private char tipoUsuario;

    /***
     * Constructor de la clase Usuarios sin parámetros.
     */
    public Usuario() {
    }

    /***
     * Constructor de la clase Usuarios con parámetros.
     * @param idUsuario del tipo int.
     * @param nombre del tipo string.
     * @param apellido del tipo string.
     * @param loginName del tipo string.
     * @param contrasenha del tipo string.
     * @param tipoUsuario del tipo char.
     */
    public Usuario(int idUsuario, String nombre, String apellido, 
                    String loginName, String contrasenha, char tipoUsuario) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.loginName = loginName;
        this.contrasenha = contrasenha;
        this.tipoUsuario = tipoUsuario;
    }

    /***
     * Función que retorna un int.
     * @return el idUsuario.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /***
     * Procedimiento para asignar el id usuario a la propiedad idUsuario.
     * @param idUsuario del tipo int que contiene el valor por asignar.
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /***
     * Función que retorna un string.
     * @return el nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /***
     * Procedimiento para asignar el nombre a la propiedad nombre.
     * @param nombre del tipo string que contiene el texto por asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /***
     * Función que retorna un string.
     * @return el apellido.
     */
    public String getApellido() {
        return apellido;
    }

    /***
     * Procedimiento para asignar el apellido a la propiedad apellido.
     * @param apellido del tipo string que contiene el texto por asignar.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /***
     * Función que retorna un string.
     * @return el loginName.
     */
    public String getLoginName() {
        return loginName;
    }

    /***
     * Procedimiento para asignar un login name a la propiedad loginName.
     * @param loginName del tipo string que contiene el texto por asignar.
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /***
     * Función que retorna un string.
     * @return la contrasenha.
     */
    public String getContrasenha() {
        return contrasenha;
    }

    /***
     * Procedimiento para asignar una contraseña a la propiedad contrasenha
     * @param contrasenha del tipo string que contiene el valor por asignar.
     */
    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    /**
     * Función que retorna un valor char.
     * @return el tipo de usuario.
     */
    public char getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * Procedimiento para asignar un tipo de usuario a la propiedad tipoUsuario
     * @param tipoUsuario es del tipo char que contiene el valor por asignar.
     */
    public void setTipoUsuario(char tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "idUsuario=" + idUsuario + ", nombre=" + nombre +
                ", apellido=" + apellido + ", loginName=" + loginName +
                ", contrasenha=" + contrasenha + ", tipoUsuario=" + tipoUsuario
                + '}';
    }
}
