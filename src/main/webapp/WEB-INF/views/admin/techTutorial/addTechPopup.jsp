<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/menu.css"
	rel="stylesheet" />
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/popupbox.css"
	rel="stylesheet" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql_rt"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/popupbox.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>

<body>
	<div id="modal">
		<div id="heading">Please Add New Technology</div>
		<div id="content">
			<div class="entry">

				<form:form name="f" action="saveTechnology.htm" method="post"
					commandName="technologies">
					<table border="0" cellspacing="5">
						<br />
						<tr>
							<td>Technology Name:</td>
							<td><form:input path='technologyName' value=''
									style="width: 172px;" /></td>
						</tr>
						<tr>
							<td><input type="submit" class="button green close"
								value="Add Technology"></td>
							<td><a href="addNewTutorial.htm" class="button red close">
									Cancel </a></td>
						</tr>
					</table>
					<%-- <input type="hidden" name="source" value="${source}">
			<input type="hidden" name="postID" value="${postID}"> --%>
				</form:form>
			</div>
		</div>
	</div>

	<!--jQuery-->
	<script src="<%=request.getContextPath()%>/resources/js/popupbox.js"></script>

	<script type="text/javascript">
		$(document).ready(function(e) {
			//$('#postQuest').click(function(e) { // Button which will activate our modal
			$('#modal').reveal({ // The item which will be opened with reveal
				animation : 'fade', // fade, fadeAndPop, none
				animationspeed : 600, // how fast animtions are
				closeonbackgroundclick : true, // if you click background will modal close?
				dismissmodalclass : 'close' // the class of a button or element that will close an open modal
			});
			return false;
			//});
		});
	</script>
</body>