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
                <h1>Nuevo Usuario</h1>
                <form action="/carritonline/UsuariosServlet">
                    <table>
                        <tr>
                            <td>Nombre</td>
                            <td><input type="text" name="nombre"/></td>
                        </tr>
                        <tr>
                            <td>Apellido</td>
                            <td><input type="text" name="apellido"/></td>
                        </tr>
                        <tr>
                            <td>NickUser</td>
                            <td><input type="text" name="login_name"/></td>
                        </tr>
                        <tr>
                            <td>Contraseña</td>
                            <td><input type="text" name="contrasena"/></td>
                        </tr>
                        <tr>
                            <td>Tipo de usuario</td>
                            <td><input type="text" name="tipousuario"/></td>
                        </tr>
                    </table>
                    <input type="hidden" name="vaccion" value="GrabarNuevo"/>
                    <input type="submit" value="Grabar"/>
                </form>
            </div>
        </div>
    </body>
</html>
