/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.par.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import py.una.pol.par.entities.Item;
import py.una.pol.par.entities.Productos;
import py.una.pol.par.model.ProductosManager;

/**
 *
 * @author Ariel y Fabricio
 */
public class AgregarCarrito extends HttpServlet {

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
        
      
       String vaccion = request.getParameter("vaccion");
       request.setAttribute("vaccion", vaccion);
       
       HttpSession sesion = request.getSession(true);
       ArrayList<Item> articulos = (ArrayList)sesion.getAttribute("carrito");
       if (articulos == null) {
          articulos = new ArrayList<Item>();
        }else{
          articulos = (ArrayList) sesion.getAttribute("carrito");
        }
       boolean flag = false;
        if ("anhadir".equals(vaccion)) {
            String idProducto = request.getParameter("idproducto");
            int cantidad = Integer.parseInt(request.getParameter("cantidad")); 
            Productos prod = ProductosManager.getProductoById(idProducto);
            int precio= prod.getPrecioUnit();
            int cont=0;
            if (cantidad!=0) {
                if (articulos.size()>0 ) {
                    for (Item i: articulos) {
                        if (idProducto.equals(i.getId_producto())) {                     
                            i.setPrecio(precio);
                            i.setCantidad(cantidad);
                            cont++;
                            flag=true;
                            break;
                        }
                    }
                }
                if (flag== false) {
                    articulos.add(new Item(idProducto,precio,cantidad));
                }
            }else{
                articulos.remove(cont);
            }
            sesion.setAttribute("carrito", articulos);
            response.sendRedirect("index.jsp");
        }
       
       /*
        eliminar
        +
        
        
        */
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
