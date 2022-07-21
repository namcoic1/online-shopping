<%-- 
    Document   : register
    Created on : Feb 24, 2022, 4:18:44 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PM Shoes Shop | Update Ad/Cus</title>
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
            
            <h1 class="cap" style="color: white;">Update Form</h1><br/>
            <h2 class="cap" style="color: red;">${requestScope.err}</h2><br/>
            
            <c:set var="i" value="${requestScope.info}"></c:set>
            <form action="cusupdate" method="post">
            <input name='name' placeholder='Yourname' type='text' value="${i.name}">
            <input name='email' placeholder='E-Mail' type='text' value="${i.email}">
            <input name='phone' placeholder='Phone' type='text' value="${i.phone}">
            <input name='add' placeholder='Address' type='text' value="${i.address}">
            <input class='animated' type='submit' value='Save'>
            </form>
            
            <div class="text"> <a class='forgot' href='home'>&leftarrow;<span class="text-muted"> Back to home</span></a></div>
            
        </div>
    </body>
</html>
