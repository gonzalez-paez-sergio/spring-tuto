<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<title>Luv2 code company home page</title>
</head>


<body>

	<h2>Company page body</h2>
	<h2>Hello World!</h2>

	Welcome th the luv2code company home page

	<form:form action="${ pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="logout">

	</form:form>
</body>
</html>
