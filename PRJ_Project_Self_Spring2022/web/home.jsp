<%-- 
    Document   : home
    Created on : Feb 22, 2022, 11:13:19 PM
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
        <title>PM Shoes Shop</title>
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
                margin-left: auto;
                margin-right: auto;
                margin-bottom: 2%;
                box-shadow: 0 0 4px 2px gray;
                border-radius: 7%;
                padding: 2.5vh 0.5vw;
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
                border-radius: 7%;
                padding: 5px 15px;
                border: 1px solid #fff;
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
<!--        <div class="text" style="z-index: 0">
            <img src="images/shoes-5717837__340.webp" style="max-width: 100%">
        </div>-->
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
                    <c:set var="cookie" value="${pageContext.request.cookies}"></c:set>
                    <c:if test="${sessionScope.acc == null and cookie.save == null}">
                        <li class="nav-item"><a class="navbar-brand" href="login" title="Login">
                            <img class="img" style="max-width: 35px;" src="images/login.png"/></a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.acc != null or cookie.save != null}">   
                        <li class="nav-item dropdown">
                            <c:if test="${(sessionScope.acc.user eq 'namnguyen')}">
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
                                int size;
                                if (txt != null) {
                                    Cart c = new Cart(txt, list);
                                    size = c.getItems().size();
                                } else {
                                    size = 0;
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
                            /><button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </ul>
            </div>
        </nav>
        <div
            id="carouselExampleIndicators"
            class="container-fluid carousel slide col-md-8 col-md-offset-3"
            data-ride="carousel"
            >
            <ol class="carousel-indicators">
                <li
                    data-target="#carouselExampleIndicators"
                    data-slide-to="0"
                    class="active"
                    ></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="d-block w-100"  src="images/header2.jpg" style="max-width: 100%" alt="Third slide" />
                    <div class="carousel-caption d-none d-md-block">
                        <h5 style="color: black;">Popular Boots</h5>
                    </div>
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="images/2.jpeg" style="max-width: 100%" alt="Fourth slide"/>
                    <div class="carousel-caption d-none d-md-block" style="color: floralwhite">
                        <h5>Special Boots</h5>
                        <p>Brown Boot</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100"src="images/header.jpg" style="max-width: 100%" alt="First slide"/>
                    <div class="carousel-caption d-none d-md-block">
                        <h5 style="color: floralwhite">Popular Sneakers</h5>
                    </div>
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="images/4.jpeg" style="max-width: 100%" alt="Second slide"/>
                    <div class="carousel-caption d-none d-md-block" style="color: black">
                        <h5>Special Sneakers</h5>
                        <p>Red Converse</p>
                    </div>
                </div>
            </div>
            <a
                class="carousel-control-prev"
                href="#carouselExampleIndicators"
                role="button"
                data-slide="prev"
                >
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a
                class="carousel-control-next"
                href="#carouselExampleIndicators"
                role="button"
                data-slide="next"
                >
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
                            
        <div class="container" style="margin-top: 3%">
            <div class="text" style="background-color: deepskyblue; color: white; margin: 0 0 2.5% 0; padding: 3px 0 1px 0">
                <h4>Newest Products</h4>
                <p>Many new products will be updated every week</p>
            </div>
            
            <div class="row">
                <c:forEach items="${requestScope.allcate}" var="c">
                    <c:forEach items="${requestScope.allpro}" var="p">
                        <c:if test="${c.id == p.cid && p.stock >= 40}">
                        <div id="part" class="col-xs-12 col-sm-5 col-md-2">
                            <div class="text product">
                                <div style="height: 7rem"><img style="width: 100%" src="${p.image}" /></div>
                                <div style="height: 3rem"><h5>${p.name}</h5></div>
                                <div><p style="color: red; font-size: large">$${p.price}</p></div>
                                <button id="button" class="col-sm-12 col-md-5">
                                    <a style="color: white; text-decoration: none;" href="detail?id=${p.id}&cid=${p.cid}">Detail</a>
                                </button>
                                <button id="button" class="col-sm-12 col-md-5"> 
                                    <a style="color: white; text-decoration: none;" href="addcart?id=${p.id}&cid=${p.cid}&num=1&trans=shop">Buy</a>
                                </button>
                            </div>
                        </div>
                        </c:if>
                    </c:forEach>
                </c:forEach>
            </div>
            
            <div class="text">
                <button style="color: black; background-color: white; border-radius: 8%; margin-top: 1%">
                    <a class="deco" style="color: black;" href="product?id=0">View more</a>
                </button>
            </div>   
        </div>
                            
        <div class="container" style="margin-top: 3%">
            <div class="text" style="background-color: #fb774b; color: white; margin: 0 0 2.5% 0; padding: 3px 0 1px 0">
                <h4>Recommend Products</h4>
                <p>Many highlight products which will be updated every week</p>
            </div>
            
            <div class="row">
                <c:forEach items="${requestScope.allcate}" var="c">
                    <c:forEach items="${requestScope.allpro}" var="p">
                        <c:if test="${c.id == p.cid && p.price >= 40}">
                            <div id="part" class="col-xs-12 col-sm-5 col-md-2" style="padding: 2vh 0.5vw;">
                            <div class="text product">
                                <div style="height: 10rem"><img style="width: 100%" src="${p.image}" /></div>
                                <div style="height: 3.5rem"><h5>${p.name}</h5></div>    
                                <div><p style="color: red; font-size: large">$${p.price}</p></div>
                                <button id="button" class="col-sm-12 col-md-5">
                                    <a style="color: white; text-decoration: none;" href="detail?id=${p.id}&cid=${p.cid}">Detail</a>
                                </button>
                                <button id="button" class="col-sm-12 col-md-5"> 
                                    <a style="color: white; text-decoration: none;" href="addcart?id=${p.id}&cid=${p.cid}&num=1&trans=shop">Buy</a>
                                </button>
                            </div>
                        </div>
                        </c:if>
                    </c:forEach>
                </c:forEach>
            </div>
            
           <div class="text">
                <button style="color: black; background-color: white; border-radius: 8%; margin-top: 1%">
                    <a class="deco" style="color: black;" href="product?id=0">View more</a>
                </button>
            </div>  
        </div>
                            
        <footer class="site-footer" style="margin-top: 9%">
            
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



