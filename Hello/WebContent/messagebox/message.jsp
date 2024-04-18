<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.cl{
color: rgb(255, 255, 255);
font-family: sans-serif;
  background-color: rgba(0, 0, 0, 0.75);
}
</style>
</head>
<body>

  <% 
  
  String msg=(String)session.getAttribute("msg");
  if(msg!=null)
  {
  %>
  <h2 class="cl"><%=msg%></h2>
 
 <%}
  
  session.removeAttribute("msg");
  %>
   
 
</body>
</html>