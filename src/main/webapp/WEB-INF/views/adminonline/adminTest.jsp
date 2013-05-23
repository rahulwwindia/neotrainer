<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/website.css"
	type="text/css" media="screen" />

<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.tinyscrollbar.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#scrollbar1').tinyscrollbar();
	});
</script>

<script type="text/javascript">
	function getQuestions() {
		var setId = document.getElementById("questSet").value;
		var settype = document.getElementById("settype").value;
		var level = document.getElementById("level").value;
		var setEnt = setId + "," + settype + "," + level;
		document.getElementById("setEntries").value = setEnt;
		//alert("setId: " + setId + "settype: " + settype + "level: " + level);
		if (setId != "" && settype != "" && level != "") {
			$.ajax({
						type : "Get",
						data : {
							qsetId : setId,
							settype : settype,
							level : level
						},
						url : "getQuestions.htm",
						success : function(data) {
							if (data == "") {
								alert("no questions found.");
								//$("#qDiv").innerHTML = ""; 
								//document.getElementById("qDiv").innerHTML = "<a href='#'>Add Questions</a>";
							}
							document.getElementById("qDiv").innerHTML = data;
							document.getElementById("Edit Question").style.visibility = "hidden";
							document.getElementById("Delete Question").style.visibility = "hidden";
							/* 	document.getElementById("Edit Question").disabled = true;
								document.getElementById("Delete Question").disabled = true;
							 *///alert(data);
							//$("#questDiv").replaceWith(data);  
						}
					});
		} else if (setId == "") {
			document.getElementById("questSet").focus();
		} else if (settype == "") {
			document.getElementById("settype").focus();
		} else if (level == "") {
			document.getElementById("level").focus();
		}
	}
	$(document).ready(function() {
		//document.getElementById("Edit Question").disabled = false;
	});

	function toggleChecked(status) {
		//alert("status: "+status);
		$(".checkbox").each(function() {
			$(this).attr("checked", status);
		})
		if (status == true) {
			document.getElementById("Delete Question").style.visibility = "visible";
		} else {
			document.getElementById("Delete Question").style.visibility = "hidden";
		}
	}
	function checkSetEntries() {
		var setId = document.getElementById("questSet").value;
		var settype = document.getElementById("settype").value;
		var level = document.getElementById("level").value;
		var setEnt = setId + "," + settype + "," + level;
		if (setId != "" && settype != "" && level != "") {
			//$("#setEntries").val(setEnt);
			document.getElementById("setEntries").value = setEnt;
			document.questForm.submit();
			return true;
		} else {
			alert("Please select all details");
			return false;
		}
	}

	function checkSelected(status) {
		//alert("status: "+status);
		if (status == true) {
			document.getElementById("Delete Question").style.visibility = "visible";
		} else {
			$("#selectAll").attr("checked", false);
		}
		var n = $("input:checked").length;
		//alert("n: " + n);

		if (n == 1) {

			document.getElementById("Edit Question").style.visibility = "visible";
		} else {
			document.getElementById("Edit Question").style.visibility = "hidden";

		}
		if (n == 0) {
			document.getElementById("Delete Question").style.visibility = "hidden";

		}

	}
</script>

<div align="center">${questMsg }</div>
<div align="center">
	<form action="questionAction.htm" method="post" name="questForm">
		<table cellpadding="7">
			<tr>
				<td colspan="3" align="center"><h3>Set Question Paper</h3></td>
			</tr>

			<tr>
				<td>Paper Type</td>
				<td><select name="questSet" id="questSet"
					onchange="getQuestions()" style="background: skyblue;">
						<option value="">---Paper Type----</option>
						<c:forEach items="${questSetMap}" var="qtSetMap">
							<option value="${qtSetMap.key}">${qtSetMap.value.setName}</option>
						</c:forEach>
				</select></td> 
				<td><a href="addSet.htm" id="add" style="text-decoration: none"
					class="button">Add</a> <a href="editSet.htm" id="edit"
					style="text-decoration: none" class="button">Edit</a> <a
					href="deleteSet.htm" id="delete" style="text-decoration: none"
					class="button">Delete</a></td>
			</tr>

			<tr>
				<td>Set</td>
				<td><select name="settype" id="settype"
					onchange="getQuestions()" style="background: skyblue;">
						<option value="">---Select Set---</option>
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="C">C</option>
						<option value="D">D</option>
				</select></td>
				<!-- <td><a href="addSet.htm" id="add" style="text-decoration: none"
					class="button">Add</a> <a href="editSet.htm" id="edit"
					style="text-decoration: none" class="button">Edit</a> <a
					href="deleteSet.htm" id="delete" style="text-decoration: none"
					class="button">Delete</a></td> -->
			</tr>

			<tr>
				<td>Experience</td>
				<td><select name="level" id="level" onchange="getQuestions()"
					style="background: skyblue;">
						<option value="">--Select Experience--</option>
						<option value="0">0</option>
						<option value="1">1+</option>
						<option value="2">2+</option>
						<option value="3">3+</option>
						<option value="4">4+</option>
						<option value="5">5+</option>  
				</select></td>
				<!-- <td><a href="addSet.htm" id="add" style="text-decoration: none"
					class="button">Add</a> <a href="editSet.htm" id="edit"
			div		style="text-decoration: none" class="button">Edit</a> <a
					href="deleteSet.htm" id="delete" style="text-decoration: none"
					class="button">Delete</a></td> -->
			</tr>
		</table>
		<div>
			<input type="submit" name="submit" value="Add Question"
				onclick="return checkSetEntries();" class="button"
				style="margin-left: 454px;" />
				</div>
		<div align="left" id="qDiv"></div>
		<input type="hidden" id="setEntries" name="setEntries" />

	</form>
</div>
