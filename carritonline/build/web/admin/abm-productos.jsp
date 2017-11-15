<%-- 
    Document   : abm-productos
    Created on : 09/11/2017, 12:05:37 AM
    Author     : fabricio
--%>
<%@page import="py.una.pol.par.model.ProductosManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="py.una.pol.par.entities.Productos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <jsp:include page="../menu.jsp" />
               </nav>
                 <hr>
                <h2>Moderación de Productos</h2>
                <hr> 
            <!--Cuerpo ini-->
            <form action="ProductoNew.jsp">
            <input type="submit" value="Crear"/>
            </form>
                <table border="1">
                <tr>
                <td><strong>Id Producto</strong></td>
                <td><strong>Descripcion</strong></td>
                <td><strong>Cantidad disponible</strong></td>
                <td><strong>Precio x Unidad</strong></td>
                <td><strong>Acciones</strong></td>
                </tr>       
                <%ArrayList<Productos> lista = ProductosManager.getAll();
                    for (Productos p : lista) {%>
                <tr>
                 <td><%= p.getId_producto() %></td>
                 <td><%= p.getDescripcion() %></td>
                 <td><%= p.getCantidad() %></td>
                 <td><%= p.getPrecioUnit() %></td>
                 <td>  <form action="/carritonline/ProductosServlet">
                        <input type="hidden" name="vaccion" value="Editar"/>
                        <input type="hidden" name="vid" value="<%= p.getId_producto() %>"/>
                        <input type="submit" value="Editar"/>
                    </form> <form action="/carritonline/ProductosServlet">
                        <input type="hidden" name="vaccion" value="Eliminar"/>
                        <input type="hidden" name="vid" value="<%= p.getId_producto() %>"/>
                        <input type="submit" value="Eliminar"/>
                    </form>  </td>
                </tr>
                <%}%> 
                </table> 
            <!--Cuerpo fin-->    
            </div>
        </div>
    </body>
</html>
