<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#cancel").click(function() {
			document.location.href = '../';
		});
		$('.checkbox').click(function() {
			$(".v").text("");
		});
	});
</script>
<head>
<title>Home</title>
<script>
	function getPom() {
		var cbs = document.getElementsByName('chkBox');
		var result = '';

		for ( var i = 0; i < cbs.length; i++) {

			if (cbs[i].checked)
				result += (result.length > 0 ? "," : "") + cbs[i].value;
		}
		if (result != "") {
			document.getElementById("result").value = result;
			document.pomGenerator.action = "getPom.htm";

			document.pomGenerator.submit();
		} else {
			$("#msg").text("Please check atleast 1 option")
			}
	}
</script>

</head>
<body>
	<center><br>
		<h3>Please select dependencies</h3>
		<br>
		<span style="color: red;" id="msg" class="v">&nbsp;</span>
		<form name="pomGenerator" id="pomGenerator" method="post">
			<table cellspacing="7">

				<tr>
					<td>JSTL :</td>
					<td><input type="checkbox" name="chkBox" id="jstl"
						value="pom.jstl" class="checkbox"></td>
				</tr>
				<tr>
					<td>AOP :</td>
					<td><input type="checkbox" name="chkBox" id="aop"
						value="pom.aop" class="checkbox"></td>
				</tr>
				<tr>
					<td>Spring :</td>
					<td><input type="checkbox" name="chkBox" id="spring"
						value="pom.spring" class="checkbox"></td>
				</tr>
				<tr>
					<td>Oracle JDBC :</td>
					<td><input type="checkbox" name="chkBox" id="orcl"
						value="pom.oracle" class="checkbox"></td>
				</tr>
				<tr>
					<td>SQL JDBC :</td>
					<td><input type="checkbox" name="chkBox" id="sql"
						value="pom.sql" class="checkbox"></td>
				</tr>
				<tr>
					<td>Hibernate :</td>
					<td><input type="checkbox" name="chkBox" id="hiber"
						value="pom.hibernate" class="checkbox"></td>
				</tr>
				<tr>
					<td>JUnit :</td>
					<td><input type="checkbox" name="chkBox" id="junit"
						value="pom.junit" class="checkbox"></td>
				</tr>
				<tr>
					<td>JSON :</td>
					<td><input type="checkbox" name="chkBox" id="json"
						value="pom.json" class="checkbox"></td>
				</tr>
				<tr>
					<td>LOG4J :</td>
					<td><input type="checkbox" name="chkBox" id="log4j"
						value="pom.log4j" class="checkbox"></td>
				</tr>
				<tr>
					<td>GSON :</td>
					<td><input type="checkbox" name="chkBox" id="gson"
						value="pom.gson" class="checkbox"></td>
				</tr>
				<tr>
					<td>Spring Security :</td>
					<td><input type="checkbox" name="chkBox" id="spsty"
						value="pom.springsecurity" class="checkbox"></td>
				</tr>
				<tr>
					<td>Tiles :</td>
					<td><input type="checkbox" name="chkBox" id="tiles"
						value="pom.tiles" class="checkbox"></td>
				</tr>


				<input type="hidden" name="result" id="result">
				</br>
				<tr>
					<td align="center"><input type="button"
						name="chkBox" id="tiles" value="Get POM"
						onclick="javascript:getPom();" class="button" style="width: 70px"></td>
					<td><input type="button" id="cancel" class="button"
						value="Cancel" style="width: 70px" /></td>
				</tr>
			</table>
		</form>
	</center>
</body>

