<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<!--
Copyright (c) 2003-2012, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
-->
<html>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/website.css"
	type="text/css" media="screen" />

<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>


</head> 
<body>
 <div class="viewport">
			<div class="overview">
<div id="container">
<div class="notepad-top"><div class="entry_title"><b>${articlePost.title}</b></div>
</div>
<div class="notepad">
<div id="content"><div class="entry single"><fmt:formatDate
								pattern="yyyy-MM-dd" value="${articlePost.date}" />
<form:form action="postComment.htm" method="post"
					commandName="viewArticle">

					<c:if test="${not empty articlePost}">	
									
					    ${articlePost.editorText}		
				</c:if>


				

					<%-- <table>
						<tr>
							<th colspan="2" style="color: blue;" align="center">Post A
								Comment</th>
						</tr>
							<tr>
					<td>${successMsg}</td>
				</tr>
						<tr>
							<td style="color: blue">Comment:</td>
							<td><form:textarea cols="35" path="postComment" rows="4" /></td>
							<td style="color: #ff0000"><form:errors path="postComment" /></td>
						</tr>
						<tr>
							<td><form:label path="commentBy" style="color:blue">Name:</form:label></td>
							<td><form:input path="commentBy" /></td>
							<td style="color: #ff0000"><form:errors path="commentBy" /></td>
						</tr>

						<tr>
							<td><form:label path="commentByEmailId" style="color:blue">Email:</form:label></td>
							<td><form:input path="commentByEmailId" /></td>
							<td style="color: #ff0000"><form:errors
									path="commentByEmailId" /></td>
						</tr>

						<tr>
							<td colspan='2'><input type="submit" style="color: blue"
								value="Publish" class="button"></input><input type="button"
								onclick="history.back()" class="button" value="Cancel" /></td>
						</tr>

						<tr></tr>

					</table> --%>
					<form:hidden path="fkArticle" value="${articlePost}" />
				</form:form>
				
				 
		</div>
		 
		</div>
		</div>
		  
	
		<div class="notepad-bottom">
		 </div>
		</div>
		</div>
		</div>
		
		

</body>
</html>
