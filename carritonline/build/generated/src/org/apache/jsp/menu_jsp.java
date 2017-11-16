package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import py.una.pol.par.entities.Item;
import java.util.ArrayList;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" ");

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
 
      out.write(" \n");
      out.write("<ul id=\"appleNav\">\n");
      out.write("                <li><a href=\"");
      out.print( request.getContextPath());
      out.write("\" title=\"Ir a la Página Principal\">Inicio</a></li>\n");
      out.write("                <li><a href=\"");
      out.print( request.getContextPath());
      out.write("/producto.jsp\" title=\"Productos\">Productos</a></li>\n");
      out.write("                ");
 if (usuario==null) { 
      out.write("\n");
      out.write("                <li><a href=\"");
      out.print( request.getContextPath());
      out.write("/logIn.jsp\" title=\"Iniciar Sesión\">Iniciar Sesión</a></li>        \n");
      out.write("                  ");
 }else{ 
      out.write("\n");
      out.write("                <li><a href=\"#\" title=\"Usuario ");
      out.print( usuario );
      out.write('"');
      out.write('>');
      out.print( usuario );
      out.write("</a></li>\n");
      out.write("                <li>\n");
      out.write("                    <form id=\"form-logout\" action=\"UsuariosServlet\" method=\"post\">\n");
      out.write("                        <input type=\"hidden\" name=\"vaccion\" value=\"logout\"/>\n");
      out.write("                        <a href=\"#\" onclick=\"document.getElementById('form-logout').submit()\" title=\"Cerra Sesión\">Cerrar Sesión</a>\n");
      out.write("                    </form>\n");
      out.write("                </li>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("                <li><a href=\"");
      out.print( request.getContextPath());
      out.write("/carrito.jsp\" title=\"Carrito\">Carrito <img src=\"");
      out.print( request.getContextPath());
      out.write("/images/carrito1.png\" width=\"24px\" height=\"24px\"> ( ");
      out.print( subtotal );
      out.write(" )</a></li>\n");
      out.write("                <li>\n");
      out.write("                    <form action=\"BuscadorServlet\" method=\"post\">\n");
      out.write("                        <input type=\"hidden\" value=\"buscarya\" name=\"vaccion\"/>\n");
      out.write("                        <input type=\"text\" value=\"\" id=\"txt-buscar\" name=\"buscar_producto\" placeholder=\"Buscar...\" required=\"\"/>\n");
      out.write("                    </form>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
