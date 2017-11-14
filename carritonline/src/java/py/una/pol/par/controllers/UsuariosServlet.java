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

/**
 *
 * @author fabricio
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
            //c.setDescripcion(desc);
            
           // user.setIdUsuario(desc);
            
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
            Usuarios user = um.getUsuarioById(idUser);

            request.setAttribute("usuarios", user);

            RequestDispatcher rd = request.getRequestDispatcher("/admin/UserEdit.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }

        if ("GrabarModificado".equals(vaccion)) {
            
           int idUser = Integer.valueOf(request.getParameter("vid"));
            String desc = request.getParameter("descripcion");
            Usuarios user = new Usuarios();
            user.setIdUsuario(idUser);
            //user.setDescripcion(desc);

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
                    RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                    if (rd != null) {
                        rd.forward(request, response);
                    }
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
