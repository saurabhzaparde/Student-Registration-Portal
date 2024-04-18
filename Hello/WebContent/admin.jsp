
<%
	String username = (String) session.getAttribute("check");
	if (username != null) {
%>
<%@page  errorPage="myerror.jsp"%>

<%@page import="com.pojo.Information"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.InsertReadImp"%>
<%@page import="com.pojo.Message"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/pagead.css">
<title>Admin Page</title>
</head>

<body>
 <%@include file="messagebox/message.jsp" %> 
	<header>
		<h1>Admin Panal</h1>
		<ul>
			<li>
				<form action="dupdate.jsp" method="post">
					<button>HomeEdits</button>
				</form>
			</li>

			<li>
				<form action="Adminlog" method="post">
					<input type="hidden" name="check" value="logout">
					<button>Logout</button>
				</form>
			</li>
			<li>
				<form action="changepass.jsp" method="post">
					<button>EditPass</button>
				</form>
			</li>
		</ul>
	</header>
	<table align="center" cellspacing="3px" cellpadding="10" border="2"
		class="dtmsg">
		<tr>
			<th colspan="15">
				<h2>Students Details</h2>
			</th>
		</tr>
		<tr>
			<th>Id</th>
			<th>Roll_No</th>
			<th>First_Name</th>
			<th>Last_name</th>
			<th>Gender</th>
			<th>Email</th>
			<th>Edate</th>
			<th>Department</th>
			<th>City</th>
			<th>Mob_No.</th>
			<th>Fees</th>
			<th>Resume Name</th>
			<th colspan="5">Modification</th>
		</tr>
		<%
		
        ArrayList<Information> al = new InsertReadImp().readinfo();
            for (Information in : al) {%> 
		<tr>
			<th><%=in.getId()%></th>
			<th><%=in.getRoll()%></th>
			<th><%=in.getFname()%></th>
			<th><%=in.getLname()%></th>
			<th><%=in.getGender()%></th>
			<th><%=in.getEmail()%></th>
			<th><%=in.getEdate()%></th>
			<th><%=in.getDpart()%></th>
			<th><%=in.getCity()%></th>
			<th><%=in.getMob()%></th>
			<th><%=in.getFees()%></th>
			<th><%=in.getFilename()%>
			<form action="Getdata" method="post">
			  <input type="hidden" name="resu" value="<%=in.getFilename()%>">
                           <input type="hidden" name="hammer" value="download">
                            <button>Download Resume</button>
                          </form>
			</th>
            <th><form action="dupdate.jsp" method="post">
					<div class="hr">
						<button>Edit</button>
				</form>
				</div>
			</th>
		</tr>
		 <%}%> 
	</table>
	<br>
	<br>
	<br>
	<br>
	<table border="1" cellspacing="2" cellpadding="3" align="center">
		<tr>
			<th colspan="5">Home Page Message</th>
		</tr>
		<tr>
			<th>Serial no.</th>
			<th>Title</th>
			<th>Modification Date</th>
			<th>Paragraph</th>
			<th>Modification</th>
		</tr>
		<tr>
			<form action="dupdate.jsp" method="post">
				 <%
                ArrayList<Message> al1 = new InsertReadImp().readmsg();
                    for (Message m : al1) {%> 
				<input type="hidden" name="sn" value="<%=m.getMsn()%>" />
				<th><%=m.getMsn()%></th>
				<th><%=m.getTitle()%></th>
				<th><%=m.getMdate()%></th>
				<th><%=m.getDecription()%></th>
				<th><button>Edit</button></th>
			</form>
		</tr>
		<%}%> 
	</table>
	<%
		} else {
			response.sendRedirect("adlog.jsp");
		}
	%>
</body>

</html>