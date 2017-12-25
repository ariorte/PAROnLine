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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import py.una.pol.par.entities.Productos;
import py.una.pol.par.model.ProductosManager;

/**
 *
 * @author Ariel y Fabricio
 */
@WebServlet(name = "ProductosServlet", urlPatterns = {"/ProductosServlet"})
public class ProductosServlet extends HttpServlet {

    

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

        ProductosManager pm = new ProductosManager();

        if (vaccion == null) {
            //modo grilla...se muestran todos los registros
            ArrayList<Productos> productos = pm.getAll();
            request.setAttribute("productos", productos);

            RequestDispatcher rd = request.getRequestDispatcher("/admin/abm-productos.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }

        if ("Eliminar".equals(vaccion)) {
            String idProd = String.valueOf(request.getParameter("vid"));
            Productos p = new Productos();
            p.setId_producto(idProd);

            pm.delete(p);

            ArrayList<Productos> productos = pm.getAll();
            request.setAttribute("productos", productos);

            RequestDispatcher rd = request.getRequestDispatcher("/admin/abm-productos.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }

        if ("GrabarNuevo".equals(vaccion)) {
            String desc = request.getParameter("descripcion");
            Productos prod = new Productos();
            prod.setDescripcion(desc);

            pm.insertar(prod);

            ArrayList<Productos> productos = pm.getAll();
            request.setAttribute("productos", productos);

            RequestDispatcher rd = request.getRequestDispatcher("/admin/abm-productos.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }

        if ("Editar".equals(vaccion)) {
            String idProd = String.valueOf(request.getParameter("vid"));
            Productos prod = pm.getProductoById(idProd);

            request.setAttribute("productos", prod);

            RequestDispatcher rd = request.getRequestDispatcher("/admin/ProductoEdit.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }

        if ("GrabarModificado".equals(vaccion)) {
            String idProd = String.valueOf(request.getParameter("vid"));
            String desc = request.getParameter("descripcion");
            int precio = Integer.parseInt(request.getParameter("precio"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            Productos p = new Productos();
            p.setId_producto(idProd);
            p.setDescripcion(desc);
            p.setPrecioUnit(precio);
            p.setCantidad(cantidad);

            pm.update(p);

            ArrayList<Productos> productos = pm.getAll();
            request.setAttribute("productos", productos);

            RequestDispatcher rd = request.getRequestDispatcher("/admin/abm-productos.jsp");
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
