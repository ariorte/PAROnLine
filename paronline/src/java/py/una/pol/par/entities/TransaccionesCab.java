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
public class TransaccionesCab {
    private int idTransaccion;
    private String fecha;
    private int idUsuario;
    private int total;
    private String direccionEnvio;
    private char idMedioPago;
    private int nroTarjeta;
    private char estado;

    public TransaccionesCab() {
    }

    public TransaccionesCab(int idTransaccion, String fecha, int idUsuario, 
                            int total, String direccionEnvio, char idMedioPago,
                            int nroTarjeta, char estado) {
        this.idTransaccion = idTransaccion;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
        this.total = total;
        this.direccionEnvio = direccionEnvio;
        this.idMedioPago = idMedioPago;
        this.nroTarjeta = nroTarjeta;
        this.estado = estado;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public char getIdMedioPago() {
        return idMedioPago;
    }

    public void setIdMedioPago(char idMedioPago) {
        this.idMedioPago = idMedioPago;
    }

    public int getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(int nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "TransaccionesCab{" + "idTransaccion=" + idTransaccion + 
                ", fecha=" + fecha + ", idUsuario=" + idUsuario + ", total="
                + total + ", direccionEnvio=" + direccionEnvio + 
                ", idMedioPago=" + idMedioPago + ", nroTarjeta=" + nroTarjeta +
                ", estado=" + estado + '}';
    } 
}
