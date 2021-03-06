/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.par.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import py.una.pol.par.entities.Categoria;
import py.una.pol.par.model.CategoriaManager;
import py.una.pol.par.entities.Usuarios;
import py.una.pol.par.model.UsuarioManager;
import py.una.pol.par.util.Md5Java;

/**
 *
 * @author Ariel
 */
public class UsuariosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vaccion = request.getParameter("vaccion");
        request.setAttribute("vaccion", vaccion);

        UsuarioManager um = new UsuarioManager();

        if (vaccion == null) {
            //modo grilla...se muestran todos los registros
            ArrayList<Usuarios> usuarios = um.getAll();
            request.setAttribute("usuarios", usuarios);

            RequestDispatcher rd = request.getRequestDispatcher("/admin/abm-usuarios.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }

        if ("Eliminar".equals(vaccion)) {
            int idUser = Integer.valueOf(request.getParameter("vid"));
            Usuarios user = new Usuarios();
            user.setIdUsuario(idUser);

            um.delete(user);

            ArrayList<Usuarios> usuarios = um.getAll();
            request.setAttribute("usuarios", usuarios);

            RequestDispatcher rd = request.getRequestDispatcher("/admin/abm-usuarios.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }

        if ("GrabarNuevo".equals(vaccion)) {
            String desc = request.getParameter("descripcion");
            Usuarios user = new Usuarios();
            user.setNombre(request.getParameter("nombre"));
            user.setApellido(request.getParameter("apellido"));
            user.setLoginName(request.getParameter("login_name"));
            user.setContrasena(request.getParameter("contrasena"));
            user.setTipoUsuario(Byte.parseByte(request.getParameter("tipousuario")));
            
            um.insertar(user);

            ArrayList<Usuarios> usuarios = um.getAll();
            request.setAttribute("usuarios", usuarios);

            RequestDispatcher rd = request.getRequestDispatcher("/admin/abm-usuarios.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }

        if ("Editar".equals(vaccion)) {
            int idUser = Integer.valueOf(request.getParameter("vid"));
            Usuarios user = um.getUsuarioByIdT(idUser);
            
            request.setAttribute("usuarios", user);

            RequestDispatcher rd = request.getRequestDispatcher("admin/UserEdit.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }

        if ("GrabarModificado".equals(vaccion)) {
           int idUser = Integer.valueOf(request.getParameter("vid"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String login_name = request.getParameter("login_name");
            String contrasena = request.getParameter("contrasena");
            byte tipousuario = Byte.parseByte(request.getParameter("tipousuario"));
            
            
            Usuarios user = new Usuarios();
            user.setIdUsuario(idUser);
            user.setNombre(nombre);
            user.setApellido(apellido);
            user.setLoginName(login_name);
            user.setContrasena(Md5Java.md5Java(contrasena));
            user.setTipoUsuario(tipousuario);

            um.update(user);

            ArrayList<Usuarios> usuarios = um.getAll();
            request.setAttribute("usuarios", usuarios);

            RequestDispatcher rd = request.getRequestDispatcher("/admin/abm-usuarios.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }
        
        if ("login".equals(vaccion)) {
                String usuario = request.getParameter("usuario");
                String passwd = request.getParameter("contrasenia");
                int iduser=-1;
                UsuarioManager o = new UsuarioManager();
                if (usuario != null && !"".equals(usuario.trim())
                        && passwd != null && !"".equals(passwd)) {
                    //Logica de login
                    if (o.LogIn(usuario, passwd)) {
                        HttpSession objsesion = request.getSession(true);
                        objsesion.setAttribute("usuario", usuario);
                        
                        //Login Satisfactorio
                        RequestDispatcher rd = request.getRequestDispatcher("/producto.jsp");
                        if (rd != null) {
                            rd.forward(request, response);
                        }
                    } else {
                       // request.setAttribute("mensajeError", "Login Incorrecto!!!");
                        RequestDispatcher rd = request.getRequestDispatcher("/logIn.jsp");
                        if (rd != null) {
                            rd.forward(request, response);
                        }
                    }
                } else {
                    request.setAttribute("mensajeError", "usuario/contrasenha incorrecto");
                    RequestDispatcher rd = request.getRequestDispatcher("/logIn.jsp");
                    if (rd != null) {
                        rd.forward(request, response);
                    }
                }


            }
        
        if("logout".equals(vaccion)){
                HttpSession objsesion = request.getSession(true);
                objsesion.setAttribute("usuario", null);
                HttpSession sesion = request.getSession();
                sesion.invalidate();
                RequestDispatcher rd = request.getRequestDispatcher("/logIn.jsp");
                        if (rd != null) {
                            rd.forward(request, response);
                        }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
