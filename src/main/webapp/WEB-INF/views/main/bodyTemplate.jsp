<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Neo Trainer</title>
<meta name="description" content="">
	<meta name="keywords" content="">
		<meta http-equiv="Content-Type"
			content="text/html; charset=iso-8859-1">
			<link href="<%=request.getContextPath()%>/resources/css/style.css"
				rel="stylesheet" type="text/css">
</head>
<body>
	<div id="contentBox">

		<div id="header">
			<span>
				<div id="headerTitle">
					<tiles:insertAttribute name="header" />

					<div class="content-left">
						<div id="body">
							<tiles:insertAttribute name="body" />

						</div>
						<p id="back-top" style="display: block;"><a href="#top"><span></span>Top</a></p> 
					</div>
					<div id="right" style="margin-left: 102%;">
						<tiles:insertAttribute name="right" />

					</div> 
				</div>
			</span>
		</div>

		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>