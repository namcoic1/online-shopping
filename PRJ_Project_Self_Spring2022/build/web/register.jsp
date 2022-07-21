<%-- 
    Document   : register
    Created on : Feb 24, 2022, 4:18:44 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PM Shoes Shop | Register</title>
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
            <h1 class="cap" style="color: white;">Register Form</h1><br/>
            <h2 class="cap" style="color: red;">${requestScope.err}</h2><br/>
            <form action="register" method="post">
                <input name='name' placeholder='Yourname' type='text' value="${param.name}">
                <input name='user' placeholder='Username' type='text'>
                <input id='pw' name='pass' placeholder='Password' type='password'>
                <input name='email' placeholder='E-Mail' type='text' value="${param.email}">
                <input name='phone' placeholder='Phone' type='text' value="${param.phone}">
                <input name='add' placeholder='Address' type='text' value="${param.add}">
                <!--            <div class='agree'>
                                <input id='agree' name='agree' type='checkbox'>
                                <label for='agree'></label>Accept rules and conditions
                            </div>-->
                <input class='animated' type='submit' value='Register'>
            </form>

            <div class="text"><a class='forgot' href='login'>Already have an account?</a>
                <!--&nbsp;Or&nbsp;<a class='forgot' href='home'>Back to home</a>-->
            </div>
                
        </div>
    </body>
</html>
