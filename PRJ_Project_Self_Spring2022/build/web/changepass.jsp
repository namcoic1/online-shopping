<%-- 
    Document   : changepass
    Created on : Mar 15, 2022, 12:12:58 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PM Shoes Shop | Change Password Ad/Cus</title>
        <style>
            .forgot {
                color: #fff;
                margin-top: 30px;
                display: inline-block;
                font-size: 11px;
                font-weight: bold;
            }
            .forgot:hover {
                margin-top: 30px;
                display: inline-block;
                font-size: 11px;
                font-weight: bold;
                color: #3366cc;
            }
            .cap {
                font-family: sans-serif;
            }
            .text {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Sofia' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" type="text/css" media="screen" href="css/register.css" /> 
        <div class='login'>
            
            <c:if test="${requestScope.change != null}">
                <h1 class="cap" style="color: white;">Change Form</h1><br/>
                <h2 class="cap" style="color: red;">${requestScope.err}</h2><br/>
                <c:set var="i" value="${requestScope.info}"></c:set>
                <form action="changepass" method="post">
                <input name='old' placeholder='Old Password' type='password' value="${i.pass}" required>
                <input name='new' placeholder='New Password' type='password' value="" required>
                <input name='new1' placeholder='Confirm New Password' type='password' value="" required>
                <input class='animated' type='submit' value='Save'>
                </form>
                <div class="text"> <a class='forgot' href='home'>&leftarrow;<span class="text-muted"> Back to home</span></a></div>
            </c:if>
            
            <c:if test="${requestScope.change == null}">
                <c:if test="${requestScope.pass == null}">
                    <h1 class="cap" style="color: white;">Username Form</h1><br/>
                    <h2 class="cap" style="color: red;">${requestScope.err}</h2><br/>
                    <form action="forgot" method="post">
                        <input name='name' placeholder='enter username' type='text' value="${param.name}" required><br/>
                        <input class='animated' type='submit' value='Check'>
                    </form>
                    <div class="text"> <a class='forgot' href='login'>&leftarrow;<span class="text-muted"> Back to login</span></a></div>
                </c:if>
                <c:if test="${requestScope.pass != null}">
                    <h1 class="cap" style="color: white;">Update Form</h1><br/>
                    <h2 class="cap" style="color: red;">${requestScope.err}</h2><br/>
                    <form action="forgot" method="post">
                        <input name='new' placeholder='New Password' type='password' value="" required>
                        <input name='new1' placeholder='Confirm New Password' type='password' value="" required>
                        <input class='animated' type='submit' value='Save'>
                    </form>
                    <div class="text"> <a class='forgot' href='login'>&leftarrow;<span class="text-muted"> Back to login</span></a></div>
                </c:if>
            </c:if>
            
        </div>
    </body>
</html>
