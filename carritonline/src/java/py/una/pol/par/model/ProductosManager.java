
 /* To change this license header, choose License Headers in Project Properties.
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
import py.una.pol.par.util.conectar_db;

/**
 *
 * @author fabricio
 */
public class ProductosManager {

    public ProductosManager() { 
    }
    
     public static ArrayList<Productos> getAll() {
        ArrayList<Productos> retValue = new ArrayList<Productos>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = conectar_db.getConnection();
            pstmt = conn.prepareStatement("select id_producto, cantidad, descripcion, preciounit, nombre_img, id_categoria from productos");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Productos p = new Productos();
                p.setId_producto(rs.getString(1));
                p.setCantidad(rs.getInt(2));
                p.setDescripcion(rs.getString(3));
                p.setPrecioUnit(rs.getInt(4));
                p.setNombre_img(rs.getString(5));
                p.setId_categoria(rs.getString(6));
                retValue.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conectar_db.closeConnection(conn);
        }

        return retValue;
    }    
     
     
     public static Productos getProductoById(String id){
 
         Connection conn = null;
         PreparedStatement ps = null;
         ResultSet rs= null;
         Productos retValue = null;
         
          try {
            conn = conectar_db.getConnection();
            ps = conn.prepareStatement("select id_producto, cantidad, descripcion, preciounit, nombre_img, id_categoria from productos  where id_producto = ?");
            ps.setString(1, id);
            rs = ps.executeQuery();  
            while (rs.next()) {
               retValue = new Productos();
               retValue.setId_producto(id);
               retValue.setCantidad(rs.getInt(2));
               retValue.setDescripcion(rs.getString(3));
               retValue.setPrecioUnit(rs.getInt(4));
               retValue.setNombre_img(rs.getString(5));
               
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conectar_db.closeConnection(conn);
        }

        return retValue;
         
    }
     
     public boolean insertar(Productos p) {
        boolean retValue = true;

        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = conectar_db.getConnection();
            pstmt = conn.prepareStatement("insert into productos (id_producto, cantidad, descripcion, preciounit, nombre_img, id_categoria) values (?,?,?,?,?,?)");
            pstmt.setString(1, p.getId_producto());
            pstmt.setInt(2, p.getCantidad());
            pstmt.setString(3, p.getDescripcion());
            pstmt.setInt(4, p.getPrecioUnit());
            pstmt.setString(5, p.getNombre_img());
            pstmt.setString(6, p.getId_categoria());
            pstmt.execute();

        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(CategoriaManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoriaManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            conectar_db.closeConnection(conn);
        }

        return retValue;
    }

    public boolean update(Productos p) {
        boolean retValue = true;

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = conectar_db.getConnection();
            pstmt = conn.prepareStatement("update productos set descripcion = ? where id_categoria = ?");
            pstmt.setString(1, p.getDescripcion());
            pstmt.setString(2, p.getId_producto());
            pstmt.execute();

        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(CategoriaManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conectar_db.closeConnection(conn);
        }

        return retValue;
    }

    public boolean delete(Productos p) {
        boolean retValue = true;

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = conectar_db.getConnection();
            pstmt = conn.prepareStatement("delete from productos where id_producto = ?");
            pstmt.setString(1, p.getId_producto());
            pstmt.execute();

        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(CategoriaManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conectar_db.closeConnection(conn);
        }

        return retValue;
    }

     
}
