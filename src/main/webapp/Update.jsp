<%@page import="todo.Entities"%>
<%@page import="todo.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update page</title>

<%@include file="components/all_css.jsp" %>
<link href="components/onlyCss.css" rel="stylesheet">
</head>
<body>
<%@include file="components/navbar.jsp" %>

<h3 class="text-center">Update Notes</h3>

<%     
	
	int id = Integer.parseInt(request.getParameter("id"));
	Session s = FactoryProvider.getFactory().openSession();
	s.beginTransaction();
	Entities res = s.get(Entities.class, id);
	System.out.println(res.getContent());

%>

<div class="container">
	<form action="UpdateServlet" method="get">
		<div class="mb-3">
			<label for="title" class="form-label"> Title</label> 
			<input required="required" type="text" class="form-control"
				id="title" aria-describedby="emailHelp" name="title" value="<%= res.getTital()%>">
		</div>
		<input type="hidden" name="id" value="<%=id%>"> 
		<div class="mb-3">
			<label for="content" class="form-label"> Content</label>
			
			<textarea 
			required="required"
			id="content"
			placeholder="enter the content"
			class="form-control"
			style="height: 300px"
			name="content"
			> <%= res.getContent()%></textarea>
		</div>
		<div class="container text-center">
		<button type="submit" class="btn btn-success">Save</button>
		</div>
	</form>
	</div>
	<% s.getTransaction().commit();
	s.close();
	%>

</body>
</html>