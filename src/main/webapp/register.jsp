<%-- 
    Document   : register
    Created on : Apr 19, 2016, 4:57:31 PM
    Author     : Gabi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/login_css.css">
        <jsp:include page="header_jsp.jsp" />
        <title>Register page</title>
    </head>
    <body>
        <div id="style">
            <div align="center">
     
        
        <form name="registerUser" action="register_user_servlet" method="POST">
            <table>
                <tr> 
                    <td>Username:</td>
                    <td><input type="text" name = "user_id"></td>
                </tr>
                <tr> 
                    <td>Password:</td>
                    <td><input type="password" name ="password"></td>
                </tr> 
                <tr> 
                    <td>Name</td>
                    <td><input type="text" name = "name"></td>
                </tr>
                <tr> 
                    <td>Surname:</td>
                    <td><input type="text" name = "surname"></td>
                </tr>
                <tr> 
                    <td>Email:</td>
                    <td><input type="email" name = "email"></td>
                </tr>
                <tr> 
                    <td>Department:</td>
                    <td><input type="text" name = "department"></td>
                </tr>               
                         
                

            </table><br>
            
                <input type="submit" name="register" value="Register!" style="background-color: greenyellow; width: 175px; height : 25px ">  
           
        </form>
            </div>
        </div>
    </body>
</html>
