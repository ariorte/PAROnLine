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
import py.una.pol.par.entities.Usuarios;
import py.una.pol.par.util.conectar_db;

/**
 *
 * @author Ariel y Fabricio
 */
public class UsuarioManager {
    /*
    usuarioManager.java
			Metodo insertar
			Metodo actualizar
			Metodo eliminar
			Metodo getById
			Metodo getAll
			Metodo Login
    */
    
    
    
public UsuarioManager() {
    }

    public boolean insertar(Usuarios c) {
        boolean retValue = true;
        
        Connection conectar = null;
        PreparedStatement pstmt = null;

        try {
            conectar = conectar_db.getConnection();
            pstmt = conectar.prepareStatement("insert into usuario (id_usuario,login_name,contrasena,apellido,nombre,tipo_usuario) values (?,?,?,?,?,?)");
            pstmt.setInt(1, c.getIdUsuario() );
            pstmt.setString(2, c.getLoginName() );
            pstmt.setString(3, c.getContrasena() );
            pstmt.setString(4, c.getApellido() );
            pstmt.setString(5, c.getNombre() );
            pstmt.setByte(6, c.getTipoUsuario() );
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

    public boolean update(Usuarios c) {
        boolean retValue = true;

        Connection conectar = null;
        PreparedStatement pstmt = null;

        try {
            conectar = conectar_db.getConnection();
            pstmt = conectar.prepareStatement("update usuario set nombre = ?, apellido = ?, login_name = ?, contrasena =  ?, tipo_usuario = ? where id_usuario = ?");
            pstmt.setString(1, c.getNombre());
            pstmt.setString(2, c.getApellido()); 
            pstmt.setString(3, c.getLoginName());
            pstmt.setString(4, c.getContrasena());
            pstmt.setInt(5, c.getTipoUsuario());
            pstmt.setInt(6, c.getIdUsuario());
            
            pstmt.execute();

        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(CategoriaManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conectar_db.closeConnection(conectar);
        }

        return retValue;
    }

    public boolean delete(Usuarios c) {
        boolean retValue = true;

        Connection conectar = null;
        PreparedStatement pstmt = null;
        
        try {
            conectar = conectar_db.getConnection();
            pstmt = conectar.prepareStatement("delete from usuario where id_usuario = ?");
            pstmt.setInt(1, c.getIdUsuario() );
            pstmt.execute();

        } catch (SQLException ex) {
            retValue = false;
            Logger.getLogger(CategoriaManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conectar_db.closeConnection(conectar);
        }

        return retValue;
    }

    public Usuarios getUsuarioById(int id) {
        Usuarios retValue = null;

        Connection conectar = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conectar = conectar_db.getConnection();
            pstmt = conectar.prepareStatement("select login_name from usuario where id_usuario = ?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                retValue = new Usuarios();
                retValue.setLoginName(rs.getString(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conectar_db.closeConnection(conectar);
        }

        return retValue;
    }
    
    public Usuarios getUsuarioByIdT(int id) {
        Usuarios retValue = null;

        Connection conectar = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conectar = conectar_db.getConnection();
            pstmt = conectar.prepareStatement("select login_name, nombre, apellido, contrasena, tipo_usuario,id_usuario from usuario where id_usuario = ?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                retValue = new Usuarios();
                retValue.setLoginName(rs.getString(1));
                retValue.setNombre(rs.getString(2));
                retValue.setApellido(rs.getString(3));
                retValue.setContrasena(rs.getString(4));
                retValue.setTipoUsuario(rs.getByte(5));
                retValue.setIdUsuario(id);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conectar_db.closeConnection(conectar);
        }

        return retValue;
    }
    
    public int getUsuarioByLoginName(String lname) {
        int retValue = 0;
        Connection conectar = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conectar = conectar_db.getConnection();
            pstmt = conectar.prepareStatement("select tipo_usuario from usuario where login_name = ?");
            pstmt.setString(1, lname);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                retValue = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conectar_db.closeConnection(conectar);
        }

        return retValue;
    }
    
    public int getUsuarioByLoginNameID(String lname) {
        int retValue = 0;
        Connection conectar = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conectar = conectar_db.getConnection();
            pstmt = conectar.prepareStatement("select id_usuario from usuario where login_name = ?");
            pstmt.setString(1, lname);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                retValue = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conectar_db.closeConnection(conectar);
        }

        return retValue;
    }
    
    public static ArrayList<Usuarios> getAll() {
        ArrayList<Usuarios> retValue = new ArrayList<Usuarios>();

        Connection conectar = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conectar = conectar_db.getConnection();
            pstmt = conectar.prepareStatement("select id_usuario, login_name, apellido, nombre, tipo_usuario from usuario");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Usuarios c = new Usuarios();
                c.setIdUsuario(rs.getInt(1));
                c.setLoginName(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setNombre(rs.getString(4));
                c.setTipoUsuario(rs.getByte(5));
                retValue.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conectar_db.closeConnection(conectar);
        }

        return retValue;
    }
    
    public boolean LogIn(String usuario, String contrasena){
        boolean retValue = true;
        Connection conectar = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        
        try {
            conectar = conectar_db.getConnection();
            pstmt = conectar.prepareStatement("select login_name, contrasena from usuario where login_name= ? and contrasena = ?");
            pstmt.setString(1, usuario );
            pstmt.setString(2, contrasena );
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return true;
            }

        } catch (Exception ex) {
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
        

        return false;
    
    }
    
    /*public static void main(String[] args) {
        UsuarioManager o = new UsuarioManager();
        String user = "jaquino";
        System.out.println(o.LogIn(user,"1234"));
        System.out.println(o.getUsuarioByLoginName(user));
        System.out.println(o.getAll());
        ArrayList<Usuarios> userlist = o.getAll();
        for (Usuarios u : userlist) {
                System.out.println(u.getLoginName());
                System.out.println(u.getIdUsuario());
        
        }
    }*/
}



    
    
