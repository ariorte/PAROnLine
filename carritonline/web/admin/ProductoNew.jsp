<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="<%= request.getContextPath()%>/scripts/css.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript">
            function evaluarIngreso(){
                let idProducto = document.getElementById("idProducto");
                let idCategoria = document.getElementById(idCategoria);
                if(idCategoria == undefined || idCategoria == "undefined" || 
                        idCategoria.length == 0 || idProducto == undefined ||
                        idProducto == "undefined" || idProducto.length == 0){
                    alert("Se debe completar los campos obligatorios");
                    return false;
                }
                return true;
            }
        </script>
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
                            <td><input type="text" id="idProducto" name="idproducto"/></td>
                        </tr>
                        <tr>
                            <td>Descripcion</td>
                            <td><input type="text" name="descripcion" value=""/></td>
                        </tr>
                        <tr>
                            <td>Cantidad</td>
                            <td><input type="text" name="cantidad" value="0"/></td>
                        </tr>
                        <tr>
                            <td>Precio</td>
                            <td><input type="text" name="precio" value="0"/></td>
                        </tr>
                        <tr>
                            <td>Imagen del producto</td>
                            <td><input type="text" name="imgproducto" value=""/></td>
                        </tr>
                        <tr>
                            <td>ID Categoria</td>
                            <td><input type="text" id="idCategoria" name="idcategoria"/></td>
                        </tr>
                    </table>
                    <input type="hidden" name="vaccion" value="GrabarNuevo"/>
                    <input type="submit" value="Grabar" onclick="return evaluarIngreso()"/>
                </form>
            </div>
        </div>
    </body>
</html>
