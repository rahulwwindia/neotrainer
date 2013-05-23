<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<a href="#" onclick="history.back()">back</a>
<div align="center">${questMsg }</div>
<table cellpadding="7" id="questDiv">
	<tr>
		<td><h3>Edit Option</h3></td>
	</tr>
	<tr>
		<td>Question Set:</td>
		<td>${questionSet}</td>
	</tr>
	<tr>
		<td>Set Type:</td>
		<td>${quest.settype}</td>
	</tr>
	<tr>
		<td>Level:</td>
		<td>${quest.level}</td>
	</tr>

	<tr>
		<td><b>Question:</b></td>
		<td><b>${quest.questDesc}</b></td>
		<td>[<a href="deleteQuestions?questId=${quest.questId}">
				delete </a>]
		</td>
	</tr>
	<tr>
		<td>Options:</td>
		<!-- <td></td>
		<td>[<a href="#"> edit </a>]
		</td> -->
	</tr>
	<c:forEach items="${opt}" var="option" varStatus="i">
		<tr>

			<td>${i.count} ${option.optionDesc}</td>
			<td></td>
			<td align="right">[<a
				href="editOpt?optId=${option.optionId}&questId=${quest.questId}">
					edit </a>]
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td>Correct Option:</td>
		<td>${quest.correctOption}</td>
		<td>[<a href="#"> edit </a>]
		</td>
	</tr>

	<form:form action="editOption.htm" method="post" commandName="option">
		<tr>
			<td>Edit Option: </td>
			<td>${editoptId.optionDesc}</td>
		</tr>
		<tr><td>Re-enter Option: </td>
			<td colspan="2"><form:textarea cols="50" path="optionDesc"
					rows="2" /></td>
			<form:hidden path="optionId" value="${editoptId.optionId}" />
		</tr>
		<tr>
			<td></td>
			<td><input type="reset"><input type="submit"
				value="Edit"></td>
		</tr>

	</form:form>
</table>


