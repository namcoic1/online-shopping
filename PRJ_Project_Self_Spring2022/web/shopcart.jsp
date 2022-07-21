<%-- 
    Document   : shopcart
    Created on : Mar 8, 2022, 4:21:39 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Cart"%>
<%@page import="model.Products"%>
<%@page import="java.util.List"%>
<%@page import="dal.ProductDao"%>
<!DOCTYPE html>
<html>
   <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <title>Your Cart</title>
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
            .hr {
                width: 70%; 
                margin-top: 2%; 
                margin-bottom: 2%;
                background-color: black;
            }
            .size {
                font-size: medium;
                margin-bottom: 10%;
            }
        </style>
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
                            
        <div class="container" style="margin-top: 10%; margin-bottom: 13%;">
            <c:if test="${requestScope.size == 0}">
                <div style="margin-bottom: 32.5%">
                    <h3 class="text" style="font-size: xx-large">Your Cart</h3>
                    <c:if test="${requestScope.suc != null}">
                        <h6 class="text" style="margin-top: 3%; color: green">Checkout successfully! Goods will deliveried soon for you.</h6>
                        <hr class="hr text"/>
                        <div class="row">
                            <div class="col-sm-12 col-md-6 text">
                                <a id="button" style="color: white; text-decoration: none; font-size: large; text-align: left" href="history">History</a>
                            </div>
                            <div class="col-sm-12 col-md-6 text">
                                <a type="button" style="margin-top: 1%; text-decoration: none" href="product?id=0">&leftarrow;<span class="text-muted"> Continue shopping</span></a>
                            </div>    
                        </div>
                        <c:if test="${requestScope.order.size() == 0}">
                            <h4 class="text" style="color: #3366cc; margin-top: 5%">You haven't ordered product before!</h4>
                        </c:if>
                        <c:if test="${requestScope.order != null && requestScope.order.size() != 0}">
                        <div class="table-responsive-sm table-responsive-md text" style="margin-top: 7%">
                            <table class="table table-hover">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">No</th>
                                    <th scope="col">OrderedDate</th>
                                    <th scope="col">ShippedDate</th>
                                    <th scope="col">ShippedAddress</th>
                                    <th scope="col">TotalAmount</th>
                                    <th scope="col">Shipper</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="o" value="0"></c:set>
                                <c:set var="p" value="0"></c:set>
                                <c:forEach items="${requestScope.order}" var="i">
                                <c:set var="o" value="${o+1}"></c:set>
                                <tr>
                                    <td>${o}</td>
                                    <td>${i.orddate}</td>
                                    <td>${i.shidate}</td>
                                    <td>${i.shiaddress}</td>
                                    <td>${i.amount}</td>
                                    <td>${i.ship.name}</td>
                                    <c:set var="p" value="${p+i.amount}"></c:set>
                                </tr>
                                </c:forEach>
                            </tbody>
                            </table>
                        </div><br/>
                        <h5 style="color: red">Total: $${p}.</h5>  
                        </c:if>
                        <c:if test="${requestScope.detail != null}">
                        <div class="table-responsive-sm table-responsive-md text" style="margin-top: 7%">
                            <table class="table table-hover">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">No</th>
                                    <th scope="col"></th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Quantity</th>
                                    <th scope="col">Price</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="o" value="0"></c:set>
                                <c:forEach items="${requestScope.detail}" var="i">
                                <c:set var="o" value="${o+1}"></c:set>
                                    <tr>
                                    <td>${o}</td>
                                    <td><img src="${i.product.image}" style="max-width: 130px;"/></td>
                                    <td>${i.product.name}</td>
                                    <td>${i.quantity}</td>
                                    <td>${i.price}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                            </table>
                        </div>
                        </c:if>
                    </c:if>
                    <c:if test="${requestScope.suc == null}">
                        <h6 class="text" style="margin-top: 3%">Your Shopping Cart is Empty</h6>
                        <hr class="hr text"/>
                        <div class="row">
                            <div class="col-sm-12 col-md-6 text">
                                <a id="button" style="color: white; text-decoration: none; font-size: large; text-align: left" href="history">History</a>
                            </div>
                            <div class="col-sm-12 col-md-6 text">
                                <a type="button" style="margin-top: 1%; text-decoration: none; text-align: right" href="product?id=0">&leftarrow;<span class="text-muted"> Back to shop</span></a>
                            </div>    
                        </div>
                        <c:if test="${requestScope.order.size() == 0}">
                            <h4 class="text" style="color: #3366cc; margin-top: 5%">You haven't ordered product before!</h4>
                        </c:if>
                        <c:if test="${requestScope.order != null && requestScope.order.size() != 0}">
                        <div class="table-responsive-sm table-responsive-md text" style="margin-top: 7%">
                            <table class="table table-hover">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">No</th>
                                    <th scope="col">OrderedDate</th>
                                    <th scope="col">ShippedDate</th>
                                    <th scope="col">ShippedAddress</th>
                                    <th scope="col">TotalAmount</th>
                                    <th scope="col">Shipper</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="o" value="0"></c:set>
                                <c:set var="p" value="0"></c:set>
                                <c:forEach items="${requestScope.order}" var="i">
                                <c:set var="o" value="${o+1}"></c:set>
                                    <tr style="cursor: pointer;" onclick="window.location='history?id=${i.id}'">
                                    <td>${o}</td>
                                    <td>${i.orddate}</td>
                                    <td>${i.shidate}</td>
                                    <td>${i.shiaddress}</td>
                                    <td>${i.amount}</td>
                                    <td>${i.ship.name}</td>
                                    <c:set var="p" value="${p+i.amount}"></c:set>
                                    </tr>
                                </c:forEach>
                            </tbody>
                            </table>
                        </div><br/>
                        <h5 style="color: red">Total: $${p}.</h5>  
                        </c:if>
                        <c:if test="${requestScope.detail != null}">
                        <div class="table-responsive-sm table-responsive-md text" style="margin-top: 7%">
                            <table class="table table-hover">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">No</th>
                                    <th scope="col"></th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Quantity</th>
                                    <th scope="col">Price</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="o" value="0"></c:set>
                                <c:forEach items="${requestScope.detail}" var="i">
                                <c:set var="o" value="${o+1}"></c:set>
                                    <tr>
                                    <td>${o}</td>
                                    <td><img src="${i.product.image}" style="max-width: 130px;"/></td>
                                    <td>${i.product.name}</td>
                                    <td>${i.quantity}</td>
                                    <td>${i.price}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                            </table>
                        </div>
                        </c:if>
                    </c:if>
                </div>
            </c:if>
            <c:if test="${requestScope.size != 0}">
            <h3 class="text" style="font-size: xx-large">Your Cart</h3>
            <div class="row" style="margin-top: 5%;">
                <div class="col-sm-12 col-md-8 mr-3">
                    <c:set var="o" value="${requestScope.cart}"/>
                    <c:set var="no" value="0"/>
                    <div class="table-responsive-sm table-responsive-md">
                    <table class="table table-hover text size">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">No</th>
                            <th scope="col"></th>
                            <th scope="col">Name</th>
                            <th scope="col">Each</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">Total</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${o.items}" var="i">
                            <c:set var="no" value="${no+1}"/>
                            <tr>
                                <td>${no}</td>
                                <td><img style="max-width: 50%; padding: 1px 0; border-radius: 2.5%" src="${i.product.image}"/></td>
                                <td>${i.product.name}</td>
                                <td>${i.price}</td>
                                <td>
                                    <a style="background-color: black; color: white; padding: 0.5px 1.5px; border-radius: 50%" href="process?num=-1&id=${i.product.id}"><</a>
                                    ${i.quantity}
                                    <a style="background-color: black; color: white; padding: 0.5px 1.5px; border-radius: 50%" href="process?num=1&id=${i.product.id}">></a>
                                </td>
                                <td>${(i.price*i.quantity)}</td>
                                <td>
                                <form action="process" method="post">
                                    <input type="hidden" name="id" value="${i.product.id}"/>
                                    <button class="img" style="background-color: white; border: white;" type="submit">
                                        <img src="images/remove-from-cart.png" style="max-width: 30px; padding: 5.5px 1px;"/></button>
                                </form>
                                </td>
                            </tr>
                        </c:forEach> 
                    </tbody>
                    </table>
                    <div>
                        <h6><p style="display: inline-block; margin: 0 75% 0 11%">${o.totalQuantity} Items</p>
                            <p style="display: inline-block; color: red">$${o.totalMoney}</p></h6>
                        <a type="button" style="margin-top: 1%; text-decoration: none" href="product?id=0">&leftarrow;<span class="text-muted"> Back to shop</span></a>
                    </div>
                    </div>
                </div>
                <div class="col-sm-12 col-md-3 ml-5">
                    <div style="margin-bottom: 13%">
                        <form style="font-size: smaller;" action="sale">
                        <div style="margin-bottom: 13%">
                            <h6>Enter Promo Code</h6>
                            <input style="max-width: 100%; padding: 9px 2px" type="text" name="code" value="" placeholder="Promo Code"/><input style="background-color: #3366cc; color: white; padding: 9px 15px" type="submit" value="Submit"/>
                        </div>
                        <div>    
                            <h6>Shipping</h6>
                            <c:set var="i" value="${requestScope.kind}"></c:set>
                            <select style="max-width: 90%; padding: 9px 2px;" name="op" onchange="this.form.submit()">
                                <option value="0" ${kind eq 'default'? "selected":""}>Standard (arrives in 4-9 business days)</option>
                                <option value="1" ${kind eq 'rush'? "selected":""}>Rush (arrives in 2-3 business days)</option>
                                <option value="2" ${kind eq 'express'? "selected":""}>Express (arrives in 1-2 business days)</option>
                            </select>
                        </div>
                        </form>
                    </div>
                    <div>
                        <form action="checkout">
                            <div>
                                <c:set var="i" value="${requestScope.sale}"></c:set>
                                <c:set var="j" value="${requestScope.much}"></c:set>
                                <h6 style="font-size: small">Shipping Cost<span style="padding-left: 50%;"><c:if test="${i != null}">$${i}</c:if><c:if test="${i == null}"><c:if test="${j != null}">$${j}</c:if><c:if test="${j == null}">$0</c:if></c:if></span></h6>
                                <h6 style="font-size: small">Sale Tax<span style="padding-left: 65%;">$0</span></h6>
                                <c:set var="k" value="0"></c:set>
                                <c:if test="${i != null}"><c:set var="k" value="${k+i}"></c:set></c:if>
                                <c:if test="${i == null}">
                                    <c:if test="${j != null}">
                                        <c:set var="k" value="${k+j}"></c:set>
                                    </c:if>
                                </c:if>
                                <h5 class="size">Estimated Total<span style="padding-left: 36%; color: red">$${o.totalMoney+k}</span></h5>
                            </div>
                            <input type="hidden" name="shidate" value="${requestScope.kind == null? "default":requestScope.kind}"/>
                            <input type="hidden" name="total" value="${o.totalMoney+k}"/>
                            <input 
                                style="width: 100%; 
                                background-color: #3366cc; 
                                color: white; 
                                padding: 9px 15px;" 
                                type="submit" value="Checkout"/>
                        </form>
                    </div>
                </div>
            </div>        
            </c:if>
        </div>

        <footer class="site-footer" style="margin-top: 13%">
            
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
