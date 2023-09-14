<%@page import="todo.Entities"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="todo.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Notes</title>
<%@include file="components/all_css.jsp" %>
<link href="components/onlyCss.css" rel="stylesheet">
</head>
<body>
<%@include file="components/navbar.jsp" %>

	<h3 class="text-center">All Notes</h3>
	
	<div class="row">
	<div class="col-md-6 offset-md-3">
	
	
	
	<% Session s = FactoryProvider.getFactory().openSession();
		Query q =  s.createQuery("from Entities");
		
		List<Entities> list = q.list();
		for(Entities e : list)
		{
		%>
		<div class="card mt-3">
	<div class="card-body">
	<%-- <%= e.getId() %>		
	<%= e.getSavedDate() %> --%>
	<h5 class="card-title"><%= e.getTital() %></h5>
	<p class="card-text"> <%= e.getContent()%></p>
	<b><%=e.getSavedDate() %></b>
	<div class="container text-center">
	<a  href="DeleteServlet?id=<%= e.getId() %>" class="btn btn-outline-danger">Delete</a>
	<a href="Update.jsp?id=<%=e.getId() %>" class="btn btn-outline-primary">Update</a>
	</div>
		</div>
	</div>
			
		<% 
		}
		s.close();
		%>
	
	
	
	</div>
	</div>
	
	
</body>
</html>