<%-- 
    Document   : menu
    Created on : 27/10/2017, 09:31:16 PM
    Author     : fabricio
--%>
<%@page import="py.una.pol.par.entities.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%
  HttpSession sesion = request.getSession(true);
  ArrayList<Item> articulos = (ArrayList) sesion.getAttribute("carrito");
            int subtotal =0;
            
            if (articulos != null) {
                    for (Item p : articulos) {
                    subtotal = subtotal + p.getCantidad() ; 
                }
            
}

 %> 
<ul id="appleNav">
                <li><a href="<%= request.getContextPath()%>" title="Ir a la Página Principal">Inicio</a></li>
                <li><a href="<%= request.getContextPath()%>/producto.jsp" title="Productos">Productos</a></li>
                <li><a href="<%= request.getContextPath()%>/categoria.jsp" title="Categorias de Productos">Categorias</a></li>
                <li><a href="<%= request.getContextPath()%>" title="Usuarios">Usuarios</a></li>
                <li><a href="<%= request.getContextPath()%>/logIn.jsp" title="Iniciar Sesión">Iniciar Sesión</a></li>
                <li><a href="#" title="Carrito">Carrito <img src="<%= request.getContextPath()%>/images/carrito1.png" width="24px" height="24px"> ( <%= subtotal %> )</a></li>
                <li>
                    <form action="BuscadorServlet" method="post">
                        <input type="hidden" value="buscarya" name="vaccion"/>
                        <input type="text" value="Buscar producto" id="txt-buscar" name="buscar_producto"/>
                    </form>
                </li>
            </ul>
