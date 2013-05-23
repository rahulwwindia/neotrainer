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

<body>
	<div id="modal">
		<div id="heading">Add Tutorial Under ${sessionScope.TechnoName}</div>
		<div id="content">
			<div class="entry">
			
				<form name='f'	method="post" action="saveTechTute.htm" >
					<table border="0" cellspacing="5">
						<br />
						<tr> 
							<td></td>
							<td><input name='technologyName' type="text" hidden="true" name='technologyName' value=' ${sessionScope.TechnoName}'
								style="width: 172px;" /></td>
						</tr>
						<tr>
							<td>Tutorial Name:</td>	
							<td><input type="text" name='tutorialName' value=''
								style="width: 172px;"  id="tutorialName"/></td><td><div id="Status"></div></td>
								
						</tr>
						 
						<tr>
							<td><input type="submit" class="button green close"
								value="Save" id="saveb"></td>
							<td><a href="addNewTutorial.htm" class="button red close"> <buton>No!</buton> </a></td>
							<td><div id="tutLoad"><img src='<%=request.getContextPath()%>/resources/images/loading.gif' width="10" hight="10"/>loading...</div></td>
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
			$('#tutLoad').hide();
			
			
			$('#saveb').attr('disabled',true);
			var techname ="${sessionScope.TechnoName}"; 
			$('#tutorialName').keyup(function(){
				 $('#tutLoad').show(); 
				 
				 
				
				/* var $div2 = $('#tutLoad');
			    if ($div2.is(":visible")) { return; }
			    $div2.show();
			    setTimeout(function() {
			        $div2.hide();
			    }, 1000);
				 */
		
				var tutname=$('#tutorialName').val();
				alert(tutname) 
				 $.ajax({ 
				   		/* alert("in ajax"); */
					   	
			  		    type: "GET",  			
			  		    dataType:"text",
			  		    url: "CheckTutorial.htm?TutorialName="+tutname+"&TechnologyName="+techname,
			  		    success: function(data)
			  		    { 
			  		 	 $('#tutLoad').hide(); 
			  		    
			  //		    alert("If ke Pehle"+ data);
			  		    	
			  		    	if(data.trim()=="true")
			  		    			{
			  		    		$('#saveb').attr('disabled',true);
			  		    	/* 	alert("aaya kya"); */
						  		    		$('#Status').html("Tutorial already Exist ");
			  		    			
			  		    			}
			  		    	else if(data.trim()=="false")
			  		    	{
			  		    		$('#Status').html("");
			  		    		
			  		    		$('#saveb').attr('disabled',false);
			  		    	}
			  		  	
			  		    

			  		     }
					
			  		    });
				
				
				
			});
			
			
			
			//$('#postQuest').click(function(e) { // Button which will activate our modal
			$('#modal').reveal({ // The item which will be opened with reveal
				animation : 'fade', // fade, fadeAndPop, none
				animationspeed : 600, // how fast animtions are
				closeonbackgroundclick : false, // if you click background will modal close?
				dismissmodalclass : 'close' // the class of a button or element that will close an open modal
			});
			return false;
			//}); 
			
			
		});
		
		
		
		
	</script>
</body>