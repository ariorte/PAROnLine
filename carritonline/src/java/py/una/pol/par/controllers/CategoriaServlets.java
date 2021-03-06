/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.par.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import py.una.pol.par.entities.Categoria;
import py.una.pol.par.model.CategoriaManager;

/**
 *
 * @author Ariel
 */
public class CategoriaServlets extends HttpServlet {

    

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

        CategoriaManager cm = new CategoriaManager();

        if (vaccion == null) {
            //modo grilla...se muestran todos los registros
            ArrayList<Categoria> categorias = cm.getAll();
            request.setAttribute("categorias", categorias);

            RequestDispatcher rd = request.getRequestDispatcher("/admin/abm-categorias.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }

        if ("Eliminar".equals(vaccion)) {
            String idCat = String.valueOf(request.getParameter("vid"));
            Categoria c = new Categoria();
            c.setIdCategoria(idCat);

            cm.delete(c);

            ArrayList<Categoria> categorias = cm.getAll();
            request.setAttribute("categorias", categorias);

            RequestDispatcher rd = request.getRequestDispatcher("/admin/abm-categorias.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }

        if ("GrabarNuevo".equals(vaccion)) {
            String desc = request.getParameter("descripcion");
            Categoria c = new Categoria();
            c.setDescripcion(desc);
            c.setIdCategoria(request.getParameter("idCategoria"));

            cm.insertar(c);

            ArrayList<Categoria> categorias = cm.getAll();
            request.setAttribute("categorias", categorias);

            RequestDispatcher rd = request.getRequestDispatcher("/admin/abm-categorias.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }

        if ("Editar".equals(vaccion)) {
            String idCat = String.valueOf(request.getParameter("vid"));
            Categoria c = cm.getCategoriaById(idCat);

            request.setAttribute("categoria", c);

            RequestDispatcher rd = request.getRequestDispatcher("/admin/CategoriaEdit.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }

        if ("GrabarModificado".equals(vaccion)) {
            String idCat = String.valueOf(request.getParameter("vid"));
            String desc = request.getParameter("descripcion");
            Categoria c = new Categoria();
            c.setIdCategoria(idCat);
            c.setDescripcion(desc);

            cm.update(c);

            ArrayList<Categoria> categorias = cm.getAll();
            request.setAttribute("categorias", categorias);

            RequestDispatcher rd = request.getRequestDispatcher("/admin/abm-categorias.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }
        /*
         response.setContentType("text/html;charset=UTF-8");
         try (PrintWriter out = response.getWriter()) {
         out.println("<!DOCTYPE html>");
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Servlet CategoriaServlet1</title>");            
         out.println("</head>");
         out.println("<body>");
         out.println("<h1>Servlet CategoriaServlet1 at " + request.getContextPath() + "</h1>");
         out.println("</body>");
         out.println("</html>");
         }*/
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
