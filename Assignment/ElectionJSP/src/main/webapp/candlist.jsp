<%@page import="com.sunbeam.pojos.Candidate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidates</title>
</head>
<body>
<%-- 	<h3>Online Voting</h3>
	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean" scope="session"/>
	Hello,<jsp:getProperty property="email" name="lb"/><hr/>
--%>
	<h3>${initParam.appTitle}</h3>
	Hello,${lb.user.firstName} ${lb.user.lastName}<hr/>
	
	<jsp:useBean id="clb" class="com.sunbeam.beans.CandidateListBean"/>

	<%--  <% clb.fetchCandidates(); %> --%>
	${ clb.fetchCandidates() }
	
	<form method="post" action="vote.jsp">
<%-- 		<% for(Candidate c : clb.getCandidateList()) { %>
			<input type="radio" name="candidate" value="<%= c.getId() %>"/> <%= c.getName() %> - <%= c.getParty() %> <br/><%} %> --%>
			
			<c:forEach var="c" items="${clb.candidateList}">
			<input type="radio" name="candidate" value="${c.id}"/> ${c.name} - ${c.party} <br/>
			</c:forEach>
			
		<br/><input type="submit" value="Vote"/>
	</form>
</body>
</html>