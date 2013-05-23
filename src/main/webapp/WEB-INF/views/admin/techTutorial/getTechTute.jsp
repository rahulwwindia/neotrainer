<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%> 
<select id="tutorial" style="background: skyblue;">
<option disabled="disabled" selected="selected">Choose
								Tutorials</option>
	<c:forEach var="aff" items="${techTuteList}">
		<option value="${aff.tutorialName}">${aff.tutorialName}</option>
	</c:forEach> 
</select>    
 
 
 
 

  