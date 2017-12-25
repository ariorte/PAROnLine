/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.par.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import py.una.pol.par.entities.Productos;
import py.una.pol.par.entities.Usuarios;
import py.una.pol.par.util.conectar_db;


/**
 *
 * @author Ariel y Fabricio
 */
public class BuscadorManager {

    public BuscadorManager() {
    }
    
    public Productos buscarya(String buscado) {
        Productos retValue = new Productos();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
//$sql = "SELECT * FROM prov_tab WHERE provincia LIKE '%" .$busqueda. "%' ORDER BY provincia";
        try {
            conn = conectar_db.getConnection();
            pstmt = conn.prepareStatement("select id_producto, cantidad, descripcion, preciounit, nombre_img, id_categoria from productos where descripcion = ? ");
            pstmt.setString(1, buscado);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                retValue.setId_producto(rs.getString(1));
                retValue.setCantidad(rs.getInt(2));
                retValue.setDescripcion(rs.getString(3));
                retValue.setPrecioUnit(rs.getInt(4));
                retValue.setNombre_img(rs.getString(5));
                retValue.setId_categoria(rs.getString(6));
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conectar_db.closeConnection(conn);
        }

        return retValue;
    }
    
}
