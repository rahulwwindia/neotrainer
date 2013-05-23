<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<br>
<h3 align="center" style="margin-top: 10px">Candidate's
	Registration Form</h3>
<br>
<div align="center">Please Fill this form to apply for career in
	Neosoft Technologies.</div>
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/validation.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/validation.js"></script>
<style type="text/css">
#yearDiv span {
	margin-left: 20px;
}
</style>
<div align="center">
	<script>
		jQuery(function() {

			$("#back-top").hide();
			/*  jQuery("#ValidNumber").validate({
			     expression: "if (!isNaN(VAL) && VAL) return true; else return false;",
			     message: "Should be a number"
			 }); */
			jQuery("#candName").validate({
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
			jQuery("#rePassword").validate({
				/* var rp=$("#password").val();
				alert("sdf"+rp); */
				expression : "if (VAL) return true; else return false;",
				message : "Please Re-Enter Password"
			});
			jQuery("#phone")
					.validate(
							{
								expression : "if (VAL.match(/^[7-9][0-9]{9}$/)) return true; else return false;",
								message : "Should be a valid Mobile Number"
							});
			jQuery("#location").validate({
				expression : "if (VAL) return true; else return false;",
				message : "Please provide location"
			});
			jQuery("#ctc")
					.validate(
							{
								expression : "if (!isNaN(VAL) && VAL) return true; else return false;",
								message : "Should be a number"
							});
			jQuery("#exctc")
					.validate(
							{
								expression : "if (!isNaN(VAL) && VAL) return true; else return false;",
								message : "Should be a number"
							});
			jQuery("#experience")
					.validate(
							{
								expression : "if (VAL != '-1') return true; else return false;",
								message : "Please make a selection"
							});
			jQuery("#groupName")
					.validate(
							{
								expression : "if (VAL != '-1') return true; else return false;",
								message : "Please make a selection"
							});

			/* jQuery("#questSet")
			.validate(
					{
						expression : "if (VAL != '-1') return true; else return false;",
						message : "Please make a selection"
					}); */

			jQuery("#experienceYY")
					.validate(
							{
								expression : "if (VAL != '-1') return true; else return false;",
								message : "Please make a selection"
							});
			jQuery("#experienceMM")
					.validate(
							{
								expression : "if (VAL != '-1') return true; else return false;",
								message : "Please make a selection"
							});

		});
	</script>

	<form:form action="exam/onlineTest.htm" method="POST"
		commandName="newCand" enctype="multipart/form-data">
		<table cellpadding="2" cellspacing="2"
			style="width: 100%; margin-left: 20px">
			<tbody>

				<tr>
					<td width="33%" align="left"><lable> Name</lable></td>
					<td width="66%"><form:input type="text" path='candName'
							id='candName' value='' style="width: 172px;" /></td>
					<td></td>

				</tr>

				<tr>
					<td><lable> Email Address</lable></td>
					<td><form:input type="text" path='email' id='email' value=''
							style="width: 172px;" /></td>
					<td></td>

				</tr>
				<tr>
					<td><lable> Password</lable></td>
					<td><form:input type="password" path='password' id='password'
							value='' style="width: 172px;" /></td>
					<td></td>

				</tr>
				<tr>
					<td><lable>Retype Password</lable></td>
					<td><form:input type="password" path='rePassword'
							id='rePassword' value='' style="width: 172px;" /></td>
					<td></td>

				</tr>
				<tr>
					<td><lable> Phone</lable></td>
					<td><form:input type="text" path='phone' id='phone'
							style="width: 172px;" /></td>
					<td></td>

				</tr>
				<tr>
					<td><lable> Current Location</lable></td>
					<td><form:input type="text" path='location' id='location'
							value='' style="width: 172px;" /></td>
					<td></td>

				</tr>

				<tr>
					<td><lable> Current CTC (In LPA)</lable></td>
					<td><form:input type="text" path='ctc' id='ctc' value=''
							style="width: 172px;" /></td>
					<td></td>

				</tr>
				<tr>
					<td><lable> Expected CTC (In LPA)</lable></td>
					<td><form:input type="text" path='exctc' id='exctc' value=''
							style="width: 172px;" /></td>
					<td></td>

				</tr>
				<tr>
					<td><lable> Technology </lable></td>
					<td><form:select type="text" path='groupName' id='groupName'
							value='' style="width: 172px;">
							<form:option value="-1">Select Technology</form:option>
							<c:forEach items="${grouplist}" var="grp">
								<form:option value="${grp.groupName}">${grp.groupName}</form:option>
							</c:forEach>
						</form:select></td>
					<td></td>
				</tr>
				<%-- 	<tr>
					<td><lable> Technology </lable></td>
					<td><select type="text" id='questSet' name="questSet"
							value='' style="width: 172px;"> 
							<option value="-1">Select Technology</option>
							<c:forEach items="${questSetMap}" var="qtSetMap">
							<option value="${qtSetMap.key}">${qtSetMap.value.getSetName()}</option>
							</c:forEach>
						</select></td>
					<td></td>
				</tr>  --%>
				<tr>
					<td><lable> Experience </lable></td>
					<td>
						<div id="yearDiv">
							<form:select type="text" path='experienceYY' id='experienceYY'
								style="width:70px">
								<form:option value="-1">Years</form:option>
								<form:option value="0">0</form:option>
								<form:option value="1">1</form:option>
								<form:option value="2">2</form:option>
								<form:option value="3">3</form:option>
								<form:option value="4">4</form:option>
								<form:option value="5">5</form:option>
							</form:select>
						</div>
						<div>
							<form:select type="text" path='experienceMM' id='experienceMM'
								style="width: 85px; margin-top: 5px;">
								<form:option value="-1">Months</form:option>
								<form:option value="0">0</form:option>
								<form:option value="1">1</form:option>
								<form:option value="2">2</form:option>
								<form:option value="3">3</form:option>
								<form:option value="4">4</form:option>
								<form:option value="5">5</form:option>
								<form:option value="6">6</form:option>
								<form:option value="7">7</form:option>
								<form:option value="8">8</form:option>
								<form:option value="9">9</form:option>
								<form:option value="10">10</form:option>
								<form:option value="11">11</form:option>

							</form:select>
						</div>
					</td>
				</tr>

				<tr>
					<td><lable> Upload Resume</lable></td>
					<td id="upResume"><form:input type="file" path='fileData'
							id='fileData' value='' style="width: 172px;" /></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" class="button" value="Start Test"
						style="width: 90px;""cursor:hand;"></td>
				</tr>
				</form:form>

			</tbody>
		</table>
</div>