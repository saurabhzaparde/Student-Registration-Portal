
<%
	String username = (String) session.getAttribute("check");
	if (username != null) {
%>
<%@page  errorPage="myerror.jsp"%>

<%@page import="com.pojo.Information"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.InsertReadImp"%>
<%@page import="com.pojo.Message"%>
<%@page import="com.pojo.Image"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/pageup.css">
<title>Update Page</title>
</head>

<body>
	<%@include file="messagebox/message.jsp"%>
	<header>
		<h1>Data Update Panal</h1>
		<div class="loghome">
			<a href="admin.jsp"> Admin Home </a>
		</div>
	</header>
	<br>
	<br>
	<br>
	
	<table border="1" cellspacing="1" cellpadding="1" align="center">
	<tr>
	<th colspan="3">
	PAGE IMAGES EDITS
	</th>
	</tr>
	<tr>
	<th>
	<form action="Addimage" method="post" enctype="multipart/form-data">
      <input type="file" name="img" required="required"><br>
	</th>
	<th>Date AutoFilled</th>
	<th>       <input type="hidden" name="parse" value="add"/>
	    <button>add</button> </form>
	</th>
	</tr>
	
	<%
	ArrayList<Image> al3 = new InsertReadImp().readimg();
	for (Image im : al3) {
	%><tr><th>
	<form action="Addimage" method="post" enctype="multipart/form-data">
	<img style="height: 150px; width: 350px;" src="images/improject/<%=im.getFilename()%>" alt="project image">
          <input type="hidden" name="sn" value="<%=im.getIsn()%>">
         <input type="hidden" name="filename" value="<%=im.getFilename()%>"/>
         <input type="hidden" name="parse" value="delete"/>
	</th>
	
	<th><%=im.getIdate()%></th>
	<th><button>Delete</button>
       </form><%}%></th>
       </tr>
       
	</table>
	
	<table border="1" cellspacing="1" cellpadding="1" align="center">
		<tr>
			<th colspan="5">Home Page Message</th>
		</tr>
		<tr>
			<th>Serial No.</th>
			<th>Title</th>
			<th>Date Of Modification</th>
			<th>Paragraph</th>
			<th>Modification</th>
		</tr>
		<tr>
			<form action="Getmsg" method="post">
				<th>Auto Generated</th>
				<th><input type="text" name="title" placeholder="Title"
					required /></th>
				<th>Auto Inserted</th>
				<th><textarea rows="6" cols="50"
						placeholder="Enter Paragraph That You Want To Display On Home Page"
						name="desc" required>
		        </textarea></th>
				<th><button>Add</button>
			</form>
			</th>
		</tr>
		<tr>
			<form action="Updatedata" method="post">
				<%
					ArrayList<Message> al1 = new InsertReadImp().readmsg();
						for (Message m : al1) {
				%>
				<input type="hidden" name="sn" value="<%=m.getMsn()%>" />
				<th><%=m.getMsn()%></th>
				<th><input type="text" name="title" value="<%=m.getTitle()%>"
					required /></th>
				<th><%=m.getMdate()%></th>
				<th><textarea rows="6" cols="50" name="desc"
						placeholder="<%=m.getDecription()%>" required></textarea></th>
				<th><input type="hidden" name="filled" value="msg" />
					<button>Update</button>
			</form>
			<form action="Deletedata" method="post">
				<input type="hidden" name="sn" value="<%=m.getMsn()%>"> <input
					type="hidden" name="space" value="msg" />
				<div class="hr">
					<button>Delete</button>
			</form>
			</th>
		</tr>
		<%}%>
</table>
	
	<table align="center" cellspacing="0" cellpadding="0" border="0">
		<tr>
			<th>
				<%
					ArrayList<Information> al = new InsertReadImp().readinfo();
						for (Information in : al) {
				%>
				<table align="center" cellspacing="5" cellpadding="3" border="0">

					<tr>
						<th colspan="15">
							<h2>Students Details</h2>
						</th>
					</tr>
					<tr>
						<th>Data</th>
						<th>Enteries</th>
					</tr>
					<tr>

						<form action="Updatedata" method="post">
							<input type="hidden" name="roll" value="<%=in.getRoll()%>" />
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
						<th><%=in.getIpassword()%></th>
					</tr>
					<tr>
						<th>Resume</th>
						<th><%=in.getFilename()%></th>
					</tr>
					<tr>
						<th>Modification</th>
						<th><input type="hidden" name="filled" value="info" />
							<button>Update</button>
							</form>
							<form action="Deletedata" method="post">
								<input type="hidden" name="roll" value="<%=in.getRoll()%>" /> <input
									type="hidden" name="filename" value="<%=in.getFilename()%>" />
								<input type="hidden" name="space" value="Ainfo" />
								<div class="hr">
									<button>Delete</button>
							</form></th>
					</tr>
				</table>
			</th>
			<th>
			<%}%>
			</th>
		</tr>
	</table>
	
	<%
		} else {
			response.sendRedirect("adlog.jsp");
		}
	%>
</body>

</html>