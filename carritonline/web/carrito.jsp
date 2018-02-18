<%-- 
    Document   : carrito
    Created on : 26/10/2017, 01:17:45 PM
    Author     : Ariel y Fabricio
--%>
<%@page import="py.una.pol.par.model.UsuarioManager"%>
<%@page import="py.una.pol.par.entities.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="py.una.pol.par.model.ProductosManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="py.una.pol.par.entities.Productos"%>
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
                <h2>Lista del carrito de compras</h2>
                <hr>
                <br>
                <%
                    java.util.Calendar cal = java.util.Calendar.getInstance(java.util.Locale.US);
                    java.util.Date date = cal.getTime();
                    java.text.DateFormat formateadorFecha = java.text.DateFormat.getDateInstance(java.text.DateFormat.FULL);
                    HttpSession objsesion = request.getSession(false);
                    String usuario = (String) objsesion.getAttribute("usuario");
                    int idUser = -1;
                    UsuarioManager os = new UsuarioManager();
                    idUser = os.getUsuarioByLoginNameID(usuario);

                    HttpSession sesion = request.getSession(true);
                    ArrayList<Item> articulos = (ArrayList) sesion.getAttribute("carrito");
                    //sesion.getAttribute("carrito", articulos);
                    if (articulos == null) {
                %> 
                <div id='caja'><p align="center">Nada</p></div> 
                <%} else {%>
                <div id='caja'><p align="center">
                        <%for (Item x : articulos) {
        Productos prod = ProductosManager.getProductoById(x.getId_producto());%> 
                        - <a href="detalleProducto.jsp?id=<%=prod.getId_producto()%>"><b><%= prod.getDescripcion()%></b></a>; Unidad/es: <%= x.getCantidad()%>, Precio: <%= x.getCantidad() * prod.getPrecioUnit()%><br>
                        <%}%>
                        <%
                            int subtotal = 0;
                            int totalpagar = 0;
                            for (Item p : articulos) {
                                subtotal = subtotal + p.getCantidad();
                                totalpagar = totalpagar + p.getPrecio();
                            }
                        %>    
                        Total a pagar: <b> <%= totalpagar%> Gs.</b>
                    </p></div> 
                <form action="/carritonline/ConfirmacionServlet">
                    <input type="hidden" name="vfecha" value="<%=formateadorFecha.format(date)%>"/>
                    <input type="hidden" name="vtotalpagar" value="<%=totalpagar%>"/>
                    <input type="hidden" name="viduser" value="<%=idUser%>"/>
                    <input type="hidden" name="vaccion" value="Confirmacion_compra"/>
                    <input type="submit" value="Confirmar"/>
                </form>
                <%}%>
            </div>
        </div>
    </body>
</html>
