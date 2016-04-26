<%-- 
    Document   : confirm
    Created on : Apr 25, 2016, 3:36:47 PM
    Author     : Gabi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/login_css.css">
        <jsp:include page="header_jsp.jsp" />
        <title>Confirm Page</title>
    </head>
    <body>
        <h1 style="color: red; font: 500">${message2}</h1>
        <form action="confirm" method="POST">

           <input type="password" autocomplete="off" name ="passwordMail" placeholder="RegisterPassword" ><br><br>
           <input type="password" autocomplete="off" name ="password1" placeholder="NewPassword" ><br><br>
           <input type="password" autocomplete="off" name ="password2" placeholder="ConfirmPassword" ><br><br>
           <input type="submit" name="confirm" value="Confirm"  style="background-color: greenyellow; width: 175px; height : 25px "><br>
        </form>
    </body>
</html>
