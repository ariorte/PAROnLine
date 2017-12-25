<%-- 
    Document   : CategoriaEdit
    Created on : 11/11/2017, 10:57:13 AM
    Author     : Ariel y Fabricio
--%>

<%@page import="py.una.pol.par.entities.Categoria"%>
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
                <nav>
                    <jsp:include page="menu.jsp" />
               </nav>
                 <hr>
                <br>
        <%
            Categoria c = (Categoria)request.getAttribute("categoria");
         %>
        <h1>Categoria <%=c.getDescripcion()%></h1>
        <form action="/carritonline/CategoriaServlets">
            <table>
                <tr>
                    <td>Descripcion</td>
                    <td><input type="text" name="descripcion" value="<%=c.getDescripcion()%>"/></td>
                </tr>
            </table>
            <input type="hidden" name="vid" value="<%=c.getIdCategoria()%>"/>    
            <input type="hidden" name="vaccion" value="GrabarModificado"/>
            <input type="submit" value="Grabar"/>
        </form>
            </div>
        </div>
    </body>
</html>
