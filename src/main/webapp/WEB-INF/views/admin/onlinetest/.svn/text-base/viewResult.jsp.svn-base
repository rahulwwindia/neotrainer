<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
<script>
$(function() {
$( "#fromDate" ).datepicker();
$( "#toDate" ).datepicker();
});

</script>
</head>
<body>
	<form:form action="getResult.htm" commandName="range" method="POST" id="theForm">
		<table cellpadding="6">
			<tbody> 
				<tr> 
					<td>From Date</td><td><input  id="fromDate" name="fromDate" class="required" style="width: 105px;" /> 
					</td>
					<td>To Date</td><td><input  id="toDate" name="toDate" class="required" style="width: 105px;" />
   
					</td> 

					<td>
					<td><select type="text" name='group' id='group'>
						<ption value="-1">--Select Group---</ption>
							<option value="Java">Java</option>
							<option value="DotNet">DotNet</option>
							<option value="PHP">PHP</option>
  
					</select></td>      
          
					<td>
						<div class="wrapper">
							<input value="Go" id="result" name="getResult" type="submit" class="button"></input>
						</div>
					</td>
				</tr>
			</tbody>
		</table> 

	</form:form>


</body>
</html>

