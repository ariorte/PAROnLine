<%-- 
    Document   : carrito
    Created on : 26/10/2017, 01:17:45 PM
    Author     : fabricio
--%>

<%@page import="py.una.pol.par.entities.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="py.una.pol.par.model.ProductosManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="py.una.pol.par.entities.Productos"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@page import="py.una.pol.par.controllers.s" %>
        <link href="<%= request.getContextPath()%>/scripts/css.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div id='main'>
            <div id='cuerpocontainer'>
                <h1>Bienvenid@ a CarritOnline!</h1>
                <hr>
                <nav>
                    <jsp:include page="menu.jsp" />
               </nav>
                 <hr>
                <br>
                <h2>Lista del carrito de compras</h2>
                <hr>
                <br>
  <%HttpSession sesion = request.getSession(true);
    ArrayList<Item> articulos = (ArrayList) sesion.getAttribute("carrito");
            //sesion.getAttribute("carrito", articulos);
            if (articulos == null) {
            %> 
            nada
            <%}else{%>
<%for (Item x : articulos) {
       Productos prod = ProductosManager.getProductoById(x.getId_producto());%> 
 - <%= prod.getDescripcion()  %>; Unidad/es: <%= x.getCantidad() %>, Precio: <%= x.getCantidad() * prod.getPrecioUnit() %><br>

 <%}%>

<%          
            int subtotal =0;
            int totalpagar=0;
            for (Item p : articulos) {
            subtotal = subtotal + p.getCantidad();
            totalpagar = totalpagar + p.getPrecio();
}
%>    

Total a pagar: <%= totalpagar  %> Gs.

<%}%>
            </div>
        </div>
    </body>
</html>
