<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<div id="contentBox">

	<div id="header">
		<span>
			<div id="headerTitle">
				<tiles:insertAttribute name="header" />
			</div>
		</span>
	</div>

	<div id="accountContent2" class="full-wid" style="min-height: 500px;">
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="viewComm" />
		<tiles:insertAttribute name="addComm" />
	</div>

	<div id="footer">
		<tiles:insertAttribute name="footer" />
	</div>
</div>