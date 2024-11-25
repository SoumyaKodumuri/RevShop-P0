<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<%int a=10;
out.println(a);

%>
<h1>implicit objects</h1>
<h3>---request---</h3>
<%
String username= request.getParameter("user");
//if(username == null){
	username="soumyaK";
	out.println(username ="Soumya");
//}
%>
<p> <%=username %></p>
<h3>---response---</h3>
<%
response.setHeader("Custom-Header", "This a custom header");
%>
<h3>---session---</h3>  <!--used to set attribute  --> 
<%
session.setAttribute("Vyshu", username);
%>

<h3>---pagecontent---</h3>
<%= pageContext.getRequest().getAttribute("userame") %>

<%= application.getAttribute("name") %>

<c:out  values= "${username}"/>
<p>User-Name: ${username}</p>


<%
java.util.Date date=new java.util.Date();
out.println(date.toString());
%>

</body>
</html>