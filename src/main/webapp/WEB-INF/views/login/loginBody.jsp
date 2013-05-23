<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Login Page</title>
<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>

<body onload='document.getElementById("user").focus();'>
	<h3 style="color: blue">User SignIn</h3>

	<form:form name="loginFrm" action="signInUser.htm" method="POST"
		commandName="loginUser">
		<table>
			<tr>
				<td><form:label path="user" style="color:blue">User:</form:label></td>
				<td><form:input path="user" /></td>
				<td><form:errors path="user" /></td>
			</tr>
			<tr>
				<td><form:label path="emailId" style="color:blue">Email:</form:label></td>
				<td><form:input path="emailId" /></td>
				<td><form:errors path="emailId" /></td>
			</tr>
			<tr>
				<td><form:label path="password" style="color:blue">Password:</form:label></td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="submit" class="button"/></td>
				<td><input name="reset" type="reset" value="Reset" /></td>
			</tr>
			<tr>
				<td><a href="test.htm" style="color: blue">Back</a></td>
			</tr>
		</table>
	</form:form>
</body>
</html>