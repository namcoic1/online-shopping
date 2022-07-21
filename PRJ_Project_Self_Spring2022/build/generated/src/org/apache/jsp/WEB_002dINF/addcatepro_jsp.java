package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addcatepro_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Management</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"css/app.css\" />\n");
      out.write("        <script src=\"js/app.js\"></script>\n");
      out.write("        <link\n");
      out.write("            rel=\"stylesheet\"\n");
      out.write("            href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\"\n");
      out.write("            />\n");
      out.write("        <style>\n");
      out.write("            #home1 {\n");
      out.write("                color: #3366cc;\n");
      out.write("                font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;\n");
      out.write("                font-size: larger;\n");
      out.write("                font-style: italic;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("            .home2 {\n");
      out.write("                color: #3366cc;\n");
      out.write("                font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;\n");
      out.write("                font-size: medium;\n");
      out.write("                font-style: italic;\n");
      out.write("                font-weight: bolder;\n");
      out.write("            }\n");
      out.write("            .img1 {\n");
      out.write("                max-width: 11%; \n");
      out.write("                border-radius: 50%\n");
      out.write("            }\n");
      out.write("            .img2 {\n");
      out.write("                max-width: 37px; \n");
      out.write("                border-radius: 50%\n");
      out.write("            }\n");
      out.write("            .img3 {\n");
      out.write("                max-width: 45px; \n");
      out.write("                border-radius: 50%\n");
      out.write("            }\n");
      out.write("            #link {\n");
      out.write("                font-family: sans-serif;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("            .text {\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            #part {\n");
      out.write("                margin-left: auto;\n");
      out.write("                margin-right: auto;\n");
      out.write("                margin-bottom: 2%;\n");
      out.write("                box-shadow: 0 0 4px 2px gray;\n");
      out.write("                border-radius: 5%;\n");
      out.write("                padding: 15px 5px;\n");
      out.write("            }\n");
      out.write("            .product button {\n");
      out.write("                background-color: #fb774b;\n");
      out.write("                display: none;\n");
      out.write("            }\n");
      out.write("            .product:hover button {\n");
      out.write("                display: inline-block;\n");
      out.write("            }\n");
      out.write("            #button {\n");
      out.write("                background-color: orange;\n");
      out.write("                border-radius: 8%;\n");
      out.write("                padding: 5px 15px;\n");
      out.write("                border: 1px solid #fff\n");
      out.write("            }\n");
      out.write("            .dropdown:hover div {\n");
      out.write("                display: block;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light bg-light fixed-top\">\n");
      out.write("            <a\n");
      out.write("                id=\"home1\"\n");
      out.write("                class=\"navbar-brand ml-5 mr-auto\"\n");
      out.write("                href=\"home\"\n");
      out.write("                title=\"Home\"\n");
      out.write("                ><img class=\"img1\" src=\"images/logo.jpg\"/>&nbsp;&nbsp;PM \n");
      out.write("                <i class=\"home2\">Shop</i></a>\n");
      out.write("                \n");
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
      out.write("            \n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                <ul class=\"navbar-nav ml-auto mr-auto\">\n");
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a id=\"link\" class=\"nav-link\" href=\"home\">Home&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a id=\"link\" class=\"nav-link\" href=\"#\">About&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a\n");
      out.write("                            class=\"nav-link dropdown-toggle\" href=\"product?id=0\" id=\"navbarDropdown\" role=\"button\"\n");
      out.write("                            data-bs-toggle=\"dropdown-toggle\" aria-expanded=\"false\"\n");
      out.write("                            id=\"link\"\n");
      out.write("                            >\n");
      out.write("                            Products\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<!--                            <a class=\"dropdown-item\" href=\"#\">Sneakers</a>\n");
      out.write("                            <div class=\"dropdown-divider\"></div> \n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\">St</a> -->\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a id=\"link\" class=\"nav-link\" href=\"#\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;News</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a id=\"link\" class=\"nav-link\" href=\"#\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Contact</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("                \n");
      out.write("                <ul class=\"navbar-nav ml-auto mr-5\">\n");
      out.write("                    ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                    ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"navbar-brand\" href=\"#\" title=\"Shopping Cart\">\n");
      out.write("                            <img class=\"img2\" src=\"images/shoppingcart.jpg\"/>&nbsp;</a>\n");
      out.write("                    </li>\n");
      out.write("                    <form class=\"form-inline my-2 my-lg-0\" action=\"search\">\n");
      out.write("                        <input\n");
      out.write("                            class=\"form-control mr-sm-2\"\n");
      out.write("                            type=\"text\"\n");
      out.write("                            name=\"form\"\n");
      out.write("                            placeholder=\"Search\"\n");
      out.write("                            aria-label=\"Search\"\n");
      out.write("                            value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.form}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\n");
      out.write("                            />\n");
      out.write("                        <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Search</button>\n");
      out.write("                    </form>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        \n");
      out.write("        <form>\n");
      out.write("          <div class=\"form-row\">\n");
      out.write("            <div class=\"form-group col-md-6\">\n");
      out.write("              <label for=\"inputEmail4\">Email</label>\n");
      out.write("              <input type=\"email\" class=\"form-control\" id=\"inputEmail4\" placeholder=\"Email\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group col-md-6\">\n");
      out.write("              <label for=\"inputPassword4\">Password</label>\n");
      out.write("              <input type=\"password\" class=\"form-control\" id=\"inputPassword4\" placeholder=\"Password\">\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"form-group\">\n");
      out.write("            <label for=\"inputAddress\">Address</label>\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"inputAddress\" placeholder=\"1234 Main St\">\n");
      out.write("          </div>\n");
      out.write("          <div class=\"form-group\">\n");
      out.write("            <label for=\"inputAddress2\">Address 2</label>\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"inputAddress2\" placeholder=\"Apartment, studio, or floor\">\n");
      out.write("          </div>\n");
      out.write("          <div class=\"form-row\">\n");
      out.write("            <div class=\"form-group col-md-6\">\n");
      out.write("              <label for=\"inputCity\">City</label>\n");
      out.write("              <input type=\"text\" class=\"form-control\" id=\"inputCity\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group col-md-4\">\n");
      out.write("              <label for=\"inputState\">State</label>\n");
      out.write("              <select id=\"inputState\" class=\"form-control\">\n");
      out.write("                <option selected>Choose...</option>\n");
      out.write("                <option>...</option>\n");
      out.write("              </select>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group col-md-2\">\n");
      out.write("              <label for=\"inputZip\">Zip</label>\n");
      out.write("              <input type=\"text\" class=\"form-control\" id=\"inputZip\">\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"form-group\">\n");
      out.write("            <div class=\"form-check\">\n");
      out.write("              <input class=\"form-check-input\" type=\"checkbox\" id=\"gridCheck\">\n");
      out.write("              <label class=\"form-check-label\" for=\"gridCheck\">\n");
      out.write("                Check me out\n");
      out.write("              </label>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          <button type=\"submit\" class=\"btn btn-primary\">Sign in</button>\n");
      out.write("    </form>                    \n");
      out.write("                            \n");
      out.write("        <footer style=\"margin-top: 15.5%\" class=\"site-footer\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                \n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-12 col-md-6\">\n");
      out.write("                        <h6>About</h6>\n");
      out.write("                        <p class=\"text-justify\">\n");
      out.write("                            Welcome to <a href=\"home\">\n");
      out.write("                                <i id=\"home1\" style=\"color: #bbb\">PM Shoes Shop</i></a>. \n");
      out.write("                            When you come here, you will experience our <i style=\"font-style: italic; font-weight: bold\">beautiful and spacious</i> footwear exhibition space. \n");
      out.write("                            Along with that, there will be many types of <i style=\"font-style: italic; font-weight: bold\">genuine and quality</i> footwear products for you to choose from. \n");
      out.write("                            Trust me we will never let you down. We are pleased to welcome you to our store.</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-xs-6 col-md-3\">\n");
      out.write("                        <h6>Categories</h6>\n");
      out.write("                        <ul class=\"footer-links\">\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<!--                            <li><a href=\"sneaker\">Sneakers</a></li>-->\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-xs-6 col-md-3\">\n");
      out.write("                        <h6>Quick Links</h6>\n");
      out.write("                        <ul class=\"footer-links\">\n");
      out.write("                            <li><a href=\"#\">About Us</a></li>\n");
      out.write("                            <li><a href=\"#\">Contact Us</a></li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"https://mail.google.com/mail\">Contribute</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">Privacy Policy</a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <hr />\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div class=\"container\">\n");
      out.write("                \n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-8 col-sm-6 col-xs-12\">\n");
      out.write("                        <p class=\"copyright-text\">\n");
      out.write("                            Copyright &copy; 2022 All Rights Reserved by\n");
      out.write("                            <a href=\"https://mail.google.com/mail\">Nam Nguyen</a>.\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-4 col-sm-6 col-xs-12\">\n");
      out.write("                        <ul class=\"social-icons\">\n");
      out.write("                            <li><a href=\"https://www.facebook.com/setoffgoal\">\n");
      out.write("                                <img class=\"img3\" src=\"images/face.png\"/></a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"https://github.com/namcoic1\">\n");
      out.write("                                    <img class=\"img3\" src=\"images/meo.png\"/></a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"https://www.linkedin.com/in/nguyen-nam-9129b2232/\">\n");
      out.write("                                    <img class=\"img3\" src=\"images/in.png\"/></a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("                   \n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>                      \n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.allcate}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("i");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                <a class=\"dropdown-item\" href=\"product?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a>\n");
          out.write("                            ");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.acc == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                        <li class=\"nav-item\"><a class=\"navbar-brand\" href=\"login\" title=\"Login\">\n");
        out.write("                            <img class=\"img2\" src=\"images/login.png\"/></a>\n");
        out.write("                        </li>\n");
        out.write("                    ");
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
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.acc != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                        <li class=\"nav-item dropdown\">\n");
        out.write("                            ");
        if (_jspx_meth_c_if_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_1, _jspx_page_context))
          return true;
        out.write(" \n");
        out.write("                            ");
        if (_jspx_meth_c_if_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_1, _jspx_page_context))
          return true;
        out.write(" \n");
        out.write("                        </li>\n");
        out.write("                    ");
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

  private boolean _jspx_meth_c_if_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.acc.user eq 'namnguyen'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                <a\n");
        out.write("                                    class=\"nav-link dropdown-toggle\" href=\"product?id=0\" id=\"navbarDropdown\" role=\"button\"\n");
        out.write("                                    aria-expanded=\"false\"\n");
        out.write("                                    id=\"link\"\n");
        out.write("                                    >\n");
        out.write("                                    <img class=\"img2\" src=\"images/login.png\"/>\n");
        out.write("                                </a>\n");
        out.write("                                <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
        out.write("                                    <a class=\"dropdown-item\" href=\"#\" title=\"Admin\">Hello ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.acc.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</a>\n");
        out.write("                                    <a class=\"dropdown-item\" href=\"cusupdate\" title=\"Information\">Info</a>\n");
        out.write("                                    <a class=\"dropdown-item\" href=\"admmanage\" title=\"Management\">Manage</a>\n");
        out.write("                                    <div class=\"dropdown-divider\"></div> \n");
        out.write("                                    <a class=\"dropdown-item\" href=\"logout\" title=\"Logout\">Logout</a>\n");
        out.write("                                </div>\n");
        out.write("                            ");
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

  private boolean _jspx_meth_c_if_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_3.setPageContext(_jspx_page_context);
    _jspx_th_c_if_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${!(sessionScope.acc.user eq 'namnguyen')}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                <a\n");
        out.write("                                    class=\"nav-link dropdown-toggle\" href=\"product?id=0\" id=\"navbarDropdown\" role=\"button\"\n");
        out.write("                                    aria-expanded=\"false\"\n");
        out.write("                                    id=\"link\"\n");
        out.write("                                    >\n");
        out.write("                                    <img class=\"img2\" src=\"images/login.png\"/>\n");
        out.write("                                </a>\n");
        out.write("                                <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
        out.write("                                    <a class=\"dropdown-item\" href=\"#\" title=\"Customer\">Hello ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.acc.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</a>\n");
        out.write("                                    <a class=\"dropdown-item\" href=\"cusupdate\" title=\"Information\">Info</a>\n");
        out.write("                                    <div class=\"dropdown-divider\"></div> \n");
        out.write("                                    <a class=\"dropdown-item\" href=\"logout\" title=\"Logout\">Logout</a>\n");
        out.write("                                </div>\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_if_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.allcate}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVar("i");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                <li><a href=\"product?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></li>\n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }
}
