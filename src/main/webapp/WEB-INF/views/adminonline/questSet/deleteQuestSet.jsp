<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#cancel").click(function() {
			document.location.href = 'testHome.htm';
		});
	});
	function questId() {
		var value = document.getElementById("questSet").value;
		$("#setId").val(value);
	}
</script>
<div align="center">

	<table cellpadding="7">
		<tr>
			<td colspan="3"><h3>Delete Question Set</h3></td>
		</tr>
		<tr>${adminMsg}
		</tr>
		<tr>
			<td>Question Set</td>
			<td><select name="questSet" id="questSet" onchange="questId()"
				style="background: skyblue;">
					<c:forEach items="${questSetMap}" var="qtSetMap">
						<option value="${qtSetMap.key}">${qtSetMap.value.setName}</option>
					</c:forEach>
			</select></td>
			<td>[<a href="addSet.htm"> add </a>/<a href="editSet.htm">
					edit </a>]
			</td>
		</tr>
		<form action="deleteQuestSet.htm" method="post">
			<!-- <tr>
				<td>Question Set Name:</td>
				<td><input type="text" id="setName" name="setName" /></td>
			</tr> -->
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Remove" class="button" /><input type="hidden" id="setId"
					name="setId" style="width: 70px"><input type="button"
					id="cancel" class="button" value="Cancel" style="width: 70px" /></td>
			</tr>
		</form>
	</table>
</div>