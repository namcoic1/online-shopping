package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_if_test.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\" />\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n");
      out.write("        <title>PM Shoes Shop</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"css/app.css\" />\n");
      out.write("        <script src=\"js/app.js\"></script>\n");
      out.write("        <link\n");
      out.write("            rel=\"stylesheet\"\n");
      out.write("            href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\"\n");
      out.write("            />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light bg-light fixed-top\">\n");
      out.write("            <a\n");
      out.write("                style=\"color: red;\n");
      out.write("                font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif \"\n");
      out.write("                class=\"navbar-brand ml-5 mr-auto a1\"\n");
      out.write("                href=\"home\"\n");
      out.write("                title=\"Home\"\n");
      out.write("                ><img\n");
      out.write("                    style=\"max-width: 11%; border-radius: 50%\"\n");
      out.write("                    src=\"images/logo.jpg\"\n");
      out.write("                    />&nbsp;&nbsp;&nbsp;PM SHOP</a\n");
      out.write("            >\n");
      out.write("            <button\n");
      out.write("                class=\"navbar-toggler\"\n");
      out.write("                type=\"button\"\n");
      out.write("                data-toggle=\"collapse\"\n");
      out.write("                data-target=\"#navbarSupportedContent\"\n");
      out.write("                aria-controls=\"navbarSupportedContent\"\n");
      out.write("                aria-expanded=\"false\"\n");
      out.write("                aria-label=\"Toggle navigation\"\n");
      out.write("                >\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                <ul class=\"navbar-nav ml-auto mr-auto\">\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"about.jsp\">About\n");
      out.write("                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a\n");
      out.write("                            class=\"nav-link dropdown-toggle\"\n");
      out.write("                            href=\"#\"\n");
      out.write("                            id=\"navbarDropdown\"\n");
      out.write("                            role=\"button\"\n");
      out.write("                            data-toggle=\"dropdown\"\n");
      out.write("                            aria-haspopup=\"true\"\n");
      out.write("                            aria-expanded=\"false\"\n");
      out.write("                            >\n");
      out.write("                            Products\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\">Sneakers</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\">Slip-Ons</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\">Boots</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\">Sandals</a>\n");
      out.write("                            <!-- <div class=\"dropdown-divider\"></div> -->\n");
      out.write("                            <!-- <a class=\"dropdown-item\" href=\"#\">Something else here</a> -->\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"new.jsp\">\n");
      out.write("                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;News</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"contact.jsp\">\n");
      out.write("                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Contact</a>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("                <ul class=\"navbar-nav ml-auto mr-5\">\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"navbar-brand\" href=\"#\" title=\"Shopping Cart\">\n");
      out.write("                            <img\n");
      out.write("                                style=\"max-width: 37px; border-radius: 50%\"\n");
      out.write("                                src=\"images/shoppingcart.jpg\"\n");
      out.write("                                />\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <form class=\"form-inline my-2 my-lg-0\" action=\"search\">\n");
      out.write("                        <input\n");
      out.write("                            class=\"form-control mr-sm-2\"\n");
      out.write("                            type=\"text\"\n");
      out.write("                            name=\"form\"\n");
      out.write("                            placeholder=\"Search\"\n");
      out.write("                            aria-label=\"Search\"\n");
      out.write("                            />\n");
      out.write("                        <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">\n");
      out.write("                            Search\n");
      out.write("                        </button>\n");
      out.write("                    </form>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <div\n");
      out.write("            id=\"carouselExampleIndicators\"\n");
      out.write("            class=\"container-fluid carousel slide col-md-8 col-md-offset-3\"\n");
      out.write("            data-ride=\"carousel\"\n");
      out.write("            >\n");
      out.write("            <ol class=\"carousel-indicators\">\n");
      out.write("                <li\n");
      out.write("                    data-target=\"#carouselExampleIndicators\"\n");
      out.write("                    data-slide-to=\"0\"\n");
      out.write("                    class=\"active\"\n");
      out.write("                    ></li>\n");
      out.write("                <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"1\"></li>\n");
      out.write("                <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"2\"></li>\n");
      out.write("                <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"3\"></li>\n");
      out.write("            </ol>\n");
      out.write("            <div class=\"carousel-inner\">\n");
      out.write("                <div class=\"carousel-item active\">\n");
      out.write("                    <img\n");
      out.write("                        class=\"d-block w-100\"\n");
      out.write("                        src=\"images/1.png\"\n");
      out.write("                        alt=\"First slide\"\n");
      out.write("                        />\n");
      out.write("                    <div class=\"carousel-caption d-none d-md-block\">\n");
      out.write("                        <h5>First slide label</h5>\n");
      out.write("                        <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"carousel-item\">\n");
      out.write("                    <img\n");
      out.write("                        class=\"d-block w-100\"\n");
      out.write("                        src=\"images/2.png\"\n");
      out.write("                        alt=\"Second slide\"\n");
      out.write("                        />\n");
      out.write("                    <div class=\"carousel-caption d-none d-md-block\">\n");
      out.write("                        <h5>Second slide label</h5>\n");
      out.write("                        <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"carousel-item\">\n");
      out.write("                    <img class=\"d-block w-100\" src=\"images/3.png\" alt=\"Third slide\" />\n");
      out.write("                    <div class=\"carousel-caption d-none d-md-block\">\n");
      out.write("                        <h5>Third slide label</h5>\n");
      out.write("                        <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"carousel-item\">\n");
      out.write("                    <img\n");
      out.write("                        class=\"d-block w-100\"\n");
      out.write("                        src=\"images/4.jpg\"\n");
      out.write("                        alt=\"Fourth slide\"\n");
      out.write("                        />\n");
      out.write("                    <div class=\"carousel-caption d-none d-md-block\">\n");
      out.write("                        <h5>Fourth slide label</h5>\n");
      out.write("                        <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <a\n");
      out.write("                class=\"carousel-control-prev\"\n");
      out.write("                href=\"#carouselExampleIndicators\"\n");
      out.write("                role=\"button\"\n");
      out.write("                data-slide=\"prev\"\n");
      out.write("                >\n");
      out.write("                <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\n");
      out.write("                <span class=\"sr-only\">Previous</span>\n");
      out.write("            </a>\n");
      out.write("            <a\n");
      out.write("                class=\"carousel-control-next\"\n");
      out.write("                href=\"#carouselExampleIndicators\"\n");
      out.write("                role=\"button\"\n");
      out.write("                data-slide=\"next\"\n");
      out.write("                >\n");
      out.write("                <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\n");
      out.write("                <span class=\"sr-only\">Next</span>\n");
      out.write("            </a>\n");
      out.write("        </div>\n");
      out.write("        <div style=\"margin-top: 10px\">\n");
      out.write("            <button type=\"button\">\n");
      out.write("                <a style=\"color: blue; font-size: larger; text-decoration: none\" href=\"allproduct\">All Products</a>\n");
      out.write("            </button><br/>\n");
      out.write("            <button type=\"button\">\n");
      out.write("                <a style=\"color: blue; font-size: larger; text-decoration: none\" href=\"sneaker\">Sneakers</a>\n");
      out.write("            </button><br/>  \n");
      out.write("            <button type=\"button\">\n");
      out.write("                <a style=\"color: blue; font-size: larger; text-decoration: none\" href=\"slipon\">Slip-Ons</a>\n");
      out.write("            </button><br/>  \n");
      out.write("            <button type=\"button\">\n");
      out.write("                <a style=\"color: blue; font-size: larger; text-decoration: none\" href=\"boot\">Boots</a>\n");
      out.write("            </button><br/>\n");
      out.write("            <button type=\"button\">\n");
      out.write("                <a style=\"color: blue; font-size: larger; text-decoration: none\" href=\"sandal\">Sandals</a>\n");
      out.write("            </button>  \n");
      out.write("        </div>\n");
      out.write("        ");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        <footer class=\"site-footer\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-12 col-md-6\">\n");
      out.write("                        <h6>About</h6>\n");
      out.write("                        <p class=\"text-justify\">\n");
      out.write("                            Welcome to <i>PM Shoes Shop</i>.\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"col-xs-6 col-md-3\">\n");
      out.write("                        <h6>Categories</h6>\n");
      out.write("                        <ul class=\"footer-links\">\n");
      out.write("                            <li><a href=\"#\">Sneakers</a></li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">Slip-Ons</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">Boots</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">Sandals</a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"col-xs-6 col-md-3\">\n");
      out.write("                        <h6>Quick Links</h6>\n");
      out.write("                        <ul class=\"footer-links\">\n");
      out.write("                            <li><a href=\"about.jsp\">About Us</a></li>\n");
      out.write("                            <li><a href=\"contact.jsp\">Contact Us</a></li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">Contribute</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">Privacy Policy</a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <hr />\n");
      out.write("            </div>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-8 col-sm-6 col-xs-12\">\n");
      out.write("                        <p class=\"copyright-text\">\n");
      out.write("                            Copyright &copy; 2022 All Rights Reserved by\n");
      out.write("                            <a href=\"https://www.facebook.com/setoffgoal\">Nam Nguyen</a>.\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"col-md-4 col-sm-6 col-xs-12\">\n");
      out.write("                        <ul class=\"social-icons\">\n");
      out.write("                            <li>\n");
      out.write("                                <a class=\"facebook\" href=\"#\"\n");
      out.write("                                   ><img\n");
      out.write("                                        style=\"max-width: 45px; border-radius: 50%\"\n");
      out.write("                                        src=\"images/face.png\"\n");
      out.write("                                        /></a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a class=\"github\" href=\"#\"><img\n");
      out.write("                                        style=\"max-width: 45px; border-radius: 50%\"\n");
      out.write("                                        src=\"images/meo.png\"\n");
      out.write("                                        /></i></a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a class=\"inlinked\" href=\"#\"><img\n");
      out.write("                                        style=\"max-width: 45px; border-radius: 50%\"\n");
      out.write("                                        src=\"images/in.png\"\n");
      out.write("                                        /></i></a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.data == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                            <a class=\"navbar-brand\" href=\"login\" title=\"Login\">\n");
        out.write("                                <img\n");
        out.write("                                    style=\"max-width: 37px; border-radius: 50%\"\n");
        out.write("                                    src=\"images/login.png\"\n");
        out.write("                                    />\n");
        out.write("                            </a>\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.data != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                            <a class=\"navbar-brand\" href=\"logout\" title=\"Logout\">\n");
        out.write("                                <img\n");
        out.write("                                    style=\"max-width: 37px; border-radius: 50%\"\n");
        out.write("                                    src=\"images/login.png\"\n");
        out.write("                                    />\n");
        out.write("                            </a>\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent(null);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.listall != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            <table border=\"1px\" width=\"70%\">\n");
        out.write("                <tr>\n");
        out.write("                    <th>Id</th>\n");
        out.write("                    <th>Name</th>\n");
        out.write("                    <th>Image</th>\n");
        out.write("                    <th>Price</th>\n");
        out.write("                    <th>Stock</th>\n");
        out.write("                    <th>CId</th>\n");
        out.write("                </tr>\n");
        out.write("                ");
        if (_jspx_meth_c_forEach_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_2, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("            </table>\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_2);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.listall}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("i");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                    <tr>\n");
          out.write("                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                        <td><img style=\"max-height: 60px; max-width: 50px\" src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"/></td>\n");
          out.write("                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.stock}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.cid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                    </tr>\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
