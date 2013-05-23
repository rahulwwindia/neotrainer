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
<script type="text/javascript">
	$(document).ready(function() {

	});
	function checkEmail() {
		$(".v").text("");
		var x = document.getElementById("j_username").value;
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if ((x != null || x != "") && x.match(filter)) {
			//alert("Matched");
			return true;
		} else {
			//alert("Mis match");
			document.getElementById("j_username").value = "";
			document.f.j_username.focus();
			$("#n").text(" * Invalid Email");
			return false;
		}
	}
	function checkPassword() {
		$(".v").text("");
		var x = document.getElementById("j_password").value;
		if (x == "") {
			document.f.j_password.focus();
			$("#p").text(" * Required");
			return false;
		}
		return true;
	}
	function checkFields() {
		$(".v").text("");
		var p = document.getElementById("j_password").value;
		var n = document.getElementById("j_username").value;
		if (n == "") {
			document.f.j_username.focus();
			$("#n").text(" * Required");
			return false;
		} else if (p == "") {
			document.f.j_password.focus();
			$("#p").text(" * Required");
			return false;
		} else {
			return true;
		}

	}
</script>
<body onload='document.f.j_username.focus();'>
	<div id="modal">
		<div id="heading">Please Login</div>
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
					<table border="0" cellspacing="5" style="margin-top: 25px;height: 100px;">
						<br />
						<tr>
							<td>Email Id</td>
							<td><input type="text" name='j_username' id='j_username'
								value='' style="width: 172px;" onchange="return checkEmail();" /><span
								style="color: red;" id="n" class="v">&nbsp;</span></td>
						</tr>
						<tr>
							<td>Passwords</td>
							<td><input type="password" name="j_password" id="j_password"
								style="width: 172px;" onchange="return checkPassword();" /><span
								style="color: red;" id="p" class="v">&nbsp;</span></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
							<input type="submit" class="button"
								value="Yes, Login!" onclick="return checkFields();" style="width: 90px;" "cursor:hand;">
								<input type="button" class="button"
								onclick="history.back()" style="width: 90px;" value="No!"></td>
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
				closeonbackgroundclick : false
			// if you click background will modal close?
			//dismissmodalclass : 'close' // the class of a button or element that will close an open modal
			});
			return false;
			//});
		});
	</script>
</body>