<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#fromDate").datepicker();
		$("#toDate").datepicker();
	});
</script>
</head>
<body>

	<form:form action="getResult.htm" commandName="range" method="POST">
		<table cellpadding="6">
			<tbody>
				<tr>
					<td>From Date</td>
					<td><input id="fromDate" name="fromDate" class="required"
						style="width: 105px;" /></td>
					<td>To Date</td>
					<td><input id="toDate" name="toDate" class="required"
						style="width: 105px;" /></td>
					<td>
					<td><select type="text" name='group' id='group'>
							<ption value="-1">--Select Group---</ption>
							<option value="Java">Java</option>
							<option value="DotNet">DotNet</option>
							<option value="PHP">PHP</option>

					</select></td>

					<td>
						<div class="wrapper">
							<input value="Go" id="result" name="getResult" type="submit"
								class="button"></input>
						</div>
					</td>
				</tr>
			</tbody>
		</table>

	</form:form>
	<div class="inner_txt" style="padding: 15px 0 15px 0;">
		<table width="100%" cellspacing="1" cellpadding="2" bgcolor="#999999"
			class="bdytxt">
			<tbody>
				<tr>

					<td align="center">Name</td>
					<td align="center">Email</td>
					<td align="center">Exp</td>
					<td align="center">CTC</td>
					<td align="center">Contact No</td>
					<td align="center">Score</td>
					<td align="center">Applied for</td>
					<td align="center">Date</td>
					<td align="center">Resume</td>
				</tr>
				<c:forEach var="result" items="${result}">
					<tr>

						<td align="center" width="22%" bgcolor="#EFF3EC">${result.candidate.candName}</td>
						<td align="center" width="22%" bgcolor="#EFF3EC">${result.candidate.email}</td>
						<td align="center" width="22%" bgcolor="#EFF3EC">${result.candidate.experience}</td>
						<td align="center" width="22%" bgcolor="#EFF3EC">${result.candidate.ctc}
							LPA</td>
						<td align="center" width="22%" bgcolor="#EFF3EC">${result.candidate.phone}</td>
						<td align="center" width="22%" bgcolor="#EFF3EC">${result.score}</td>
						<td align="center" width="22%" bgcolor="#EFF3EC">${result.groupId.groupName}</td>
						<td align="center" width="22%" bgcolor="#EFF3EC"><fmt:formatDate
								pattern="yyyy-MM-dd" value="${result.examDate}" /></td>
						<td align="center" width="22%" bgcolor="#EFF3EC"><c:choose>
								<c:when test="${empty result.candidate.resume}">
       N/A
    </c:when>
								<c:otherwise>
									<a
										href="<%=request.getContextPath()%>/resources/resume/${result.candidate.resume}">
										<img src="resources/images/resume.jpeg" alt="" height="36"
										width="36">
									</a>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
	</div>



</body>
</html>

