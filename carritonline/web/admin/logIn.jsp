<%-- 
    Document   : logIn
    Created on : 26/10/2017, 01:17:29 PM
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
                <jsp:include page="menu.jsp" />
                <hr>
                <br>
                <!--Inicio cuerpo-->
                <div id='caja'>
                    <form id="form-login" action="UsuariosServlet" method="post" autocomplete="off">
                        <input type="hidden" name="accion" value="login"/>
                        <p align="center">
                            <!--A saber, el atributo for funciona como el id.-->
                            <!--ejemplo <label for="usuario">Usuario:</label>-->
                            <!--required es nuevo en html5, si el campo está vacío te avisa, pero cuidado, no valida la información-->
                            <label >Usuario:</label><br><br>
                            <input name="usuario" type="text" id="usuario" placeholder="Ingresa Usuario" autofocus="" required=""><br><br>

                            <label>Contraseña:</label><br><br>
                            <input name="contrasenia" type="password" id="contrasenia" placeholder="Ingresa Password" required=""><br><br>
                            <input type="submit" id="submit" name="submit" value="Ingresar" class="boton"></p>
                        <input type="hidden" name="vaccion" value="login"/>
                    </form>

                </div>
                <!--fin cuerpo-->
            </div>
        </div>
    </body>
</html>
