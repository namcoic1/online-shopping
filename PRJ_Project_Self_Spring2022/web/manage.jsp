<%-- 
    Document   : manage
    Created on : Mar 3, 2022, 4:57:45 PM
    Author     : Dell
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.Cart"%>
<%@page import="dal.ProductDao"%>
<%@page import="model.Products"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <title>PM Shoes Shop | Management</title>
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
            .table {
                width: 85%; 
                font-size: medium; 
                text-align: center;
            }
        </style>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            google.charts.load("current", {packages:["corechart"]});
            google.charts.setOnLoadCallback(drawChart);
            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                  ['Task', 'Hours per Day'],
                    <c:forEach items="${requestScope.show1}" var="j">
                         ['${j.name}', ${j.total}],
                    </c:forEach>
                ]);
                var options = {
                  title: 'My Statistic of Categories',
                  pieHole: 0.4
                };
                var chart = new google.visualization.PieChart(document.getElementById('catechart'));
                chart.draw(data, options);
            }
        </script>
        <script type="text/javascript">
            google.charts.load("current", {packages:["corechart"]});
            google.charts.setOnLoadCallback(drawChart);
            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                  ['Task', 'Hours per Day'],
                    <c:forEach items="${requestScope.show2}" var="j">
                         ['${j.name}', ${j.total}],
                    </c:forEach>
                ]);
                var options = {
                  title: 'My Statistic of Customers',
                  pieHole: 0.4
                };
                var chart = new google.visualization.PieChart(document.getElementById('cuschart'));
                chart.draw(data, options);
            }
        </script>
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
        
        <div class="container-fluid" style="margin-top: 13%;">
            <div></div>
            <div class="row">
                <div class="col-xs-12 col-sm-3 col-md-2" style="margin-left: 9%">
                    <div class="list-group text-justify">
                      <c:set var="j" value="${requestScope.select}"></c:set>
                      <a style="background-color: #16aa56; color: white; border: 1px solid green" href="admmanage?kind=" type="button" class="list-group-item list-group-item-action active">Menu</a>
                      <a href="admmanage?kind=cus" class="list-group-item list-group-item-action ${j eq 'cus'? "active":""}">Customers</a>
                      <a href="admmanage?kind=cate" class="list-group-item list-group-item-action ${j eq 'cate'? "active":""}">Categories</a>
                      <a href="admmanage?kind=pro" class="list-group-item list-group-item-action ${j eq 'pro'? "active":""}">Products</a>
                      <a href="admmanage?kind=shi" class="list-group-item list-group-item-action ${j eq 'shi'? "active":""}">Shippers</a>
                      <a href="admmanage?kind=sta" class="list-group-item list-group-item-action ${j eq 'sta'? "active":""}">Statics</a>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-7 col-md-8" style="margin-left: 7%">
                    <c:if test="${requestScope.allcus != null}">
                        <div class="table-responsive-sm table-responsive-md">
                        <table class="table table-hover">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Name</th>
                                <th scope="col">Email</th>
                                <th scope="col">Phone</th>
                                <th scope="col">Address</th>
                                <!--<th scope="col">Action</th>-->
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.allcus}" var="i">
                            <tr>
                                <c:if test="${!(i.user eq 'namnguyen')}">
                                    <td>${i.id}</td>
                                    <td>${i.name}</td>
                                    <td>${i.email}</td>
                                    <td>${i.phone}</td>
                                    <td>${i.address}</td>
                                    <!--<td><a href="#" onclick="doDel('${i.id}', 'Customer')" title="Delete"><img style="width: 25px" src="images/remove.png"/></a></td>-->
                                </c:if>
                            </tr>
                            </c:forEach>
                        </tbody>
                        </table>
                        </div>
                    </c:if>
                    <c:if test="${requestScope.allpro != null}">
                        <div class="table-responsive-sm table-responsive-md">
                        <table class="table table-hover text" style="width: 90%; font-size: small;">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Name</th>
                                <th scope="col">Image</th>
                                <th scope="col">Price</th>
                                <th scope="col">Stock</th>
                                <th scope="col">Detail</th>
                                <th scope="col">Category</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.allpro}" var="i">
                            <tr>
                                <td>${i.id}</td>
                                <td>${i.name}</td>
                                <td><img style="max-width: 50%" src="${i.image}"/></td>
                                <td>${i.price}</td>
                                <td>${i.stock}</td>
                                <td>${i.detail}</td>
                                <td>${i.cate.name}</td>
                                <td>
                                    <a href="updateany?id=${i.id}&name=pro" title="Update"><img style="width: 19%" src="images/uppro.png"/></a>
                                    <a href="#" onclick="doDel('${i.id}', 'Product')" title="Delete"><img style="width: 19%" src="images/delpro.png"/></a>
                                </td>
                            </tr>
                            </c:forEach>
                        </tbody>
                        </table>
                        </div><br/>
                        <c:set var="page" value="${requestScope.page}"></c:set>
                        <div class="row">
                            <div class="col-sm-12 col-md-2" style="text-align: left">
                                <a id="link" class="nav-link" href="addany?type=pro" title="Add"><img style="width: 40px; height: 40px" src="images/addpro.png"/></a>
                            </div>
                            <div class="col-sm-12 col-md-8 text">
                                <nav aria-label="Page navigation example">
                                <ul class="pagination justify-content-center">
                                    <c:forEach begin="${1}" end="${requestScope.num}" var="z">
                                        <li class="page-item ${page==z? "active":""}"><a class="page-link" href="admmanage?kind=${j}&page=${z}">${z}</a></li>      
                                    </c:forEach>
                                </ul>
                                </nav> 
                            </div>
                        </div>
                        <br/><c:if test="${requestScope.err != null}">
                        <div class="alert alert-warning" role="alert" style="width: 90%">${requestScope.err}</div>
                        </c:if>
                    </c:if>
                    <c:if test="${requestScope.cate != null}">
                        <div class="table-responsive-sm table-responsive-md">
                        <table class="table table-hover table">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Name</th>
                                <th scope="col">Image</th>
                                <th scope="col">Detail</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.cate}" var="i">
                            <tr>
                                <td>${i.id}</td>
                                <td>${i.name}</td>
                                <td><img style="max-width: 15%;" src="${i.image}"/></td>
                                <td>${i.des}</td>
                                <td>
                                    <a href="updateany?id=${i.id}&name=cate" title="Update"><img style="width: 13%" src="images/uppro.png"/></a>
                                    <a href="#" onclick="doDel('${i.id}', 'Category')" title="Delete"><img style="width: 13%" src="images/delpro.png"/></a>
                                </td>
                            </tr>
                            </c:forEach>
                        </tbody>
                        </table>
                        </div>
                        <a id="link" class="nav-link" href="addany?type=cate" title="Add"><img style="width: 40px; height: 40px" src="images/addpro.png"/></a>
                        <br/><c:if test="${requestScope.err != null}">
                        <div class="alert alert-warning" role="alert" style="width: 85%">${requestScope.err}</div>
                        </c:if>
                    </c:if>
                    <c:if test="${requestScope.allship != null}">
                        <div class="table-responsive-sm table-responsive-md">
                        <table class="table table-hover table">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Name</th>
                                <th scope="col">Phone</th>
                                <th scope="col">Status</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.allship}" var="i">
                            <tr>
                                <td>${i.id}</td>
                                <td>${i.name}</td>
                                <td>${i.phone}</td>
                                <td>
                                    <c:if test="${i.status eq 'true'}">
                                        On
                                    </c:if>
                                    <c:if test="${!(i.status eq 'true')}">
                                        Off
                                    </c:if>
                                </td>
                                <td>
                                    <a href="updateany?id=${i.id}&name=ship" title="Update"><img style="width: 35px" src="images/uppro.png"/></a>
                                    <a href="#" onclick="doDel('${i.id}', 'Shipper')" title="Delete"><img style="width: 35px" src="images/delpro.png"/></a>
                                </td>
                            </tr>
                            </c:forEach>
                        </tbody>
                        </table>
                        </div>
                        <a id="link" class="nav-link" href="addany?type=ship" title="Add"><img style="width: 40px; height: 40px" src="images/addpro.png"/></a>
                        <br/><c:if test="${requestScope.err != null}">
                        <div class="alert alert-warning" role="alert" style="width: 85%">${requestScope.err}</div>
                        </c:if>
                    </c:if>  
                        <c:if test="${requestScope.sta != null}">
                            <div class="row">
                                <div id="catechart" class="list-group-item list-group-item-action col-sm-12 col-md-5" style="width: 900px; height: 500px;"></div>
                                <div id="cuschart" class="list-group-item list-group-item-action col-sm-12 col-md-5" style="width: 900px; height: 500px;"></div>
                            </div>
                        </c:if>
                </div>
            </div>
        </div>                    

        <footer class="site-footer" style="margin-top: 13.5%">
            
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
        <script type="text/javascript">
            function doDel(id, name) {
                if (confirm("Are you sure to delete " +name+ " with id='" +id+ "'?")) {
                    window.location = "deleteany?id=" +id+ "&name=" + name;
                }
            }
        </script>                    
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>                   
    </body>
</html>
