<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/menu.css"
	rel="stylesheet" />
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/questions.css"
	rel="stylesheet" />
<%-- <link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/popupbox.css"
	rel="stylesheet" /> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql_rt"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<%-- <script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/popupbox.js"></script> --%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js">
	
</script>
<script type="text/javascript">
	$(document).ready(function() {
		//alert("add quest document ready.");
		$('.checkbox').click(function(){
			   // save the original checked state of the one we're clicking:
			   var checked = $(this).attr('checked'); 
			   $('.checkbox').attr('checked', false); // uncheck all of the boxes
			   $(this).attr('checked', checked); // invert the original state
			});
	});
	function checkFields() {
		var qDesc = document.getElementById("qDesc").value;
		var opt1 = document.getElementById("opt1").value;
		var opt2 = document.getElementById("opt2").value;
		var opt3 = document.getElementById("opt3").value;
		var opt4 = document.getElementById("opt4").value;
		var crop = document.getElementsByName("crop");
		//alert("crop: " + crop.length);
		
		$(".v").text("")
		/* alert("qDesc: " + qDesc + " opt1: " + opt1 + " opt2: " + opt2
				+ " opt3: " + opt3 + " opt4: " + opt4); */
		if (qDesc == "") {
			document.editForm.qDesc.focus();
			$("#q").text(" * Required")
			//alert("returning false");
			return false;
		} else if (opt1 == "") {
			document.editForm.opt1.focus();
			$("#oo1").text(" * Required")

			return false;
		} else if (opt2 == "") {
			document.editForm.opt2.focus();
			$("#oo2").text(" * Required")
			return false;
		} else if (opt3 == "") {
			document.editForm.opt3.focus();
			$("#oo3").text(" * Required")
			return false;
		} else if (opt4 == "") {
			document.editForm.opt4.focus();
			$("#oo4").text(" * Required")
			return false;
		} 
		/* else {
			return true;
		} */
		var count=0;
		for ( var i = 0; i < crop.length; i++) {
			if (crop[i].checked) {
				//alert("df" + crop[i].value);
				break;
			}
			count++;
		}
		if(count==4){
			//alert("count: "+count);
			document.getElementsByName("crop")[0].focus();
			return false;
		}
		return true;
	}
</script>
<!-- <body> -->
	<div id="modal">
		<div id="heading"><h3>Edit Question</h3></div>
		<div id="content">
			<div class="entry">
				<form action="editQuestion.htm" method="post" name="editForm"
					onsubmit="return checkFields();">
					<table border="0" cellspacing="5">
						<br/>
						<tr>
							<td>Question:</td>
							<td><textarea rows="2" cols="70" name="questDesc" 
								 id="qDesc" class="questTextArea">${quest.getQuestDesc()}</textarea><span
								style="color: red;" id="q" class="v">&nbsp;</span></td>
						</tr>
						<c:forEach items="${opt}" var="option" varStatus="i">
							<tr>
								<td>Option ${i.count}:</td>
								<td><textarea rows="1" cols="70" name="option${i.count}"
									 id="opt${i.count}" class="oTextArea">${option.getOptionDesc()}</textarea><span
									style="color: red;" id="oo${i.count}" class="v">&nbsp;</span></td>
								<td><input type="checkbox" class="checkbox" name="crop" value="${i.count}" /></td>
							</tr>
						</c:forEach>

						<tr>
							<td>
								<%-- <input type="hidden" name="setEntries"
								value="${setEntries}" /> --%>
								<input type="hidden" name="questId"
								value="${quest.getQuestId()}" />
							</td>
						</tr>
						<tr>
							<td><input type="submit" class="button"
								value="Edit" /></td>
							<td><input type="button" onclick="history.back()"
								class="button" value="Cancel"/></td>
						</tr>
					</table>

				</form>
			</div>
		</div>
	</div>
<%-- 
	<!--jQuery-->
	<script src="<%=request.getContextPath()%>/resources/js/popupbox.js"></script>

	<script type="text/javascript">
		$(document).ready(function(e) {
			//$('#postQuest').click(function(e) { // Button which will activate our modal
			$('#modal').reveal({ // The item which will be opened with reveal
				animation : 'fade', // fade, fadeAndPop, none
				animationspeed : 600, // how fast animtions are
				closeonbackgroundclick : false
			// if you click background will modal close?
			//	dismissmodalclass : 'close' // the class of a button or element that will close an open modal
			});
			return false;
			//});
		});
	</script> --%>
<!-- </body> -->