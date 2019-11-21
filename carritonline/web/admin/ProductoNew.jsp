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
                <h1>Nuevo Producto</h1>
                <form action="/carritonline/ProductosServlet">
                    <table>
                        <tr>
                            <td>ID Producto</td>
                            <td><input type="text" name="idproducto"/></td>
                        </tr>
                        <tr>
                            <td>Descripcion</td>
                            <td><input type="text" name="descripcion"/></td>
                        </tr>
                        <tr>
                            <td>Cantidad</td>
                            <td><input type="text" name="cantidad"/></td>
                        </tr>
                        <tr>
                            <td>Precio</td>
                            <td><input type="text" name="precio"/></td>
                        </tr>
                        <tr>
                            <td>Imagen del producto</td>
                            <td><input type="text" name="imgproducto"/></td>
                        </tr>
                        <tr>
                            <td>ID Categoria</td>
                            <td><input type="text" name="idcategoria"/></td>
                        </tr>
                    </table>
                    <input type="hidden" name="vaccion" value="GrabarNuevo"/>
                    <input type="submit" value="Grabar"/>
                </form>
            </div>
        </div>
    </body>
</html>
