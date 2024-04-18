<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.pojo.Image"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="com.dao.InsertReadImp"%>
<%@page  errorPage="myerror.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/pager.css">
</head>

<body>
<%@include file="messagebox/message.jsp"%>
    <div class="hmain">
        <ul>
            <li><a href="index.jsp">HOME</a></li>
            <li><a href="useracc.jsp">USER</a></li>
        </ul>
    </div>
    <div class="upmain">
        <div class="logo">
            <i class="fa fa-user" aria-hidden="true"></i>
        </div>
        <div class="pagelog">
            <h2 align="center"><b>Registration</b></h2>
        </div><br><br>
        <table align="center" cellspacing="10" border="0" cellpadding="3">
          
                <tr>
                    <th colspan="5" align="center">
                        <h3>Student Details</h3>
                    </th>

                    <th rowspan="8">
   
                        <marquee direction="up" scrollamount="10">
                        <%ArrayList<Image> al3 = new InsertReadImp().readimg();
                          for (Image im : al3) {%>
                            <img style="height: 200px; width: 300px;" src="<%=im.getFilename()%>" alt="project image"/><br><br>
                                 <%}%>
                        </marquee>                       
                    </th>
                </tr>
                <tr>
                    <th><label>User Id.:</label></th>
                    <th align="center">
                        <div class="sub"> <form action="Getdata" method="post" enctype="multipart/form-data">
                            <input type="text" name="id" placeholder="User Id" min="1000" max="2000" required/>
                        </div>
                    </th>
                    <th><label>Email.:</label></th>
                    <th>
                        <div class="sub"><input type="text" name="email" placeholder="Email Id" maxlength="30" required/>
                        </div>
                    </th>
                </tr>
                <tr>
                    <th><label>First Name.:</label></th>
                    <th>
                        <div class="sub"><input type="text" name="fname" placeholder="First Name" maxlength="12" required/>
                        </div>
                    </th>
                    <th><label>Last Name.:</label></th>
                    <th>
                        <div class="sub"><input type="text" name="lname" placeholder="Last Name" maxlength="12" required/>
                        </div>
                    </th>
                </tr>
                <tr>
                    <th><label>Department.:</label></th>
                    <th>
                        <div class="sub"><input type="text" name="dept" placeholder="Department Name" maxlength="15" required/>
                        </div>
                    </th>
                    <th><label>City.:</label></th>
                    <th>
                        <div class="sub"><input type="text" name="city" placeholder="City Name" maxlength="15"required/>
                        </div>
                    </th>
                </tr>
                <tr>
                    <th><label>Mob.No.:</label></th>
                    <th>
                        <div class="sub"><input type="text" name="mob" placeholder="Mobile Number" required/>
                        </div>
                    </th>
                    <th><label>Fees</label></th>
                    <th>
                        <div class="sub"><input type="text" name="fees" placeholder="Fees" min="10000" max="100000" required/>
                        </div>
                    </th>
                </tr>
                <tr>
                    <th><label>Password.:</label></th>
                    <th>
                        <div class="sub"><input type="text" name="password" placeholder="Password" minlength="6" maxlength="12" required/>
                        </div>
                    </th>
                    <th><label>Confirm Password.:</label></th>
                    <th>
                        <div class="sub"><input type="password" name="cpassword" placeholder="Confirm Password" minlength="6" maxlength="12" required/>
                        </div>
                    </th>
                </tr>
                <tr>
                    <th align="center"><label>Gender</label></th>
                    <th align="center">
                        <div class="but">
                            <input type="radio" name="gender" placeholder="First name" value="male" required/><label>Male</label>
                            <input type="radio" name="gender" placeholder="First name" value="female" required/><label>Female</label>
                        </div>
                    </th>
                    <th align="center"><label>Upload Resume.:</label></th>
                    <th align="center">
                        <div class="upr">
                            <input type="file" name="resu" required/>
                        </div>
                    </th>
                </tr>
                <tr>
                    <th colspan="5" align="center">
                        <div class="submit">
                            <input type="submit" name="submit" value="Submit" /> </form>
                        </div>
                    </th>
                </tr>

        </table>
       
    </div>
</body>


</html>