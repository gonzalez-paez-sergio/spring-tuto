<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<title>Custom login Page</title>

<style type="text/css">
.failed {
	color: red
}
</style>
</head>

<body>
	<h3>my custom login pageeeeee</h3>
	<form:form
		action="${ pageContext.request.contextPath}/authenticateTheUser">

		<p>
			${ param.error }

			<c:if test="${param.error != null}">
				<i class="failed">sorry, invalid username/pasword</i>
			</c:if>
		</p>

		<p>
			User name: <input type="text" name="username" />
		</p>

		<p>
			Password: <input type="password" name="password" />
		</p>

		<p>
			<input type="submit" value="login">
		</p>
	</form:form>
</body>
</html>