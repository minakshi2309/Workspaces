<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<!-- <html>
<head>
<title>First Web Application</title>
</head>
<body> -->
<%-- My First JSP !! Welcome ${name}! --%>
<div class="container">
	<font color="red">${errorMessage}</font>
	<form method="post">
		Name: <input type="text" name="name" /> Password: <input
			type="password" name="password" /> <input type="submit" />
	</form>
</div>
<!-- </body>
</html> -->
<%@ include file="common/footer.jspf"%>