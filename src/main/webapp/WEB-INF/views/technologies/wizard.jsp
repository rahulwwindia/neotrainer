
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>

<html>
<head>
<script>
	$("tr:odd").css("background-color", "#bbbbff");
</script>
<style>
div.note {
	background: #2192D8;
	color: #FFFFFF;
	border: 1px solid #8a9195;
	margin-bottom: 1.5em;
	background-repeat: no-repeat;
	background-position: 10px 10px;
	padding: 1em;
	padding-bottom: 20px;
	background-image:
		url("<%=request.getContextPath()%>/resources/images/note.png");
}
</style>
</head>
<body>

	<div id="wizdiv1"
		style="color: #3A3D3E; margin-left: 20px; margin-top: 10px;">
		<div
			style="border: 1px solid #8A9195; color: #FFFFFF; background: #28597A; margin-bottom: 5px; padding: 1em 1em 20px;">
			This tutorial will guide you to learn the technology with the help of
			Visual Screen shots to better understand the whole process.</div>
		<table cellspacing="0px" cellpadding="0px">
			<c:set var="counter" value="0" />

			<c:forEach items="${ImgList}" var="list">
				<c:set var="counter" value="${counter+1}" />
				<tr>
					<td><div class="note" style="margin-top: 10px; margin-bottom: 10px;" >
							<H2 style="margin-left: 53px;">Step ${counter}</H2>

							<br>

							<div style="text-align:justify;">
								<c:out value="${list.imageDescription}" />
							</div>   V
						</div></td>
				</tr>
				<tr style="align: center">
					<td><a
						href="<%=request.getContextPath()%>/resources/UploadedImage/${list.imageName}">
							<img
							src="<%=request.getContextPath()%>/resources/UploadedImage/${list.imageName}"
							width="586px" height="368px"
 
							style="box-shadow: 7px 5px 2px #7B7B7B;" />
					</a></td>

				</tr>
				<!-- 	<tr>
					<td style="border-bottom: 1px dashed black; padding-top: 10px;"></td>
				</tr> -->


			</c:forEach>
		</table>
	</div>
<div	style="border: 1px solid #8A9195; margin-top: 10px; color:  #FFFFFF; background: #28597A; margin-bottom: 5px; padding: 1em 1em 20px;">
		Thank you for reading this article, if you have any query or
		suggestion please feel free to ask by posting in our blog section.
	</div>
</body>
</html>