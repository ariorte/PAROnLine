<%-- 
    Document   : index
    Created on : 25/10/2017, 07:53:03 AM
    Author     : Ariel y Fabricio
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
                <h1>Bienvenid@ a IT Services!<script src="<%= request.getContextPath()%>/scripts/contador.js"></script></h1>
                <hr>
                <jsp:include page="menu.jsp" />
                <hr>
                <br>
                <%
                    ArrayList<Productos> lista = ProductosManager.getAll();
                    int salto = 0;
                    for (Productos p : lista) {
                %>

                <div id="topsUserBox">
                    <div class="box_title">
                        <div class="box_txt"><%=p.getDescripcion()%></div>
                    </div>
                    <div class="box_cuerpo">
                        <br/><br/>
                        <div id="center" class="avatar" style="background-image: url('<%= request.getContextPath()%>/images/<%= p.getNombre_img()%>.png')"></div>
                        <p align="center"> <b>Precio:</b> <%=p.getPrecioUnit()%> <br>
                            <a href="detalleProducto.jsp?id=<%=p.getId_producto()%>">Ver detalles</a>
                        </p>  
                    </div>
                    <br>
                </div>
                <%  }%>       
            </div>
        </div>
    </body>
</html>
