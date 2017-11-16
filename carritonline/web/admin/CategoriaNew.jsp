<%-- 
    Document   : CategoriaNew
    Created on : 11/11/2017, 10:40:51 AM
    Author     : fabricio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nueva Categoria</h1>
        <form action="/carritonline/CategoriaServlets">
            <table>
                <tr>
                    <td>Descripcion</td>
                    <td><input type="text" name="descripcion"/></td>
                </tr>
            </table>
            <input type="hidden" name="vaccion" value="GrabarNuevo"/>
            <input type="submit" value="Grabar"/>
        </form>
    </body>
</html>
