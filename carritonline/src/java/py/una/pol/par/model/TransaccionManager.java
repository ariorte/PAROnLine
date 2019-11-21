/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.par.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import py.una.pol.par.entities.Categoria;
import py.una.pol.par.entities.TransaccionesCab;
import py.una.pol.par.util.conectar_db;

/**
 *
 * @author Ariel y Fabricio
 */
public class TransaccionManager {
    
    
    public TransaccionManager() {
    }
    
    public boolean insertar(TransaccionesCab tc) {
        boolean retValue = true;

        Connection conectar = null;
        PreparedStatement pstmt = null;

        try {
            conectar = conectar_db.getConnection();
            pstmt = conectar.prepareStatement("insert into transaccioncab (id_usuario,fecha,total,direccion_envio,estado) values (?,?,?,?,?)");
            //pstmt.setInt(1, tc.getID_Transacción());
            pstmt.setInt(1, tc.getId_Usuario());
            pstmt.setString(2, tc.getFecha());
            pstmt.setInt(3, tc.getTotal());
            pstmt.setString(4, tc.getDireccion_de_envio());
            pstmt.setString(5, tc.getEstado());
            
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
            conectar_db.closeConnection(conectar);
        }

        return retValue;
    }

    
}
