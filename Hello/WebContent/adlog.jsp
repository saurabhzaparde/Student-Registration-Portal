<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page  errorPage="myerror.jsp"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/pageal.css">
    <title>Admin Login</title>
</head>

<body>
  <%@include file="messagebox/message.jsp" %> 
    <div class="loghome">
        <a href="index.jsp">
        Home 
        </a>
    </div>
    <form action="Adminlog" method="post">
        <div class="inmain">
            <div class="logo">
                <i class="fa fa-user" aria-hidden="true"></i>
            </div>
            <div class="pagelogin">
                <h2 align="center">Admin Login</h2>
            </div>
            <div class="subin1">
            
                <input type="text" name="username" placeholder="Username" minlength="6" required/>
            </div>
            <div class="passin">
    
                <input type="password" name="password" placeholder="Password" minlength="6" maxlength="12" required />
            </div>
            <div class="login">
                <input type="submit" name="submit" value="Login" />
            </div>
        </div>
    </form>
</body>

</html>