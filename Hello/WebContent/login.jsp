<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page  errorPage="myerror.jsp"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/pagelo.css">
    <title>Login</title>
</head>

<body>
     <%@include file="messagebox/message.jsp" %> 
    <div class="loghome">
        <a href="index.jsp">
            Home 
            </a>
    </div>
    <form name="signin" action="Userlog" method="post">
        <div class="inmain">
            <div class="logo">
                <i class="fa fa-user" aria-hidden="true"></i>
            </div>
            <div class="pagelogin">
                <h2 align="center">Login</h2>
            </div>
            <div class="subin1">
                <div id="username_error"></div>
                <input type="number" name="id" placeholder="User Id" min="1000" max="2500" required/>
            </div>
            <div class="passin">
                <div id="password_error"></div>
                <input type="password" name="pass" placeholder="Password" minlength="6" maxlength="12" required />
            </div>
            <div class="login">
                <input type="submit" name="submit" value="Login" />
            </div>
        </div>
    </form>
</body>

</html>