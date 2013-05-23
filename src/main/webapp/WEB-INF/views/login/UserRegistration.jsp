<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/validation.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/validation.js"></script>
<script>
	jQuery(function() {

		/*  jQuery("#ValidNumber").validate({
		     expression: "if (!isNaN(VAL) && VAL) return true; else return false;",
		     message: "Should be a number"
		 }); */
		jQuery("#userName").validate({
			expression : "if (VAL) return true; else return false;",
			message : "Please enter your name"
		});

		jQuery("#email")
				.validate(
						{
							expression : "if (VAL.match(/^[^\\W][a-zA-Z0-9\\_\\-\\.]+([a-zA-Z0-9\\_\\-\\.]+)*\\@[a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)*\\.[a-zA-Z]{2,4}$/)) return true; else return false;",
							message : "Should be a valid Email id"
						});
		jQuery("#password").validate({
			expression : "if (VAL) return true; else return false;",
			message : "Password is required"
		});
		jQuery("#rePassword")
				.validate(
						{
							expression : "if (VAL && VAL==$('#password').val()) return true; else return false;",
							message : "Please Re-Enter Password"
						});
		jQuery("#phone")
				.validate(
						{
							expression : "if (VAL.match(/^[7-9][0-9]{9}$/)) return true; else return false;",
							message : "Should be a valid Mobile Number"
						});
		jQuery("#address").validate({
			expression : "if (VAL) return true; else return false;",
			message : "Password is required"
		});

		jQuery("#groupUser").validate({
			expression : "if (VAL != '-1') return true; else return false;",
			message : "Please make a selection"
		});

	});
</script>
<div id="newUser" align="center">
	<br>
	<h3>New Employee Details</h3>
	<form:form action="addUser.htm" method="post" commandName="newUser">
		<table cellspacing="6">
			<tr>
				<td style="color: blue;">${success }</td>
			</tr>
			<tr>
				<td>User Name:</td>
				<td><form:input type="text" path="userName" /></td>
				<td><form:errors path="userName" /></td>
			</tr>
			<tr>
				<td>Email Id:</td>
				<td><form:input type="text" path="email" /></td>
				<td><form:errors path="email" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input type="password" path="password" id='password' /></td>
				<td><form:errors path="password" /></td>
			</tr>
			<tr>
				<td>Retype Password:</td>
				<td><form:input type="password" path="rePassword" /></td>
				<td><form:errors path="rePassword" /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><form:textarea path="address" id="address" /></td>
				<td><form:errors path="address" /></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><form:input type="phone" path="phone" /></td>
				<td><form:errors path="phone" /></td>
			</tr>
			<tr>
				<td>Technology:</td>
				<td><select id="groupUser" name="groupUser">
						<option value="-1">Select Technology</option>
						<c:forEach items="${grouplist}" var="grp">
							<option value="${grp.getGroupName()}">${grp.getGroupName()}</option>
						</c:forEach>
				</select></td>
				<td><form:errors path="groupUser" /></td>
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