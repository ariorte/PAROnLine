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
import py.una.pol.par.entities.Item;
import py.una.pol.par.entities.TransaccionesCab;
import py.una.pol.par.model.CategoriaManager;
import py.una.pol.par.model.TransaccionManager;

/**
 *
 * @author Ariel y Fabricio
 */
public class ConfirmacionServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession sesion = request.getSession(true);
        ArrayList<Item> articulos = (ArrayList) sesion.getAttribute("carrito");
        
        
        
        String vaccion = request.getParameter("vaccion");
        request.setAttribute("vaccion", vaccion);
        
        TransaccionManager tm = new TransaccionManager();

        if ("Confirmacion_compra".equals(vaccion)) {
            int idUser = Integer.valueOf(request.getParameter("viduser"));
            int totalpagar = Integer.valueOf(request.getParameter("vtotalpagar"));
            String fechapago = String.valueOf(request.getParameter("vfecha"));
            String direnvio = "Campus UNA - San Lorenzo, Paraguay";
            byte idmediopago = 1;
            int nroTarjeta = 1002001;
            String estado = "I";
            TransaccionesCab tc = new TransaccionesCab();
            tc.setFecha(fechapago);
            tc.setId_Usuario(idUser);
            tc.setTotal(totalpagar);
            tc.setDireccion_de_envio(direnvio);
            tc.setId_Medio_Pago(idmediopago);
            tc.setNroTarjeta(nroTarjeta);
            tc.setEstado(estado);
            tm.insertar(tc);

             
            request.setAttribute("carrito", null);

            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
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
