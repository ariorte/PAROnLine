<%-- 
    Document   : ProductoEdit
    Created on : 12/11/2017, 02:26:58 AM
    Author     : Ariel y Fabricio
--%>

<%@page import="py.una.pol.par.entities.Productos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="<%= request.getContextPath()%>/scripts/css.css" rel="stylesheet" type="text/css" />
    </head>
    <body> 
        <div id='main'>
            <div id='cuerpocontainer'>
                <h1>Bienvenid@ a CarritOnline!<script src="<%= request.getContextPath()%>/scripts/contador.js"></script></h1>
                <hr>
                <jsp:include page="menu.jsp" />
                <hr>
                <br>
                <%
                    Productos prod = (Productos) request.getSession().getAttribute("productos");
                %>
                <h1>Categoria <%= prod.getDescripcion()%></h1>
                <form action="/carritonline/ProductosServlet">
                    <table>
                        <tr>
                            <td>Descripcion</td>
                            <td><input type="text" name="descripcion" value="<%= prod.getDescripcion()%>"/></td>
                        </tr>
                        <tr>
                            <td>Precio</td>
                            <td><input type="text" name="precio" value="<%= prod.getPrecioUnit()%>"/></td>
                        </tr>
                        <tr>
                            <td>Cantidad disponible</td>
                            <td><input type="text" name="cantidad" value="<%= prod.getCantidad()%>"/></td>
                        </tr>
                    </table>
                    <input type="hidden" name="vid" value="<%= prod.getId_producto()%>"/>    
                    <input type="hidden" name="vaccion" value="GrabarModificado"/>
                    <input type="submit" value="Grabar"/>
                </form>
            </div>
        </div>
    </body>
</html>
