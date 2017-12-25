<%-- 
    Document   : detalleProducto
    Created on : 02/11/2017, 10:08:36 AM
    Author     : Ariel y Fabricio
--%>


<%@page import="py.una.pol.par.model.ProductosManager"%>
<%@page import="py.una.pol.par.model.CategoriaManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="py.una.pol.par.entities.Productos"%>
<%@page import="py.una.pol.par.entities.Categoria"%>
<%
    ArrayList<Productos> lista = ProductosManager.getAll();
    //String id = ;
    Productos p = ProductosManager.getProductoById(request.getParameter("id")) ;

%>
            
            

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
                <h1>Bienvenid@ a CarritOnline!</h1>
                <hr>
                <nav>
                    <jsp:include page="menu.jsp" />
               </nav>
                 <hr>
                <br>
              
                
            <!--
            
            Cuerpo ini
            -->    
            
            <div id="topsUserBox">
                        <div class="box_title">
                            <div class="box_txt">Detalles del Producto</div>
                        </div>
                        <div class="box_cuerpo" style="height: auto" >
                            <br/><br/> 
                <div id="center" class="avatar" style="background-image: url('<%= request.getContextPath()%>/images/<%= p.getNombre_img()%>.png')"></div>
		<p>
                    <b>Producto:</b> <%=p.getDescripcion()%> <br>
                    <b>Precio:</b> <%=p.getPrecioUnit() %> <br>
                    <b>Cantidad disponible:</b> <%=p.getCantidad() %> <br>
                    
                <form action="AgregarCarrito" method="post"> 
                    <input type="hidden" value="anhadir" name="vaccion" />
                    <b>Cantidad a Comprar: </b>
                    <input type="hidden" value="<%=p.getId_producto() %>" name="idproducto" />
                    <input type="number" value="0" id="txt-cantidad" name="cantidad" width="10%" />
                    <button type="submit">
                        Añadir al carrito
                    </button>
                </form>
                </p>

                        </div>
                        <br>
                    </div>
  
                      
                
            </div>
        </div>
            
    
            
            <!--
            
            Cuerpo fin
            -->    
            </div>
        </div>
                
    </body>
</html>
