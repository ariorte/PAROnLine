<%-- 
    Document   : CategoriaNew
    Created on : 11/11/2017, 10:40:51 AM
    Author     : Ariel y Fabricio
--%>

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

                <h1>Nueva Categoria</h1>
                <form action="/carritonline/CategoriaServlets">
                    <table>
                        <tr>
                            <td>Id Categoria</td>
                            <td><input type="text" name="idCategoria"/></td>
                        </tr>
                        <tr>
                            <td>Descripcion</td>
                            <td><input type="text" name="descripcion"/></td>
                        </tr>
                    </table>
                    <input type="hidden" name="vaccion" value="GrabarNuevo"/>
                    <input type="submit" value="Grabar"/>
                </form>
            </div>
        </div>
    </body>
</html>
