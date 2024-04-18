<%
   String us = (String)session.getAttribute("check1");
	if (us != null) {
%>
<%@page  errorPage="myerror.jsp"%>

<%@page import="com.pojo.Information"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.InsertReadImp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/pageus.css">
<title>User Page</title>
</head>
<body>
 <%@include file="messagebox/message.jsp" %>
 <header>
		<h1>USER INFO PANAL</h1>
		<ul>
			<li>
				<form action="Userlog" method="post">
					<input type="hidden" name="check1" value="logout">
					<button>Logout</button>
				</form>
			</li>
		</ul>
	</header> <br><br><br><br><br>
		<%int count=0;
	   ArrayList<Information> al = new InsertReadImp().readinfo();
		for (Information in : al) {%>
		
		<% 
		int userid = Integer.parseInt(us);
		if(userid==in.getId()){ 
			count++;%>
			
	<table align="center" cellspacing="3" cellpadding="10" border="2">
					<tr>
						<th colspan="15">
							<h2>Students Details</h2>
						</th>
					</tr>
					<tr>
						<th>Data Entry Name</th>
						<th>Enteries</th>
					</tr>
					<tr>

						<form action="Updateown" method="post" >
							<input type="hidden" name="roll" value="<%=in.getRoll()%>" />
							<input type="hidden" name="old" value="<%=in.getFilename()%>" />
							<th>Id</th>
							<th><input type="number" name="id" value="<%=in.getId()%>"
								required /></th>
					</tr>
					<tr>
						<th>Roll_No</th>
						<th><%=in.getRoll()%></th>
					</tr>
					<tr>
						<th>First_Name</th>
						<th><input type="text" name="fname"
							value="<%=in.getFname()%>" required /></th>
					</tr>
					<tr>
						<th>Last_name</th>
						<th><input type="text" name="lname"
							value="<%=in.getLname()%>" required /></th>
					</tr>
					<tr>
						<th>Gender</th>
						<th><input type="text" name="gender"
							value="<%=in.getGender()%>" required /></th>
					</tr>
					<tr>
						<th>Email</th>
						<th><input type="text" name="email"
							value="<%=in.getEmail()%>" required /></th>
					</tr>
					<tr>
						<th>Edate</th>
						<th><%=in.getEdate()%></th>
					</tr>
					<tr>
						<th>Department</th>
						<th><input type="text" name="dept" value="<%=in.getDpart()%>"
							required /></th>
					</tr>
					<tr>
						<th>City</th>
						<th><input type="text" name="city" value="<%=in.getCity()%>"
							required /></th>
					</tr>
					<tr>
						<th>Mob_No.</th>
						<th><input type="tel" name="mob" value="<%=in.getMob()%>"
							size="10" required /></th>
					</tr>
					<tr>
						<th>Fees</th>
						<th><input type="number" name="fees"
							value="<%=in.getFees()%>" min="10000" max="100000" required /></th>
					</tr>
					<tr>
						<th>Password</th>
						<th><input type="password" name="password" value="<%=in.getIpassword()%>" required/>
						 <input type="hidden" name="space" value="Uinfo" />
						<button>Update</button></form></th>
					</tr>
					
					<tr>
						<th>Resume</th>
						<th><%=in.getFilename()%>
						 <div class="upr">
						 <form action="Updateown" method="post" enctype="multipart/form-data">
                            <input type="file" name="resu" required/>
                             <input type="hidden" name="old" value="<%=in.getFilename()%>" />
                             	<input type="hidden" name="roll" value="<%=in.getRoll()%>" />
                            <input type="hidden" name="space" value="Uinfoor" />
                            <button>Update Resume</button></form>
                        </div>
						</th>
					</tr>
					<tr>
						<th>Modification</th>
						
						<th>
							
							<form action="Deletedata" method="post">
								<input type="hidden" name="roll" value="<%=in.getRoll()%>" /> <input
									type="hidden" name="filename" value="<%=in.getFilename()%>" />
								<input type="hidden" name="space" value="Uinfo" />
								<div class="hr">
								<button>Delete</button>
						</form></th>
					</tr>				
			</table>
		 <%}
          }%> 
</body>
<%} else {
			response.sendRedirect("login.jsp");
		}
	%>
</html>