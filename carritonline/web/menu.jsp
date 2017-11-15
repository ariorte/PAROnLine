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
            int totalpagar =0;
            if (articulos != null) {
                    for (Item p : articulos) {
                    subtotal = subtotal + p.getCantidad();
                    totalpagar= totalpagar+ p.getPrecio();
                }           
}
            
HttpSession objsesion = request.getSession(false);
String usuario = (String)objsesion.getAttribute("usuario");
 %> 
<ul id="appleNav">
                <li><a href="<%= request.getContextPath()%>" title="Ir a la Página Principal">Inicio</a></li>
                <li><a href="<%= request.getContextPath()%>/producto.jsp" title="Productos">Productos</a></li>
                <% if (usuario==null) { %>
                <li><a href="<%= request.getContextPath()%>/logIn.jsp" title="Iniciar Sesión">Iniciar Sesión</a></li>        
                  <% }else{ %>
                <li><a href="#" title="Productos"><%= usuario %></a></li>
                <li>
                    <form id="form-logout" action="UsuariosServlet" method="post">
                        <input type="hidden" name="vaccion" value="logout"/>
                        <a href="#" onclick="document.getElementById('form-logout').submit()" title="Cerra Sesión">Cerrar Sesión</a>
                    </form>
                </li>
                <% } %>
                <li><a href="<%= request.getContextPath()%>/carrito.jsp" title="Carrito">Carrito <img src="<%= request.getContextPath()%>/images/carrito1.png" width="24px" height="24px"> ( <%= subtotal %> )</a></li>
                <li>
                    <form action="BuscadorServlet" method="post">
                        <input type="hidden" value="buscarya" name="vaccion"/>
                        <input type="text" value="" id="txt-buscar" name="buscar_producto" placeholder="Buscar..." required=""/>
                    </form>
                </li>
            </ul>
