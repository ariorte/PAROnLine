package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import py.una.pol.par.model.ProductosManager;
import java.util.ArrayList;
import py.una.pol.par.entities.Productos;
import py.una.pol.par.controllers.s;

public final class logIn_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        \n");
      out.write("        <link href=\"");
      out.print( request.getContextPath());
      out.write("/scripts/css.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id='main'>\n");
      out.write("            <div id='cuerpocontainer'>\n");
      out.write("                <h1>Bienvenid@ a CarritOnline!</h1>\n");
      out.write("                <hr>\n");
      out.write("                <nav>\n");
      out.write("                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, false);
      out.write("\n");
      out.write("               </nav>\n");
      out.write("                 <hr>\n");
      out.write("                <br>\n");
      out.write("                <!--Inicio cuerpo-->\n");
      out.write("                <div id='caja'>\n");
      out.write("                    <form id=\"form-login\" action=\"UsuariosServlet\" method=\"post\" autocomplete=\"off\">\n");
      out.write("                    <input type=\"hidden\" name=\"accion\" value=\"login\"/>\n");
      out.write("                    <p align=\"center\">\n");
      out.write("                    <!--A saber, el atributo for funciona como el id.-->\n");
      out.write("                    <!--ejemplo <label for=\"usuario\">Usuario:</label>-->\n");
      out.write("                    <!--required es nuevo en html5, si el campo está vacío te avisa, pero cuidado, no valida la información-->\n");
      out.write("                    <label >Usuario:</label><br><br>\n");
      out.write("                        <input name=\"usuario\" type=\"text\" id=\"usuario\" placeholder=\"Ingresa Usuario\" autofocus=\"\" required=\"\"><br><br>\n");
      out.write(" \n");
      out.write("                    <label>Contraseña:</label><br><br>\n");
      out.write("                        <input name=\"contrasenia\" type=\"password\" id=\"contrasenia\" placeholder=\"Ingresa Password\" required=\"\"><br><br>\n");
      out.write("                    <input type=\"submit\" id=\"submit\" name=\"submit\" value=\"Ingresar\" class=\"boton\"></p>\n");
      out.write("                    <input type=\"hidden\" name=\"vaccion\" value=\"login\"/>\n");
      out.write("                </form>\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("                <!--fin cuerpo-->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
