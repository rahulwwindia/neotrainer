<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
 
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/validation.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/validation.js"></script>
<div align="center">
	<script>
		jQuery(function() {

			/*  jQuery("#ValidNumber").validate({
			     expression: "if (!isNaN(VAL) && VAL) return true; else return false;",
			     message: "Should be a number"
			 }); */
			jQuery("#fileName").validate({
				expression : "if (VAL) return true; else return false;",
				message : "Please enter the Required field"
			});

			jQuery("#description").validate({
				expression : "if (VAL) return true; else return false;",
				message : "Please enter the Required field"
			});
 
			jQuery("#techName")
					.validate(
							{
								expression : "if (VAL != '-1') return true; else return false;",
								message : "Please make a selection"
							});
			
		
		});   
		
	</script> 
<script>
function validate_fileUpload() 
{    
	var fileData= $("#fileData").val();  
    var allowed_extensions = new Array("zip","war");
    var file_extension = fileData.split('.').pop(); // split function will split the filename by dot(.), and pop function will pop the last element from the array which will give you the extension as well. If there will be no extension then it will return the filename.

    for(var i = 0; i <= allowed_extensions.length; i++)
    {
        if(allowed_extensions[i]==file_extension)
        {
        	var uploadSize=document.getElementById('fileData').files[0].size;
    
        	  
        	    if(uploadSize < 10000000) { // 10 MB (this size is in bytes)
        	    	return true;        
        	    }  
        	    else 
        	    	{
        	    	alert("File size exceed Max size limit 10 MB")
        	    return false;
        	    	}
        	    
        	    return true;
        }
    }  
alert("invalid file type! \n must be zip or war") 
    return false;
}   
</script>

	<form:form action="uploadDemoApp.htm" method="POST"
		enctype="multipart/form-data" commandName="demoUpload" id="demoForm">
		<table cellpadding="6">
			<tbody>

				<tr>
					<td><lable> File Name</lable></td>
					<td><input type="text" name='fileName' id='fileName' value=''
						style="width: 172px;" /></td>
				</tr>

				<tr>
					<td><lable> Description</lable></td>
					<td>
					 
					 <textarea rows="4" cols="50" name='description' id='description'>

</textarea>
					 
					 
				</td> 
				</tr>
  
				<tr>
					<td><lable> Technology </lable></td>
					<td><Select type="text" name='techName' id='techName'
						value='' style="width: 172px;">  
							<option value="-1">Select Technology</option>
								<c:forEach items="${techList}" var="techList" varStatus="i">
							<option value="${techList.demoTechName}">${techList.demoTechName}</option>
							</c:forEach>
					</Select></td>   
					<td><a href="demoTech.htm" id="add" style="text-decoration: none"
					class="button">Add</a></td>
				</tr>     
				<tr>
					<td><lable> Upload Demo App</lable></td>
					<td><input type="file" name='fileData' id='fileData' value=''
						style="width: 172px;" /></td>
				</tr>   
				<tr>  
					<td></td>  
					<td><input type="submit" class="button" value="Upload"
						style="width: 90px;""cursor:hand;" onclick="return validate_fileUpload()"/></td>
				</tr> 
				</form:form>
			</tbody>
		</table>
</div>
