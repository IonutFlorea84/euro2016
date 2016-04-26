

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/login_css.css">
        <jsp:include page="header_jsp.jsp" />
        <title>Login page</title>
        
    </head>
    <body>
        <div id="style">
            <div align="center">
                
                <form name="login" action="login" method="POST">
                    <label style="color: red; font: bold"> ${message}  </label><br>
                    <input type="text" autocompele="off" name = "user_id" placeholder="Username"><br>
                    <input type="password" autocomplete="off" name ="password" placeholder="Password" ><br><br>
                    <input type="submit" name="action" value="Login"  style="background-color: greenyellow; width: 175px; height : 25px "><br>
                    <label>If you don't have account:</label><br>
                    <input type="submit" name="action" value="Register" style="background-color: blue; width: 175px; height : 25px ">
                </form> 

            </div>
        </div>
    </body>
</html>
