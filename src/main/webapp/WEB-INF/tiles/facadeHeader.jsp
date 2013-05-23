<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- <meta name="google-translate-customization" content="36a9f630ba2d8788-0b759e7fd05e9c7d-g26e6d74395690fcc-21"></meta>
 -->
<title>Neo Trainer</title>
<meta name="description" content="">
<meta name="keywords" content="">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link href="<%=request.getContextPath()%>/resources/css/style.css"
	rel="stylesheet" type="text/css">
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/menu.css"
	rel="stylesheet" />
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style.css"
	rel="stylesheet" />
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style_user.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/menu.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#postQ").click(function() {
			if (userName == "") {
				window.location = 'loginPopup.htm?source=post';
			} else {
				window.location = 'postQ.htm';
			}
		});

		//Alind's Part Of java Scrip on this page
		$('#ParList').change(function() {

			var name = $('#ParList').val();

			$.ajax({
				type : "Get",

				url : "getTechTute.htm?techname=" + name,
				success : function(data) {

					$('#titletab').show();
					$('#addTute').show();
					document.getElementById("getAll").innerHTML = data;
				}
			});

		});

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


<style>
.errorblock {
	color: #ff0000;
	padding: 8px;
	margin: 0px;
}
</style>

</head>
<body>
	<!-- <div id="google_translate_element"></div><script type="text/javascript">
function googleTranslateElementInit() {
new google.translate.TranslateElement({pageLanguage: 'en', layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');
}
</script><script type="text/javascript" src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
 -->
	<div class="page-out">
		<div class="page-in">
			<div class="page">
				<div class="main">
					<div class="header">
						<span><div>

								<div
									style="display: none; float: right; color: white; width: 300px; margin-top: 25px"
									id="welcome">
									<tbody>
										<tr>
											<td><a>Welcome ${userSessionName}</a></td>
											<td><a
												style="display: none; width: -moz-fit-content; margin-left: 96px; margin-top: -20px;"
												id="logOut"
												href="<c:url value="/j_spring_security_logout"/>"
												class="button"> Log Out </a></td>
									</tbody>
								</div>


								<div name="logoImg" style="float: left; width: 236px;">
									<img
										src="<%=request.getContextPath()%>/resources/images/logo.png"
										width="213px">
								</div>

								<div id="logIn" class="" style="float: right">
									<div class="entry" align="center">

										<form name='f'
											action="<c:url value='/j_spring_security_check' />"
											method="post">


											<table cellspacing="0">
												<tbody>
													<tr>
														<td class=""><label for="email">Username</label></td>
														<td class=""><label for="pass">Password</label></td>
													</tr>
													<tr>
														<td><input type="text" name='j_username'
															id='j_username' value='' style="width: 172px;"
															onchange="return checkEmail();" /></td>
														<td><input type="password" name="j_password"
															id="j_password" style="width: 172px;"
															onchange="return checkPassword();" /></td>


														<td><input type="submit" class="button" value="Login"
															onclick="return checkFields();" style="width: 90px;""cursor:hand;"></td>
													</tr>
													<tr style="height: 21px;">

														<td class=""><span style="color: red;" id="n"
															class="v">&nbsp;</span></td>
														<td class=""><span style="color: red;" id="p"
															class="v">&nbsp;</span></td>
													</tr>
													<tr>
														<c:if test="${not empty error}">
															<td>
																<div class="errorblock" style="float: left;">
																	${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
																</div>
															</td>
															<td></td>
														</c:if>

													</tr>


												</tbody>
											</table>

										</form>
									</div>
								</div>



							</div></span>


						<div class="header-top">
							<div id="menu">
								<ul class="menu">
								</ul>
							</div>

						</div>
						<div class="header-bottom">
							<img
								src="<%=request.getContextPath()%>/resources/images/NTlog2.gif"
								height="75" width="270"
								style="margin-left: 33px; margin-top: 33px;" />
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>



