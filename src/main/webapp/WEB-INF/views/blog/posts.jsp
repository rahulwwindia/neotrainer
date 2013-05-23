<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/website.css"
	type="text/css" media="screen" />
</head>
<body>
	<h2 align="center">${grpName} Posts</h2>

	<div class="viewport">
		<div class="overview"> 
			<div id="cont"> 
				<c:forEach items="${hmPosts}" var="post" varStatus="i">
					<%-- <div class="${i.index % 2 == 0 ? 'even' : 'odd'}"> --%>
					
					<div class="bix-tbl-container" id="${post.key.postId}">  
	     
 						<table class="${i.index % 2 == 0 ? 'even' : 'odd'}">
							<tr> 
								<td><b>Post Title :</b>${post.key.postTitle}</td>
							</tr>
							<tr>
								<td><b>Post Description</b><br />
								<br />${post.key.postContent}</td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td><b>Posted By:${post.value}</b></td>
							</tr>
							<tr>
								<td><b>Posted Date:</b>${post.key.postDate}</td>
							</tr>
							
						</table><br/>
						<table>
						<tr>
								<td><a
									href="viewComments.htm?postID=${post.key.postId}"
									class="button">View Comments</a></td>

								<c:if test="${post.value==userSessionName}">
									<td><a
										href="deletePosts.htm?postID=${post.key.postId}&&grpName=${grpName}"
										class="button">Delete Post</a></td>

								</c:if>

							</tr> 
						</table>
					</div>
				</c:forEach>
			</div>
		</div>

	</div>

</body>

