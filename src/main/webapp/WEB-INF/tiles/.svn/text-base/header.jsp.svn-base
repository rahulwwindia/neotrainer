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
		
		// hide #back-top first
		$("#back-top").hide();
		// fade in #back-top
	
		$(window).scroll(function () {
		if ($(this).scrollTop() > 100) {
		$('#back-top').fadeIn();
		} else {
		$('#back-top').fadeOut();
		}
		});
		// scroll body to 0px on click
		$('#back-top a').click(function () {
		$('body,html').animate({
		scrollTop: 0
		}, 800);
		return false;
		});
	 
		  
		var userName = '${userSessionName}';
		if (userName != "") {

			/* $("#welcome").hide(); */

			$("#welcome").show();

			$("#logIn").remove();

			$("#newUsr").remove();

			$("#logOut").show();

			/* 	document.getElementById("welcome").style.visibility='visible';
				document.getElementById("logIn").style.visibility = "hidden";
				document.getElementById("newUsr").style.visibility = "hidden";
				document.getElementById("logOut").style.visibility = "visible";
			 */}

		$("#postQ").click(function() {
			if (userName == "") {
				window.location = 'loginPopup.htm?source=post';
			} else {
				window.location = 'postQ.htm';
			}
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
	
	//Alind's Part Of java Scrip on this page
/* 	function getChilds(var tName) {

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

	} */
	
	
	
	
</script>

</head>
<body>

	<!-- <div id="google_translate_element"></div><script type="text/javascript">
function googleTranslateElementInit() {
  new google.translate.TranslateElement({pageLanguage: 'en', layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');
}
</script><script type="text/javascript" src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
 -->
	<div name="div1" class="page-out">
		<div name="div2" class="page-in">
			<div name="div3" class="page">
				<div name="div4" class="main">
					<div name="div5" class="header">
						<span><div name="div6">


								<div name="logoImg" style="float: left; width: 236px;">
									<img
										src="<%=request.getContextPath()%>/resources/images/logo.png"
										width="213px">
								</div>
								<div name="div7"
									style="display: none; float: right; color: white; width: 350px; margin-top: 25px"
									id="welcome">
									<tbody>
										<tr>
											<td><a>Welcome ${userSessionName} !</a></td>
											<td><a
												style="display: none; width: -moz-fit-content; margin-left: 96px; margin-top: -20px;"
												id="logOut"
												href="<c:url value="/j_spring_security_logout"/>"
												class="button"> Log Out </a></td>
									</tbody>
								</div>





								<div class="header-top" name="div9">
									<div id="menu" name="div10">
										<ul class="menu">
											<li><a href="../"><span>home</span></a></li>

											<li><a href="#" class="parent"><span>Technologies</span></a>
												<div name="div11">


													<ul>

														<c:forEach items="${map}" var="holder">
															<li><a href="#" class="parent"><span><c:out
																		value="${holder.key}" /></span></a>
																<div>
																	<ul>




																		<c:forEach items="${holder.value}" var="list">
																			<c:choose>
																				<c:when test="${empty list.tutorialName}">
																				</c:when>


																				<c:otherwise>
																					<li><a href="DisplayWizard.htm?tutoName=${list.tutorialName}&techName=${holder.key}" class="parent"><span><c:out
																								value="${list.tutorialName}" /></span></a></li>
																				</c:otherwise>
																			</c:choose>
																		</c:forEach>


																	</ul>
																</div>
														</c:forEach>



													</ul>

												</div></li>

											<li class="last"><a href="#" class="parent"><span>Demo
														Application</span></a>
												<div name="div12">
													<ul>
														<c:forEach items="${demoList}" var="list">
															<li><a href="demoApp.htm?app=${list.demoTechName}"><span>${list.demoTechName}</span></a></li>
													</c:forEach> 
									 
													</ul>
												</div></li>
										<%-- 	<sec:authorize access="!hasRole('ROLE_USER')">
												<li><a href="#" class="parent"><span>Online
															Test</span></a>
													<div name="div13">
														<ul>
															<sec:authorize access="!hasRole('ROLE_ADMIN')">
																<li><a href="onlineTest.htm"><span>Start
																			Test</span></a></li>
															</sec:authorize>
															<li><a href="loginCand.htm"><span>Result</span></a></li>
														</ul>
													</div></li> 
											</sec:authorize> --%>

											<li class="last"><a href="#" class="parent"><span>Blog</span></a>
												<div name="div14">
													<ul>
														<li><a href="#"><span>Technical Blog</span></a>
															<div>
																<ul>
																	<li><a href="showPost.htm?grpName=Java"><span>Java</span></a>
																	</li>
																	<li><a href="showPost.htm?grpName=DotNet"><span>.Net</span></a></li>
																	<li><a href="showPost.htm?grpName=PHP"><span>PHP</span></a></li>
																</ul>
															</div></li>
														<li><a href="#" id="postQ"><span>Post
																	Queries</span></a></li>
														<li><a href="#"><span>Other Blog</span></a></li>
													</ul>
												</div></li>
											<li class="last"><a href="#" class="parent"><span>Article</span></a>
												<div name="div15">
													<ul>
														<li><a href="articlePage.htm?articleOf=Java"><span>Java</span></a></li>
														<li><a href="articlePage.htm?articleOf=.Net"><span>.Net</span></a></li>
														<li><a href="articlePage.htm?articleOf=PHP"><span>PHP</span></a></li>
														<li><a href="articlePage.htm?articleOf=ROR"><span>ROR</span></a></li>
													</ul>
												</div></li>

											<li class="last"><a href="showGenerator.htm"><span>Generator</span></a>
											</li>
											<li><a href="#"><span>Help</span></a></li>
										</ul>
									</div>

								</div>
								<div class="header-bottom" name="div1">
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

