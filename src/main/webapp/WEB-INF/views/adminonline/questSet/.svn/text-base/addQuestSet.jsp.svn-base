<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#cancel").click(function() {
			document.location.href = 'testHome.htm';
		});
	});
	function checkFields() {
		var set = $("#setName").val();
		if (set != "") {
			document.addsetForm.submit();
		} else {
			document.addsetForm.setName.focus();
			return false;
		}
	}
</script>
<div align="center">

	<table cellpadding="7">
		<tr>
			<td colspan="3"><h3>Add New Question Set</h3></td>
		</tr>
		<tr>${adminMsg}
		</tr>

		<form action="addQuestSet.htm" method="post" name="addsetForm">
			<tr>
				<td>Question Set Name:</td>
				<td><input type="text" id="setName" name="setName" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Add"
					class="button" style="width: 70px" onclick="return checkFields();" /><input
					type="button" id="cancel" class="button" value="Cancel"
					style="width: 70px" /></td>
			</tr>
		</form>
		<%-- 	<tr>
			<td><h3>Question Set</h3></td>
			<td>
			 <select name="questSet" id="questSet"
				style="background: skyblue;">
					<c:forEach items="${questSetMap}" var="qtSetMap">
						<option value="${qtSetMap.key}">${qtSetMap.value.getSetName()}</option>
					</c:forEach>
			 </select> 
			</td>
			<td>[<a href="editSet.htm"> edit </a>/<a href="deleteSet.htm">
					delete </a>]
			</td>
		</tr>
		<c:forEach items="${questSetMap}" var="qtSetMap">
			<tr>
				<td>${qtSetMap.value.getSetName()}</td>
			</tr>
		</c:forEach> --%>
	</table>
</div>
