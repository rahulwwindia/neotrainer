
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/menu.css"
	rel="stylesheet" />
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style.css"
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





<script type="text/javascript">			
							 
								
							$().ready(function(){
								     var pno=  $('#pageno').val();
							 		//alert(pno);
							 		$('#pgnumb').text(pno);
									// alert("tete");
									// alert("teteasdad")
							
									 $.ajaxForm({ 
									   		
									   	
							  		    type: "POST",  
							  		   	 
							  		    url: "saveImage.htm",
							  		    success: function(data)
							  		    { alert("SUCCESSS !");
							  		   //	alerts(data)
							  		    

							  		     }
									
							  		    });
								
										 
										//alert( );
							  
							}); 
							
							function validateForm() 
							{
								validate_fileUpload();
								if($("#imageDescription").val().trim()=='')
									{
									alert("please insert description")
									}
							}
							
							function validate_fileUpload() 
							{    
								var fileData= $("#fileData").val();  
							    var allowed_extensions = new Array("jpg","png","jpeg","gif");
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
















<div id="upload">





	<table border="0" cellspacing="10" cellpadding="10">

		<form:form method="POST" action="saveImage.htm"
			commandName="tutorialImages" enctype="multipart/form-data" id="formy">
<div style="padding-top: 13px; padding-bottom: 15px; text-align: center;">
			<h3>
				 Page
					<div id="pgnumb" style="display: inline; font-weight: bold;"></div> Of
					Tutorial
					<div id="tutname" style="display: inline" font-size=:16px>

						${sessionScope.tutorialName}</div> Under Technology
					<div id="techname" style="display: inline" font-size=:16px>
						${sessionScope.TechnoName}</div>
				
			</h3>
</div>

			<tr>
				<td>Select file :</td>
				<td><input type="file" path="fileData" name="fileData" /></td>
			</tr>

<tr>
				<input name="tutoName" type="hidden"
					value="${sessionScope.tutorialName}">
			</tr>
			<tr>
				<input id="pageno" name="pageNum" type="hidden" value="${pageNo}">
			</tr>

			<tr>
				<input name="pointer" type="hidden" value="${parentRow}">
			</tr>


			<%-- <form:errors path="*" cssClass="errorblock" element="div" /> --%>
			<tr>
				<td>Description :</td>
				<td><form:textarea path="imageDescription" cols="50" rows="5" id="imageDescription" /></td>
			</tr>


			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save" class="button" onclick="return validateForm();" />
					</form:form></td>
					
				<td colspan="2" align="center"><a href="ExitSaveImage.htm">
				
				<button class="button">Finish</Button></a></td>
			</tr>
			

			<span> <%-- <form:errors path="file" cssClass="error" /> --%>
			</span>

		
		<tr><td>
		
		</td></tr>
	</table>

</div>

