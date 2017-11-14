package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import py.una.pol.par.model.CategoriaManager;
import java.util.ArrayList;
import py.una.pol.par.entities.Categoria;
import py.una.pol.par.controllers.s;

public final class abm_002dcategorias_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../menu.jsp", out, false);
      out.write("\n");
      out.write("               </nav>\n");
      out.write("                 <hr>\n");
      out.write("                <br>\n");
      out.write("                <h2>Moderación de Categorias</h2>\n");
      out.write("                <hr>\n");
      out.write("                <br>\n");
      out.write("            \n");
      out.write("                 <!--Cuerpo ini-->\n");
      out.write("            <form action=\"/CategoriaNew.jsp\">\n");
      out.write("            <input type=\"submit\" value=\"Crear\"/>\n");
      out.write("            </form>\n");
      out.write("                <table border=\"1\">\n");
      out.write("                <tr>\n");
      out.write("                <td><strong>Id Categoria</strong></td>\n");
      out.write("                <td><strong>Descripcion</strong></td>\n");
      out.write("                <td><strong>Acciones</strong></td>\n");
      out.write("                </tr>       \n");
      out.write("                ");
ArrayList<Categoria> catalogo = CategoriaManager.getAll();
                    for (Categoria cat : catalogo) {
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                 <td>");
      out.print( cat.getIdCategoria() );
      out.write("</td>\n");
      out.write("                 <td>");
      out.print( cat.getDescripcion() );
      out.write("</td>\n");
      out.write("                 <td> <form action=\"/onlineshop/CategoriaServlet\">\n");
      out.write("                        <input type=\"hidden\" name=\"vaccion\" value=\"Editar\"/>\n");
      out.write("                        <input type=\"hidden\" name=\"vid\" value=\"");
      out.print(cat.getIdCategoria());
      out.write("\"/>\n");
      out.write("                        <input type=\"submit\" value=\"Editar\"/>\n");
      out.write("                    </form> || <form action=\"/onlineshop/CategoriaServlet\">\n");
      out.write("                        <input type=\"hidden\" name=\"vaccion\" value=\"Eliminar\"/>\n");
      out.write("                        <input type=\"hidden\" name=\"vid\" value=\"");
      out.print(cat.getIdCategoria());
      out.write("\"/>\n");
      out.write("                        <input type=\"submit\" value=\"Eliminar\"/>\n");
      out.write("                    </form> </td>\n");
      out.write("                </tr>\n");
      out.write("                ");
}
      out.write(" \n");
      out.write("                </table> \n");
      out.write("            <!--Cuerpo fin-->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("                \n");
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
