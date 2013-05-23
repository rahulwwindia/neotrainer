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

	function techValidation()
	 {
		 if($("#tech").val().trim()==''){
				alert("please insert technology name");
				$("#tech").focus();
				return false; 
			}
 	 }
	
</script> 
<div align="center">
 
	<table cellpadding="7">  
		<tr>
			<td colspan="3"><h3>Add New Demo App Technology</h3></td>
		</tr>
		<tr>
		</tr>
 
		<form action="addDemoTech.htm" method="post" name="addsetForm">
			<tr>  
				<td>Technology Name:</td>
				<td><input type="text" id="tech" name="tech" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Add"
					class="button" style="width: 70px" onclick="return techValidation();" /><input
					type="button" id="cancel" class="button" value="Cancel"
					style="width: 70px" /></td>
			</tr>
		</form>
			</table>
</div>
