<%-- 
    Document   : product.jsp
    Created on : Feb 25, 2022, 10:08:31 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.Cart"%>
<%@page import="model.Products"%>
<%@page import="java.util.List"%>
<%@page import="dal.ProductDao"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <title>PM Shoes Shop | Products</title>
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" type="text/css" media="screen" href="css/app.css" />
        <script src="js/app.js"></script>
        <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
            />
        <style>
            #home {
                color: #3366cc;
                font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
                font-size: larger;
                font-style: italic;
                font-weight: bold;
            }
            .img {
                border-radius: 50%
            }
            #link {
                padding-left: 1.5vw;
                padding-right: 1.5vw;
                font-family: sans-serif;
                font-weight: bold;
            }
            .text {
                text-align: center;
            }
            #part {
                margin-left: 4.15%;
                margin-right: 4.15%;
                margin-bottom: 2%;
                box-shadow: 0 0 4px 2px gray;
                border-radius: 7%;
                padding: 2vh 0.5vw;
            }
            .product button {
                background-color: #fb774b;
                display: none;
            }
            .product:hover button {
                display: inline-block;
            }
            #button {
                background-color: orange;
                border-radius: 8%;
                padding: 5px 15px;
                border: 1px solid #fff
            }
            .dropdown:hover div {
                display: block;
            }
            #lblCartCount {
                font-size: 10px;
                background: black;
                color: #fff;
                padding: 2px 4px 2px 4px;
                text-align: center;
                border-radius: 50%;
                vertical-align: top;
                margin-left: -11px;
            }
            .badge {
                padding-left: 9px;
                padding-right: 9px;
                -webkit-border-radius: 9px;
                -moz-border-radius: 9px;
                border-radius: 9px;
            }
            .label-warning[href],
            .badge-warning[href] {
                background-color: #c67605;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
            <a
                id="home"
                class="navbar-brand ml-5 mr-auto"
                href="home"
                title="Home"
                ><img class="img" style="max-width: 11%;" src="images/logo.jpg"/>&nbsp;&nbsp;PM 
                <i class="home" style="font-size: medium;">Shop</i></a> 
            <button
                class="navbar-toggler"
                type="button"
                data-toggle="collapse"
                data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false"
                aria-label="Toggle navigation"
                >
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                
                <ul class="navbar-nav ml-auto mr-auto">
                    <li class="nav-item active">
                        <a id="link" class="nav-link" href="home">Home</a>
                    </li>
                    <li class="nav-item">
                        <a id="link" class="nav-link" href="#">About</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a
                            class="nav-link dropdown-toggle" href="product?id=0" id="navbarDropdown" role="button"
                            data-bs-toggle="dropdown-toggle" aria-expanded="false"
                            >
                            Products
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <c:forEach items="${requestScope.allcate}" var="i">
                                <a class="dropdown-item" href="product?id=${i.id}">${i.name}</a>
                            </c:forEach>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a id="link" class="nav-link" href="#">News</a>
                    </li>
                    <li class="nav-item">
                        <a id="link" class="nav-link" href="#">Contact</a>
                    </li>
                </ul>
                
                <ul class="navbar-nav ml-auto mr-5">
                    <c:if test="${sessionScope.acc == null}">
                        <li class="nav-item"><a class="navbar-brand" href="login" title="Login">
                            <img class="img" style="max-width: 35px;" src="images/login.png"/></a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.acc != null}">
                        <li class="nav-item dropdown">
                             <c:if test="${sessionScope.acc.user eq 'namnguyen'}">
                                <a
                                    class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                                    aria-expanded="false"
                                    >
                                    <img class="img" style="max-width: 35px;" src="images/login.png"/>
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="#" title="Admin">Hello Ad ${sessionScope.acc.name}</a>
                                    <a class="dropdown-item" href="cusupdate" title="Information">Information</a>
                                    <a class="dropdown-item" href="admmanage" title="Management">Management</a>
                                    <div class="dropdown-divider"></div> 
                                    <a class="dropdown-item" href="changepass" title="Change Password">Change Password</a>
                                    <a class="dropdown-item" href="logout" title="Logout">Logout</a>
                                </div>
                            </c:if> 
                            <c:if test="${!(sessionScope.acc.user eq 'namnguyen')}">
                                <a
                                    class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                                    aria-expanded="false"
                                    >
                                    <img class="img" style="max-width: 35px;" src="images/login.png"/>
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="#" title="Customer">Hello ${sessionScope.acc.name}</a>
                                    <a class="dropdown-item" href="cusupdate" title="Information">Information</a>
                                    <div class="dropdown-divider"></div> 
                                    <a class="dropdown-item" href="changepass" title="Change Password">Change Password</a>
                                    <a class="dropdown-item" href="logout" title="Logout">Logout</a>
                                </div>
                            </c:if> 
                        </li>
                    </c:if>
                    <li class="nav-item">
                        <a class="navbar-brand" href="shopcart" title="Shopping Cart">
                            <img class="img" style="max-width: 35px;" src="images/shoppingcart.jpg"/>
                            <%
                                ProductDao p = new ProductDao();
                                List<Products> list = p.getAll();
                                Cookie[] arr = request.getCookies();
                                String txt = "";
                                if (arr != null) {
                                    for (Cookie o : arr) {
                                        if (o.getName().equals("cart")) {
                                            txt += o.getValue();
                                        }
                                    }
                                }
                                Cart c = new Cart(txt, list);
                                int size = 0;
                                if (txt != null) {
                                    size = c.getItems().size();
                                }
                            %>
                            <span class='badge badge-warning' id='lblCartCount' <%= size == 0 ? "hidden" : ""%>>
                                <%= size%>
                            </span>
                        </a>
                    </li>
                    <form class="form-inline my-2 my-lg-0" action="search">
                        <input
                            class="form-control mr-sm-2"
                            type="text"
                            name="form"
                            placeholder="Search"
                            aria-label="Search"
                            value="${param.form}"
                            />
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </ul>
            </div>
        </nav>
                            
        <c:if test="${requestScope.allpro != null && requestScope.specialpro == null}">  
            <div style="margin-top: 9%;" class="container">
                <c:set var="cate" value="${requestScope.allcate}"/>
                <c:set var="cidd" value="${requestScope.cidd}"/>
                
                <form action="check">
                    <div class="row">
                        <div class="col-sm-12 col-md-4" style="text-align: left">
                            <h6>Categories</h6>
                            <c:forEach begin="0" end="${cate.size()-1}" var="i">
                                <input type="checkbox" name="cid" value="${cate.get(i).getId()}" 
                                       ${cidd[i]?"checked":""}   onclick="this.form.submit()" />
                                ${cate.get(i).getName()}
                                <br/>
                            </c:forEach>
                        </div>
                        <div class="col-sm-12 col-md-4 text">
                            <c:forEach begin="0" end="${cate.size()-1}"  var="i">
                                <c:if test="${cidd[i] == true}">
                                    <p hidden>${i = cate.size()-1}</p>
                                    <c:set var="temp" value="true"></c:set>
                                </c:if>
                            </c:forEach>
                            <c:if test="${!temp eq 'true'}">
                                <h3>All Products</h3>
                                <p>(Total: ${requestScope.size} Items)</p>
                            </c:if>
                            <c:if test="${temp eq 'true'}">
                                <h4>
                                <c:forEach begin="0" end="${cate.size()-1}"  var="i">
                                    ${cidd[i]? cate.get(i).getName(): ""}
                                </c:forEach>
                                </h4>
                                <h6>${requestScope.specialcate.des}</h6><br/>
                                <p>(Total: ${requestScope.size} Items)</p>
                            </c:if> 
                        </div>
                        <div class="col-sm-12 col-md-4" style="text-align: right">
                            <input type="hidden" name="select" value="${requestScope.select}"/>
                            <select name="op" onchange="this.form.submit()" class="form-select text" aria-label="Default select example">
                                <option ${select == "default" ? "selected" : ""} value="default">Default</option>
                                <option ${select == "best" ? "selected" : ""} value="best">Best Sellers</option>
                                <option ${select == "low" ? "selected" : ""} value="low">Price(Low to High)</option>
                                <option ${select == "high" ? "selected" : ""} value="high">Price(High to Low)</option>
                            </select>
                        </div>
                    </div>
                </form>     
                            
                <div class="row" style="margin: 2% 0 2% 0;">
                    <c:forEach items="${requestScope.data}" var="p">
                        <div id="part" class="col-xs-12 col-sm-5 col-md-2">
                            <div class="text product">
                                <c:if test="${p.cid != 3}">
                                    <div style="height: 7.5rem"><img style="width: 100%" src="${p.image}" /></div>
                                    <div style="height: 3.5rem"><h5>${p.name}</h5></div>
                                </c:if>
                                <c:if test="${p.cid == 3}">
                                    <div style="height: 9.5rem"><img style="width: 100%" src="${p.image}" /></div>
                                    <div style="height: 5rem"><h5>${p.name}</h5></div>    
                                </c:if>
                                <div><p style="color: red; font-size: large">$${p.price}</p></div>
                                <button id="button" class="col-sm-12 col-md-5">
                                    <a style="color: white; text-decoration: none;" href="detail?id=${p.id}&cid=${p.cid}">Detail</a>
                                </button>
                                <button id="button" class="col-sm-12 col-md-5"> 
                                    <a style="color: white; text-decoration: none;" href="addcart?id=${p.id}&cid=${p.cid}&num=1&trans=shop">Buy</a>
                                </button>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                            
                <c:set var="page" value="${requestScope.page}"></c:set>
                <nav aria-label="Page navigation example">
                        <ul class="pagination justify-content-center">
                        <c:forEach begin="0" end="${cate.size()-1}"  var="i">
                            <c:if test="${cidd[i] == true}">
                                <p hidden>${i = cate.size()-1}</p>
                                <c:set var="status" value="true"></c:set>
                            </c:if>
                        </c:forEach>
                        <c:if test="${status eq 'true'}">
                            <c:forEach begin="${1}" end="${requestScope.num}" var="z">
                                <li class="page-item ${page==z? "active":""}"><a class="page-link" href="check?op=${select}<c:forEach begin="0" end="${cate.size()-1}" var="i"><c:if test="${cidd[i] == true}">&cid=${cate.get(i).getId()}</c:if></c:forEach>&page=${z}">${z}</a></li>
                            </c:forEach>
                        </c:if> 
                        <c:if test="${!(status eq 'true')}">
                            <c:forEach begin="${1}" end="${requestScope.num}" var="z">
                                <li class="page-item ${page==z? "active":""}"><a class="page-link" href="check?op=${select}&page=${z}">${z}</a></li>      
                            </c:forEach>
                        </c:if>
                    </ul>
                </nav>
            </div>
        </c:if>
                            
        <c:if test="${requestScope.specialpro != null}">
            <div class="container" style="margin-top: 9%;">
                
                <div class="text">
                    <h3>${requestScope.specialcate.name}</h3>
                    <h6>${requestScope.specialcate.des}</h6><br/>
                    <p>(Total: ${requestScope.size} Items)</p>
                </div>
                            
                <div class="row" style="margin: 4% 0 2% 0">
                    <c:forEach items="${requestScope.specialpro}" var="p">
                        <div id="part" class="col-xs-12 col-sm-5 col-md-2">
                            <div class="text product"> 
                                <c:if test="${p.cid != 3}">
                                    <div style="height: 7.5rem"><img style="width: 100%" src="${p.image}" /></div>
                                    <div style="height: 3.5rem"><h5>${p.name}</h5></div>
                                </c:if>
                                <c:if test="${p.cid == 3}">
                                    <div style="height: 9.5rem"><img style="width: 100%" src="${p.image}" /></div>
                                    <div style="height: 5rem"><h5>${p.name}</h5></div>    
                                </c:if>
                                <div><p style="color: red; font-size: large">$${p.price}</p></div>
                                <button id="button" class="col-sm-12 col-md-5">
                                    <a style="color: white; text-decoration: none;" href="detail?id=${p.id}&cid=${p.cid}">Detail</a>
                                </button>
                                <button id="button" class="col-sm-12 col-md-5"> 
                                    <a style="color: white; text-decoration: none;" href="addcart?id=${p.id}&cid=${p.cid}&num=1&trans=shop">Buy</a>
                                </button>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                
                <c:set var="page" value="${requestScope.page}"></c:set>
                <nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-center">
                        <c:forEach begin="${1}" end="${requestScope.num}" var="z">
                            <li class="page-item ${page==z? "active":""}"><a class="page-link" href="product?id=${requestScope.specialcate.id}&page=${z}">${z}</a></li>      
                        </c:forEach>
                    </ul>
                </nav>        
            </div>
        </c:if>
                            
        <c:if test="${requestScope.searchpro != null}">
            
            <div class="container" style="margin-top: 9%;">
                <c:set var="k" value="${requestScope.key}"/>
                <div class="text">
                    <h3>Results about '${k}'</h3>
                    <p>(Total: ${requestScope.size} Items)</p>
                </div>
                    
                <div class="row" style="margin: 5% 0 2% 0">
                    <c:forEach items="${requestScope.searchpro}" var="p">
                        <div id="part" class="col-xs-12 col-sm-5 col-md-2">
                            <div class="text product"> 
                                <c:if test="${p.cid != 3}">
                                    <div style="height: 8rem"><img style="width: 100%" src="${p.image}" /></div>
                                    <div style="height: 3.5rem"><h5>${p.name}</h5></div>
                                </c:if>
                                <c:if test="${p.cid == 3}">
                                    <div style="height: 9.5rem"><img style="width: 100%" src="${p.image}" /></div>
                                    <div style="height: 5rem"><h5>${p.name}</h5></div>    
                                </c:if>
                                <div><p style="color: red; font-size: large">$${p.price}</p></div>
                                <button id="button" class="col-sm-12 col-md-5">
                                    <a style="color: white; text-decoration: none;" href="detail?id=${p.id}&cid=${p.cid}">Detail</a>
                                </button>
                                <button id="button" class="col-sm-12 col-md-5"> 
                                    <a style="color: white; text-decoration: none;" href="addcart?id=${p.id}&cid=${p.cid}&num=1&trans=shop">Buy</a>
                                </button>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                
                <c:set var="page" value="${requestScope.page}"></c:set>
                    <nav aria-label="Page navigation example">
                        <ul class="pagination justify-content-center">
                        <c:forEach begin="${1}" end="${requestScope.num}" var="z">
                                <li class="page-item ${page==z? "active":""}"><a class="page-link" href="search?form=${k}&page=${z}">${z}</a></li>
                        </c:forEach>
                    </ul>
                </nav>        
            </div>
        </c:if>
            
        <footer class="site-footer" style="margin-top: 12%">
            
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 col-md-6">
                        <h6>About</h6>
                        <p class="text-justify">
                            Welcome to <a href="home">
                            <i id="home" style="color: #bbb">PM Shoes Shop</i></a>. 
                            When you come here, you will experience our <i class="i">beautiful and spacious</i> footwear exhibition space. 
                            Along with that, there will be many types of <i class="i">genuine and quality</i> footwear products for you to choose from. 
                            Trust me we will never let you down. We are pleased to welcome you to our store.</p>
                    </div>
                    <div class="col-xs-6 col-md-3">
                        <h6>Categories</h6>
                        <ul class="footer-links">
                            <c:forEach items="${requestScope.allcate}" var="i">
                                <li><a href="product?id=${i.id}">${i.name}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="col-xs-6 col-md-3">
                        <h6>Quick Links</h6>
                        <ul class="footer-links">
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">Contact Us</a></li>
                            <li>
                                <a href="https://mail.google.com/mail">Contribute</a>
                            </li>
                            <li>
                                <a href="#">Privacy Policy</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <hr />
            </div>

            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-sm-6 col-xs-12">
                        <p class="copyright-text">
                            Copyright &copy; 2022 All Rights Reserved by
                            <a href="https://mail.google.com/mail">Nam Nguyen</a>.
                        </p>
                    </div>
                    <div class="col-md-4 col-sm-6 col-xs-12">
                        <ul class="social-icons">
                            <li><a href="https://www.facebook.com/setoffgoal">
                                    <img class="img" style="max-width: 45px" src="images/face.png"/></a>
                            </li>
                            <li>
                                <a href="https://github.com/namcoic1">
                                    <img class="img" style="max-width: 45px" src="images/meo.png"/></a>
                            </li>
                            <li>
                                <a href="https://www.linkedin.com/in/nguyen-nam-9129b2232/">
                                    <img class="img" style="max-width: 45px" src="images/in.png"/></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </footer>
            
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>
