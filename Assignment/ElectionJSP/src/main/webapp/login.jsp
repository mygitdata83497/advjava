<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean" scope="session"/>
	<jsp:setProperty name="lb" property="*" />
	<%--<%lb.authenticate() ;--%>
	${lb.authenticate() }
	<%-- 
	<%if(lb.getUser() !=null){ %>
		<%if(lb.getUser().getRole().equals("voter")) { %>
			<%--<%response.sendRedirect("candlist.jsp"); --%>
			<c:redirect url="candlist.jsp"/>
		
		<%-- 	
			<%} else { %>
				<%-- <jsp:forward page="result.jsp"/> --%>
				<c:redirect url="candlist.jsp"/>
			
		<%-- 
			<% } %>
		<%} else { %>
			<%-- 
				<h3>Online Voting</h3>
				Hello,<jsp:getProperty property="email" name="lb"/><br/>
			--%>
			<%-- 
				<h3>${initParam.appTitle }<h3/>
				Hello,${lb.email }<br/>
				Invalid email or Password.<br/><br/>
				<a href="index.jsp">Login again</a>
		<%} %>
		--%>
		
	<c:choose>
		<c:when test="${lb.user.role == 'voter'}">
			<c:redirect url="candlist.jsp"/>		
		</c:when>
		<c:when test="${lb.user.role == 'admin'}">
			<c:redirect url="result.jsp"/>		
		</c:when>
		<c:otherwise>
			<h3>${initParam.appTitle}</h3>
			Hello, ${lb.email} <br/>
			Invalid email or password. <br/><br/>
			<a href="index.jsp">Login Again</a>		
		</c:otherwise>
	</c:choose>
		
		
</body>
</html>