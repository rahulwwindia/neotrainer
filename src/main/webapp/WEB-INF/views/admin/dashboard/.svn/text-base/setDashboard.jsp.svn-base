<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/website.css"
	type="text/css" media="screen" />
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.tinyscrollbar.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		//$('#scrollbar1').tinyscrollbar();
		document.getElementById("submit").style.visibility = "hidden";
	});
	function toggleChecked(status) {
		//alert("status: "+status);
		$(".checkbox").each(function() {
			$(this).attr("checked", status);
		})
		if (status == true) {
			document.getElementById("submit").style.visibility = "visible";
		} else {
			document.getElementById("submit").style.visibility = "hidden";
		}
	}

	function checkSelected(status) {
		if (status == true) {
			document.getElementById("submit").style.visibility = "visible";
		} else {
			$("#selectAll").attr("checked", false);
		}
		var n = $("input:checked").length;
		if (n == 0) {
			document.getElementById("submit").style.visibility = "hidden";

		}
	}
</script>

<script type="text/javascript"></script>
<div>
	<form action="showSelected.htm" method="post">


		<table class="product">
			<tbody>
				<tr>
					<td></td>
				</tr>
				<tr>  
				<td align="center" class="tcat">
					<input type="checkbox" id="selectAll"
						onclick="toggleChecked(this.checked)" /> Select all
					<input type="submit" value="Submit" class="button" id="submit" />
					</td>
				</tr>
			</tbody>
		</table>




		<table class="product">
			<tbody>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td align="center" class="tcat"><input type="checkbox"
						class="checkbox" name="topics"
						onclick="checkSelected(this.checked)" value="blogger" /> Blogger</td>
				</tr>
				<c:forEach items="${posts}" var="postslist"> 
					<tr>
						<td class="alt2"><a href="showPost.htm?grpName=${postslist.groupPost.groupName}#${postslist.postId}" style="text-decoration: none; ">${postslist.postTitle}</a></td>
					</tr>
				</c:forEach> 
			</tbody>  
		</table>
 
 
		<table class="product">
			<tbody>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td align="center" class="tcat"><input type="checkbox"
						class="checkbox" name="topics"
						onclick="checkSelected(this.checked)" value="articles" />
						Articles</td>
				</tr>
				<c:forEach items="${article}" var="articlelist">
					<tr>
						<td class="alt2"><a href="viewArticle.htm?articleTitle=${articlelist.title}" style="text-decoration: none; ">${articlelist.title}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<table class="product">
			<tbody>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td align="center" class="tcat"><input type="checkbox"
						class="checkbox" name="topics"
						onclick="checkSelected(this.checked)" value="technologies" />
						Technologies</td>
				</tr>
				<c:forEach items="${technologies}" var="techlist">
					<tr>
						<td class="alt2">${techlist.technologyName}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<table class="product">
			<tbody>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td align="center" class="tcat"><input type="checkbox"
						class="checkbox" name="topics"
						onclick="checkSelected(this.checked)" value="onlinetest" />
						Online Test</td>
				</tr>
				<c:forEach items="${quest}" var="questlist">
					<tr>
						<td class="alt2">${questlist.questDesc}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</form>
</div>