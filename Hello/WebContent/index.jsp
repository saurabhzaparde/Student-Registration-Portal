<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.dao.InsertReadImp"%>
<%@page import="com.pojo.Message"%>
<%@page import="java.util.ArrayList"%>
<%@page  errorPage="myerror.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title> 1st Page </title>
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/pagei.css">
</head>

<body>
    <header>
        <div class="head">
            <h1>Registration Web Application</h1>
        </div>
        <div class="hmain">
            <ul>
                <li class="active"><a href="index.jsp">HOME</a></li>
                <li><a href="register.jsp">REGISTER</a></li>
                <li><a href="admin.jsp">ADMIN</a></li>
                 <li><a href="useracc.jsp">USER</a></li>
            </ul>
        </div>
    </header>
    
    <div class="title">
    <%ArrayList<Message> al1 = new InsertReadImp().readmsg();
			for (Message m : al1) {%>
        <p>
            <b><%=m.getTitle()%>,</b><br><%=m.getDecription()%><br>
            <hr><br>
            <marquee>
                <%=m.getTitle()%>,
                <br><%=m.getDecription()%>
            </marquee>
        </p>
        <%
			}
		%>
    </div>
    <footer>
        <div class="button">
            <a href="#" class="btn">WIKIPEDIA</a>
            <a href="#" class="btn">ABOUT</a>
        </div>

    </footer>

</body>

</html>