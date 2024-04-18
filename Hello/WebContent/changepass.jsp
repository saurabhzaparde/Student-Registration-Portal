<%
	String username = (String) session.getAttribute("check");
	if (username != null) {
%>
<%@page  errorPage="myerror.jsp"%>

    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="css/pagecp.css">
            <title>Change Credentials</title>
        </head>

        <body>
            <%@include file="messagebox/message.jsp" %>
                <%!String username; %>
                    <% username =(String)session.getAttribute("check");  %>
                        <div class="loghome">
                            <a href="admin.jsp">
        Admin Home 
        </a>
                        </div>
                        <form name="signin" action="Adminlog" method="post">
                            <div class="inmain">
                                <div class="logo">
                                    <i class="fa fa-user" aria-hidden="true"></i>
                                </div>
                                <div class="pagelogin">
                                    <h2 align="center"><b>LOGIN</b></h2>
                                </div>
                                <div class="subin">
                                    <input type="hidden" value="<%=username%>" name="username"><br>
                                    <input type="password" name="oldpass" placeholder="Old Password" minlength="6" maxlength="12" required/>
                                </div>
                                <div class="subin1">
                                    <input type="password" name="newpass" placeholder="New Password" minlength="6" maxlength="12" required />
                                </div>
                                <div class="passin">
                                    <input type="password" name="confirmpass" placeholder="Confirm Password" minlength="6" maxlength="12" required />
                                </div>
                                <div class="login">
                                    <input type="hidden" name="check" value="changepass"><br>
                                    <input type="submit" name="submit" value="Login" />
                                </div>
                            </div>
                        </form>
                        <%} 
	else {
			response.sendRedirect("adlog.jsp");
		}
	%>
        </body>

        </html>