<%-- 
    Document   : UserEdit
    Created on : 12/11/2017, 02:27:19 AM
    Author     : Ariel y Fabricio
--%>

<%@page import="py.una.pol.par.entities.Usuarios"%>
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
                    Usuarios usu = (Usuarios) request.getAttribute("usuarios");
                %>
                <h1>Usuario <%= usu.getLoginName()%></h1>
                <form action="/carritonline/UsuariosServlet">
                    <table>
                        <tr>
                            <td>Nombre</td>
                            <td><input type="text" name="nombre" value="<%= usu.getNombre()%>"/></td>
                        </tr>
                        <tr>
                            <td>Apellido</td>
                            <td><input type="text" name="apellido" value="<%= usu.getApellido()%>"/></td>
                        </tr>
                        <tr>
                            <td>NickUser</td>
                            <td><input type="text" name="login_name" value="<%= usu.getLoginName()%>"/></td>
                        </tr>
                        <tr>
                            <td>Contraseña</td>
                            <td><input type="text" name="contrasena" value="<%= usu.getContrasena()%>"/></td>
                        </tr>
                        <tr>
                            <td>Tipo de usuario</td>
                            <td><input type="text" name="tipousuario" value="<%= usu.getTipoUsuario()%>"/></td>
                        </tr>
                    </table>
                    <input type="hidden" name="vid" value="<%= usu.getIdUsuario()%>"/>    
                    <input type="hidden" name="vaccion" value="GrabarModificado"/>
                    <input type="submit" value="Grabar"/>
                </form>
            </div>
        </div>
    </body>
</html>
