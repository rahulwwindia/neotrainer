<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div align="center">
	<h3>Registration Details</h3>
	<form:form action="addCand.htm" method="post" commandName="newCand">
		<table cellspacing="5">
			<tr>
				<td>User Name:</td>
				<td><form:input type="text" path="candName" /></td>
				<td><form:errors path="candName" /></td>
			</tr>
			<tr>
				<td>Email Id:</td>
				<td><form:input type="text" path="email" /></td>
				<td><form:errors path="email" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input type="password" path="password" /></td>
				<td><form:errors path="password" /></td>
			</tr>
			<%-- <tr>
				<td>Confirm Password:</td>
				<td><form:input type="password" path="p1" /></td>
				<td><form:errors path="p1"/></td>
			</tr> --%>
			<tr>
				<td>Group Name:</td>
				<td><form:select path="CandGroup" style="background: skyblue;">
						<form:option value="Java"></form:option>
						<form:option value="DotNet"></form:option>
						<form:option value="PHP"></form:option>
					</form:select></td>
				<td><form:errors path="CandGroup" /></td>
			</tr>
			<tr>
				<td>Experience:</td>
				<td><form:select path="experience" style="background: skyblue;">
						<form:option value="0"></form:option>
						<form:option value="+1"></form:option>
						<form:option value="+2"></form:option>
						<form:option value="+3"></form:option>
						<form:option value="+4"></form:option>
						<form:option value="+5"></form:option>
					</form:select></td>
				<td>yrs<form:errors path="CandGroup" /></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><input type="submit"
					value="Submit" class="button"><input type="reset"
					value="Reset" class="button"><input type="button"
					onclick="history.back()" class="button" value="Cancel" /></td>
			</tr>
		</table>
	</form:form>
</div>