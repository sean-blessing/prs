<jsp:include page="/includes/header.jsp" />
	<h1>User <b>${user.userName}</b> registered successfully!</h1>
	<br>
	<table>
		<tr><th>UserName:</th><td>${user.userName}</td></tr>
		<tr><th>PWD:</th><td>${user.password}</td></tr>
		<tr><th>First Name:</th><td>${user.firstName}</td></tr>
		<tr><th>Last Name:</th><td>${user.lastName}</td></tr>
		<tr><th>Phone #:</th><td>${user.phoneNumber}</td></tr>
		<tr><th>Email Address:</th><td>${user.email}</td></tr>
		<tr><th>Manager?:</th><td>${user.manager}</td></tr>
	</table>
</body>
</html>