<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div>
	<c:if test="${!empty posts}">
		<table class="product">
			<tbody>
				<tr>
					<td align="center" class="tcat">Blogger</td>
				</tr>
				<c:forEach items="${posts}" var="postslist">
					<tr>
					<td class="alt2"><a href="showPost.htm?grpName=${postslist.groupPost.groupName}#${postslist.postId}" style="text-decoration: none; ">${postslist.getPostTitle()}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<c:if test="${!empty article}">
		<table class="product">
			<tbody>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td align="center" class="tcat">Articles</td>
				</tr>
				<c:forEach items="${article}" var="articlelist">
					<tr>
						<td class="alt2"><a href="viewArticle.htm?articleTitle=${articlelist.getTitle()}" style="text-decoration: none; ">${articlelist.getTitle()}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>

	<c:if test="${!empty technologies}">

		<table class="product">
			<tbody>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td align="center" class="tcat">Technologies</td>
				</tr>
				<c:forEach items="${technologies}" var="techlist">
					<tr>
						<td class="alt2">${techlist.getTechnologyName()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<c:if test="${!empty quest}">
		<table class="product">
			<tbody>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td align="center" class="tcat">Online Test</td>
				</tr>
				<c:forEach items="${quest}" var="questlist">
					<tr>
						<td class="alt2">${questlist.getQuestDesc()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</div>
