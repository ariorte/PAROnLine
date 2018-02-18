<%-- 
    Document   : abm-usuarios
    Created on : 09/11/2017, 12:07:13 AM
    Author     : Ariel y Fabricio
--%>

<%@page import="py.una.pol.par.model.UsuarioManager"%>
<%@page import="py.una.pol.par.entities.Usuarios"%>
<%@page import="java.util.ArrayList"%> 

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
                <h2>Moderación de Usuarios</h2>
                <hr>
                <!--Cuerpo ini -->
                <form action="UserNew.jsp">
                    <input type="submit" value="Crear"/>
                </form>
                <table border="1">
                    <tr>
                        <td><strong>UserName</strong></td>
                        <td><strong>Nombre</strong></td>
                        <td><strong>Apellido</strong></td>
                        <td><strong>Tipo de usuario</strong></td>
                        <td><strong>Acciones</strong></td>
                    </tr>              

                    <%
                        ArrayList<Usuarios> userlist = UsuarioManager.getAll();
                        for (Usuarios u : userlist) {
                    %>
                    <tr>
                        <td><%= u.getLoginName()%></td>
                        <td><%= u.getNombre()%></td>
                        <td><%= u.getApellido()%></td>
                        <td><%= u.getTipoUsuario()%></td>
                        <td> <form action="/carritonline/UsuariosServlet">
                                <input type="hidden" name="vaccion" value="Editar"/>
                                <input type="hidden" name="vid" value="<%= u.getIdUsuario()%>"/>
                                <input type="submit" value="Editar"/>
                            </form> <form action="/carritonline/UsuariosServlet">
                                <input type="hidden" name="vaccion" value="Eliminar"/>
                                <input type="hidden" name="vid" value="<%= u.getIdUsuario()%>"/>
                                <input type="submit" value="Eliminar"/>
                            </form> </td>  
                    </tr> 
                    <% }%> 

                </table>  
                <!--
                
                Cuerpo fin
                -->    
            </div>
        </div>

    </body>
</html>

