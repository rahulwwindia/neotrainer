<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js">
</script>

<script src="<%=request.getContextPath()%>/resources/js/jquery.bpopup.min.js">
</script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js">
</script>


 <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>

<script>					
							 $(document).ready(function(){
							    	$('#titletab').hide();
					  		    	$('#addTute').hide();
					  		     	$('#showMe').hide(); 
					  		     
					  		    	
								 $('#tech').change(function() 
										 {
									 
								
									    var name=$('#tech').val();
									   
									 	$.ajax({
							  		    type: "Get", 
							  		   	 
							  		    url: "getTechTute.htm?techname="+name,
							  		    success: function(data){ 
							  		    	
							  		    
							  		    	$('#titletab').show();
							  		    	$('#addTute').show();
							  		    	 document.getElementById("getAll").innerHTML=data;
							  		     }
							  		    });
							  
							}); 
								 
								 
							//	 $('#Show').click(function(){
								//	
									// alert("HELLO");
								//	$('#showMe').show( "blind", 1000 );
									 
									 
							//	 });
								 });
							 
							 jQuery(function() { 
								 
								 
							 					});	 
							 
							
	 </script>			
							


<body>

	
		<table cellpadding="0" cellspacing="10">




			<tbody >
<form:form action="getProject.htm" method="post"
		enctype="multipart/form-data" commandName="createProject">
				<%-- <c:forEach var="user" items="${techList}" varStatus="techlists">
      						  <div id="technologies${techlists.count} }"></div>
   							 </c:forEach> --%>




				<tr >
					<td style="width: 150px;">Technology:</td> 
					<td style="width: 235px;"><select name="tech" id="tech" style="background: skyblue;">
							<option disabled="disabled" selected="selected">Choose
								Technology</option>
							<c:forEach var="aff" items="${techlist}">
								<option value="${aff.technologyName}">${aff.technologyName}</option>
							</c:forEach>
		
							
					</select></td>
					<td><a href="addTechnologyPopUp.htm"><button class="button" >Add Technology</button></a></td>
				</tr>
<tr><td><BR></td></td></tr>
				<tr >  
					<td id="titletab">Tutorial:</td>
					   
					<td ><div id="getAll"></div></td>
					<td><a id="addTute" href="addTechTutePopup.htm"><button class="button">Add Tutorial</button></a></td>
				</tr> 

 </form:form>
 
			</tbody>
		</table>
	
	
	<div id="popUp1"></div>
</body>
