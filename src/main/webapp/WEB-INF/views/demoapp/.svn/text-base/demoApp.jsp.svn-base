<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 15px 0 15px 0;" class="inner_txt">
	<table width="100%" cellspacing="1" cellpadding="2" bgcolor="#999999"
		class="bdytxt">
		<tbody> 
			<tr> 
				<td align="center" width="22%"><strong>Project
						Name</strong></td>
				<td align="center" width="22%"><strong>Project
						Description</strong></td>
				<td align="center" width="12%"><strong>Download</strong></td>
			</tr>
			<c:forEach var="listItems" items="${demoApp}">

				<tr> 
					<td align="center" width="22%" bgcolor="#EFF3EC"><strong>${listItems.fileName}
					</strong></td>
					<td align="center" width="22%" bgcolor="#EFF3EC"><strong>${listItems.description}
							</strong></td>
					<td align="center" width="12%" bgcolor="#EFF3EC"><strong><a
							href="<%=request.getContextPath()%>/resources/demoapp/${key}/${listItems.fileName}">
								<img src="resources/images/download.png" alt="" height="36"
								width="36">
						</a></strong></td> 
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	</body>
</html>


