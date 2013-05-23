<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/menu.css"
	rel="stylesheet" />
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/popupbox.css"
	rel="stylesheet" />
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql_rt"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/popupbox.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<%-- <script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script> --%>

<body onload='document.f.j_username.focus();'>
	<div id="modal">
		<div id="heading">Candidate Login</div>
		<div id="content">
			<div class="entry" align="center">
				<c:if test="${not empty error}">
					<div class="errorblock">
						Your login attempt was not successful, try again.<br /> Caused :
						${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
					</div>
				</c:if>
				<form name='f' action="<c:url value='/j_spring_security_check' />"
					method="post">
					<table border="0" cellspacing="5"
						style="margin-top: 25px; height: 100px;">
						<br />
						<tr>
							<td>Email Add:</td>
							<td><input type="text" name='j_username' value=''
								style="width: 172px;" /></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><input type="password" name="j_password"
								style="width: 172px;" /></td>
						</tr>

						<tr>
							<td><a href="RegisterCand.htm"><input type="button"
									class="button" value="New User" style="width: 90px;"></a></td>
							<td><input type="submit" class="button" value="Yes, Login!"
								style="width: 90px;"><input type="button" class="button"
								style="width: 90px;" value="No!" onclick="history.back()"></td>
						</tr>
					</table>
					<%-- <input type="hidden" name="source" value="${source}">
			<input type="hidden" name="postID" value="${postID}"> --%>
				</form>
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