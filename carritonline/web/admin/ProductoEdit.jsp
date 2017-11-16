<%-- 
    Document   : ProductoEdit
    Created on : 12/11/2017, 02:26:58 AM
    Author     : fabricio
--%>

<%@page import="py.una.pol.par.entities.Productos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
<body>
        <%
            Productos prod = (Productos)request.getAttribute("producto");
         %>
        <h1>Categoria <%= prod.getDescripcion() %></h1>
        <form action="/carritonline/ProductosServlet">
            <table>
                <tr>
                    <td>Descripcion</td>
                    <td><input type="text" name="descripcion" value="<%= prod.getDescripcion() %> "/></td>
                </tr>
                <tr>
                    <td>Precio</td>
                    <td><input type="text" name="precio" value="<%= prod.getPrecioUnit() %> "/></td>
                </tr>
                <tr>
                    <td>Cantidad disponible</td>
                    <td><input type="text" name="cantidad" value="<%= prod.getCantidad() %> "/></td>
                </tr>
            </table>
            <input type="hidden" name="vid" value="<%= prod.getId_producto() %>"/>    
            <input type="hidden" name="vaccion" value="GrabarModificado"/>
            <input type="submit" value="Grabar"/>
        </form>
    </body>
</html>
