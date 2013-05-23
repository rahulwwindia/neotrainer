<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<table cellpadding="7" id="questDiv" style="width: 100%">
	<tr>
		<td></td>
		<td></td>
		<td><c:forEach items="${questhm}" var="h" begin="0" end="0">[<a
					href="addQuest?questId=${h.key.questId}"> add new question</a> ]</c:forEach></td>
	</tr>

	<c:forEach items="${questhm}" var="hmquest">
		<tr>
			<td><b>Question:</b></td>
			<td><b>${hmquest.key.questDesc}</b></td>
			<td>[<a href="editQuest?questId=${hmquest.key.questId}">
					edit </a> / <a href="deleteQuest?questId=${hmquest.key.questId}">
					delete </a>]
			</td>
		</tr>
		<tr>
			<td>Options:</td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach items="${hmquest.value}" var="opt" varStatus="i">
			<tr>
				<%-- <td>${opt.key }</td> --%>
				<td>${i.count}. ${opt.value.optionDesc }</td>
				<td></td>
				<td align="right">[<a
					href="editOpt?optId=${opt.key}&questId=${hmquest.key.questId}">
						edit </a>]
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td>Correct Option:</td>
			<td>${hmquest.key.correctOption}</td>
			<td>[<a href="#"> edit </a>]
			</td>
		</tr>
	</c:forEach>
</table>


