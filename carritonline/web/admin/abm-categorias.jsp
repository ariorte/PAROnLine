<%-- 
    Document   : abm-categorias
    Created on : 09/11/2017, 12:07:26 AM
    Author     : Ariel y Fabricio
--%>

<%@page import="py.una.pol.par.model.CategoriaManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="py.una.pol.par.entities.Categoria"%>

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
                <jsp:include page="../menu.jsp" />
                <hr>
                <br>
                <h2>Moderación de Categorias</h2>
                <hr>
                <br>
                <!--Cuerpo ini-->
                <form action="CategoriaNew.jsp">
                    <input type="submit" value="Crear"/>
                </form>
                <table border="1">
                    <tr>
                        <td><strong>Id Categoria</strong></td>
                        <td><strong>Descripcion</strong></td>
                        <td><strong>Acciones</strong></td>
                    </tr>       
                    <%ArrayList<Categoria> catalogo = CategoriaManager.getAll();
                    for (Categoria cat : catalogo) {%>
                    <tr>
                        <td><%= cat.getIdCategoria()%></td>
                        <td><%= cat.getDescripcion()%></td>
                        <td> <form action="/carritonline/CategoriaServlets">
                                <input type="hidden" name="vaccion" value="Editar"/>
                                <input type="hidden" name="vid" value="<%=cat.getIdCategoria()%>"/>
                                <input type="submit" value="Editar"/>
                            </form> <form action="/carritonline/CategoriaServlets">
                                <input type="hidden" name="vaccion" value="Eliminar"/>
                                <input type="hidden" name="vid" value="<%=cat.getIdCategoria()%>"/>
                                <input type="submit" value="Eliminar"/>
                            </form> </td>
                    </tr>
                    <%}%> 
                </table> 
                <!--Cuerpo fin-->
            </div>
        </div>

    </body>
</html>
