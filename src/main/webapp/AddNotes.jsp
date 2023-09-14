<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add page</title>
<%@include file="components/all_css.jsp" %>
<link href="components/onlyCss.css" rel="stylesheet">
</head>
<body>
<%@include file="components/navbar.jsp" %>

		<!-- Add Form code -->
		
<div class="container">
	<form action="AddNotesServlet" method="post">
		<div class="mb-3">
			<label for="title" class="form-label">Enter Title</label> 
			<input required="required" type="text" class="form-control"
				id="title" aria-describedby="emailHelp" name="title">
		
		</div>
		<div class="mb-3">
			<label for="content" class="form-label">Enter Content</label>
			
			<textarea 
			required="required"
			id="content"
			placeholder="enter the content"
			class="form-control"
			style="height: 300px"
			name="content"
			
			></textarea>
		</div>
		<div class="container text-center">
		<button type="submit" class="btn btn-primary">add</button>
		</div>
	</form>
	</div>

</body>
</html>