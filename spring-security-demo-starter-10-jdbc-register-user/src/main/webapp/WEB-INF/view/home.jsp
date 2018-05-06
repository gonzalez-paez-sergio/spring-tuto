<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>


<html>
<head>
<title>Luv2 code company home page</title>
</head>


<body>

	<h2>Company page body</h2>
	<h2>Hello World!</h2>

	Welcome the the luv2code company home page

	<p>
		User name:
		<security:authentication property="principal.username" />
	</p>
	<p>
		Role:
		<security:authentication property="principal.authorities" />
	</p>


	<hr>
	<p>
		<security:authorize access="hasRole('MANAGER')">
			<a href="${pageContext.request.contextPath}/leaders">Leadership
				meeting</a>
		</security:authorize>
	</p>

	<p>
		<security:authorize access="hasRole('ADMIN')">
			<a href="${pageContext.request.contextPath}/systems">IT Systems
				meeting</a>
		</security:authorize>
	</p>
	<hr>

	<form:form action="${ pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="logout">

	</form:form>
</body>
</html>
